package com.yazanmy.HajjAndUmrah_Guide;

import android.Manifest;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import static com.google.android.gms.location.LocationServices.GeofencingApi;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, LocationListener, GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener, GoogleMap.OnMapClickListener, GoogleMap.OnMarkerClickListener, ResultCallback<Status> {


    private static final String TAG = "TAG";
    private GoogleMap mMap;
    private GoogleApiClient client;
    private Button buttonname;
    LocationRequest request;
    // private LocationRequest locationRequest;
    // Defined in mili seconds.
    // This number in extremely low, and should be used only for debug
    private final int UPDATE_INTERVAL = 1000;
    private final int FASTEST_INTERVAL = 900;
    private Location lastLocation;
    private FusedLocationProviderClient mFusedLocationClient;
    Vibrator vibrator;

    public static Intent makeNotificationIntent(Context context, String msg) {
        //  Toast.makeText(context,msg, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(context, MapsActivity.class);
        intent.putExtra("NOTIFICATION MSG", msg);

        return intent;
    }

    public static void showToastMethod(Context context, String Status) {
        Toast.makeText(context, Status, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        client.connect();

    }

    GeofencingRequest geofencingRequest;

    @Override
    protected void onStop() {
        super.onStop();
        client.disconnect();
    }

    // Add the created GeofenceRequest to the device's monitoring list

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        // create GoogleApiClient
        createGoogleApi();

    }

    PendingIntent pendingIntent;

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng Makka = new LatLng(21.422512, 39.826186);



        mMap.setOnMarkerClickListener(this);
        mMap.setOnMapClickListener(this);

        markerForGeofence(Makka);

        buttonname = (Button) findViewById(R.id.btn);
        buttonname.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startGeofence();

            }
        });

    }

    private void createGoogleApi() {
        Log.d("TAG", "createGoogleApi()");
        if (client == null) {
            client = new GoogleApiClient.Builder(this)
                    .addApi(LocationServices.API)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .build();
        }
    }

    public void startGeofence() {

        if (geoFenceMarker != null) {

            Geofence geofence = createGeofence(geoFenceMarker.getPosition(), 100f);
            geofencingRequest = createGeoRequest(geofence);
            addGeoFence(geofencingRequest);
        }
    }

    private void addGeoFence(GeofencingRequest request) {

        if (client != null)
            GeofencingApi.addGeofences(client, request, createGeofencingPendingIntent())
                    .setResultCallback(this);

    }

    private PendingIntent createGeofencingPendingIntent() {

        if (pendingIntent != null) {
            return pendingIntent;
        }
        Intent intent = new Intent(this, GeofenceTrasitionService.class);
        return PendingIntent.getService(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
    }

    private GeofencingRequest createGeoRequest(Geofence geofence) {
        return new GeofencingRequest.Builder()
                // Notification to trigger when the Geofence is created
                .setInitialTrigger(GeofencingRequest.INITIAL_TRIGGER_ENTER)
                .addGeofence(geofence)
                .build();
    }

    private Geofence createGeofence(LatLng position, float radius) {
        return new Geofence.Builder()
                .setRequestId("My Geofence")//Geofence ID
                .setCircularRegion(position.latitude, position.longitude, radius)//Defining fence region
                .setExpirationDuration((60 * 60 * 1000))//Expiring date
                .setTransitionTypes(Geofence.GEOFENCE_TRANSITION_ENTER | Geofence.GEOFENCE_TRANSITION_EXIT)// Transition types that it should look for
                .build();
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

        Log.i(TAG, "onConnected()");
        getLastKnownLocation();
        // startGeofence();


    }

    // Get last known location
    private void getLastKnownLocation() {
        Log.d("TAG", "getLastKnownLocation()");
        if (checkPermission()) {
            lastLocation = LocationServices.FusedLocationApi.getLastLocation(client);
            if (lastLocation != null) {
                Log.i(TAG, "LasKnown location. " +
                        "Long: " + lastLocation.getLongitude() +
                        " | Lat: " + lastLocation.getLatitude());
                writeLastLocation();
                startLocationUpdates();
            } else {
                Log.w(TAG, "No location retrieved yet");
                startLocationUpdates();
            }
        } else askPermission();
    }

    // Start location Updates
    private void startLocationUpdates() {
        Log.i(TAG, "startLocationUpdates()");
        request = LocationRequest.create()
                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
                .setInterval(UPDATE_INTERVAL)
                .setFastestInterval(FASTEST_INTERVAL);

        if (checkPermission())
            LocationServices.FusedLocationApi.requestLocationUpdates(client, request, this);
    }

    @Override
    public void onLocationChanged(Location location) {
        Log.d(TAG, "onLocationChanged [" + location + "]");
        lastLocation = location;


        LatLng MyLocation = new LatLng(location.getLatitude(), location.getLongitude());
        mMap.addMarker(new MarkerOptions().position(MyLocation).title("Marker my"));
        float zoomLevel = 17.0f; //This goes up to 21
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(MyLocation, zoomLevel));

        writeActualLocation(location);
    }

    // Write location coordinates on UI
    private void writeActualLocation(Location location) {


        // System.out.println("Lat: " + location.getLatitude());
        // System.out.println("Long: " + location.getLongitude() );

    }

    private void writeLastLocation() {
        writeActualLocation(lastLocation);
    }

    private boolean checkPermission() {
        Log.d(TAG, "checkPermission()");
        // Ask for permission if it wasn't granted yet
        return (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED);
    }

    // Asks for permission
    private void askPermission() {
        Log.d(TAG, "askPermission()");
        ActivityCompat.requestPermissions(
                this,
                new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                101
        );
    }

    // Verify user's response of the permission requested
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        Log.d(TAG, "onRequestPermissionsResult()");
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 101: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission granted
                    getLastKnownLocation();

                } else {
                    // Permission denied
                    permissionsDenied();
                }
                break;
            }
        }
    }

    Marker geoFenceMarker;

    // App cannot work without the permissions
    private void permissionsDenied() {
        Log.w(TAG, "permissionsDenied()");
    }

    // Callback called when Map is touched
    @Override
    public void onMapClick(LatLng latLng) {

        //   markerForGeofence(latLng); // Set Marker Geofence
    }

    @Override
    public void onResult(@NonNull Status status) {
        drawGeofence();
    }

    Circle geoFenceLimits;

    private void markerForGeofence(LatLng latLng) {
        MarkerOptions markerOptions = new MarkerOptions().position(latLng).title("MAKKA");

        if (mMap != null) {
            if (geoFenceMarker != null) {
                geoFenceMarker.remove();
            }
            geoFenceMarker = mMap.addMarker(markerOptions);
        }
    }

    // Callback called when Marker is touched
    @Override
    public boolean onMarkerClick(Marker marker) {
        return false;
    }

    private void drawGeofence() {

        if (geoFenceLimits != null) {
            geoFenceLimits.remove();
        }
        CircleOptions circleOptions = new CircleOptions().center(geoFenceMarker.getPosition()).strokeColor(Color.argb(50, 70, 70, 70))
                .fillColor(Color.argb(100, 150, 150, 150)).radius(100f);

        geoFenceLimits = mMap.addCircle(circleOptions);


    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    public void CheckPermission() {
        if (ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION}, 101);
        }
    }
}
