package com.yazanmy.HajjAndUmrah_Guide;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.icu.util.Calendar;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.github.msarhan.ummalqura.calendar.UmmalquraCalendar;

public class Enter extends AppCompatActivity {
    private TextView Count;
    private TextView Doua;
    private TextView T1;
    private Button Btn;
    private Button Btn2;
    private int c;
    private String[] Shot;
    private int F = 0;
    double x, y, z = 0;
    private UmmalquraCalendar cal;

    private LocationManager mLocationManager;
    private double FirstLatitude;
    private double FirstLongitude;
    private Location FiistLocation;
    int LOCATION_REFRESH_TIME = 1000;
    int LOCATION_REFRESH_DISTANCE = 3;

    Vibrator vibrator;

    private final LocationListener mLocationListener = new LocationListener() {
        @Override
        public void onLocationChanged(final Location location) {

            if (F == 0) {
                FiistLocation = location;
                location.setLatitude(21.4224929);
                location.setLongitude(39.8262656);
                FirstLatitude = location.getLatitude();
                FirstLongitude = location.getLongitude();
                F++;
            }

            System.out.print("Latitude : " + location.getLatitude());
            System.out.println("  Longitude : " + location.getLongitude());

            System.out.print("FirstLatitude : " + FirstLatitude);
            System.out.println("  FirstLongitude : " + FirstLongitude);


            System.out.println("  Distance : " + location.distanceTo(FiistLocation));
            System.out.println("  Bearing : " + location.bearingTo(FiistLocation));

            if (location.distanceTo(FiistLocation) <= 40.0 && (location.bearingTo(FiistLocation)) >= -90 && (location.bearingTo(FiistLocation)) <= -75) {
                inc();


            }


        }


        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);
        Shot = new String[8];
        getSupportActionBar().setTitle(getString(R.string.Title_Tawaf));

        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        LocationManager mLocationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, LOCATION_REFRESH_TIME,
                LOCATION_REFRESH_DISTANCE, mLocationListener);

        MapsActivity m = new MapsActivity();
        m.startGeofence();
        cal = new UmmalquraCalendar();

        Count = (TextView) (findViewById(R.id.textView2));
        T1 = (TextView) (findViewById(R.id.textView3));
        Doua = (TextView) (findViewById(R.id.textView4));
        Btn = (Button) (findViewById(R.id.button5));
        Btn2 = (Button) (findViewById(R.id.button3));
        c = 0;

        Shot[0] = " اللهم انى انسألك باسمك الذى يمشى به على ظلل الماء ، كما يمشى به على جدد الارض ، وأسألك باسمك الذى تهتز به اقدام ملائكتك ، واسألك باسمك الذى دعاك به موسى من جانب الطور ، فاستجبت له ، والقيت عليه محبة منك ، واسألك باسمك الذى غفرت به لمحمد ما تقدم من ذنبه وما تأخر ، وأتممت عليه نعمتك ، ان ترزقنى خير الدينا والاخرة ";
        Shot[1] = " اللهم انى فقير ، وانى خائف مستجير ، فلا تغير جسمى ، ولا تبدل اسمى سائلك فقيرك ، مسكينك ببابك ، فتصدق عليه بالجنة ، اللهم البيت بيتك ، والحرم حرمك ، والعبد عبدك ، وهذا مقام العائذ بك ، المستجير بك من النار ، فاعتقنى ووالدى واهلى وولدى واخوانى المؤمنين من النار ، يا جواد يا كريم ";
        Shot[2] = " اللهم ادخلنى الجنة ، واجرنى من النار برحمتك ، وعافنى من السقم واوسع على من الرزق الحلال ، وادرء عنى شر فسقة الجن والانس ، وشر فسقة العرب والعجم ، ياذا المن والطول ، ياذا الجود والكرم ، ان عملى ضعيف ، فضاعفه لى وتقبله منى ، انك انت السميع العليم ";
        Shot[3] = " يا الله يا الله ، يا ولى العافية وخالق العافية ، والمنعم بالعافية والمتفضل بالعافية ، على وعلى جميع خلقك ، يارحمن الدنيا والاخرة ، ورحيمهما ، صل على محمد وال محمد ، وارزقنا العافية ، وتمام العافية ، وشكر العافية ، في الدينا والاخرة يا ارحم الراحمين ";
        Shot[4] = " الحمد لله الذى شرفك وعظمك ، والحمد لله الذى بعث محمدا نبيا ، وجعل عليا اماما ، اللهم اهد له خيار خلقك ، وجنبه شرار خلقك ، ربنا اتنا في الدنيا حسنة ، وفي الاخرة حسنة ، وقنا عذاب النار ";
        Shot[5] = " اللهم ان عندى افواجا من ذنوب ، وافواجا من خطايا ، وعندك افواج من رحمة ، وافواج من رحمة ، وافواج من مغفرة ، يا من استجاب لا بعض خلقه ، اذ قال انظرنى الى يوم يبعثون ، استجب لى ، اللهم اقنعنى بما رزقتنى ، وبارك لى بما اتيتنى ";
        Shot[6] = " اللهم البيت بيتك ، والعبد عبدك ، وهذا مقام العائذ بك من النار ، اللهم من قبلك الروح والفرج والعافية ، اللهم ان عملى ضعيف فضاعفة لى ، واغفر لى ما اطلعت عليه منى ، وخفى على خلقك ، استجير بالله من النار ";
        Shot[7] = " اللهم البيت بيتك ، والعبد عبدك ، وهذا مقام العائذ بك من النار ، اللهم من قبلك الروح والفرج والعافية ، اللهم ان عملى ضعيف فضاعفة لى ، واغفر لى ما اطلعت عليه منى ، وخفى على خلقك ، استجير بالله من النار ";

        Doua.setText(Shot[c]);


    }

    public void inc() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            vibrator.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE));
        } else {
            vibrator.vibrate(200);
        }

        c++;
        if (c < 8) {
            Doua.setText(Shot[c]);
            Count.setText(String.valueOf(c));
        } else {
            c = 8;
            // Count.setText(String.valueOf(c));
            Count.setText(R.string.Text_Done);
            Count.setTextColor(ContextCompat.getColor(this, R.color.flatui_emerald));

            if (cal.get(Calendar.MONTH) == 11) {
                startActivity(new Intent(Enter.this, Tutorial2.class));

            } else {

                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setTitle("الصلاة عند المقام");
                alert.setMessage("من السنّة للشّخص المعتمر عندما يتوجّه للصّلاة في المقام أن يبدأ بتلاوة قوله تعالى «وَاتَّخِذُوا مِنْ مَقَامِ إِبْرَاهِيمَ مُصَلًّى»، ومن السنّة كذلك أن يصلّي المعتمر ركعتين بعد إتمامه طوافه، ويستطيع بعد الصلاة أن يشرب من ماء زمزم ويلمس الحجر الأسود . ");
                //alert.setIcon();

                alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        startActivity(new Intent(Enter.this, Saffa.class));
                    }
                });
                alert.show();
            }






          /*  Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // do something
                    startActivity(new Intent(Enter.this, Saffa.class));
                    // If you just use this that is not a valid context. Use ActivityName.this
                }
            }, 1000);*/


        }
    }

    private void dec() {

        c--;
        if (c < 8) {
            Doua.setText(Shot[c]);
            Count.setText(String.valueOf(c));
        } else {
            c = 8;
            Count.setText("Done");
            Count.setTextColor(ContextCompat.getColor(this, R.color.flatui_emerald));


            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("الصلاة عند المقام");
            alert.setMessage("من السنّة للشّخص المعتمر عندما يتوجّه للصّلاة في المقام أن يبدأ بتلاوة قوله تعالى «وَاتَّخِذُوا مِنْ مَقَامِ إِبْرَاهِيمَ مُصَلًّى»، ومن السنّة كذلك أن يصلّي المعتمر ركعتين بعد إتمامه طوافه، ويستطيع بعد الصلاة أن يشرب من ماء زمزم ويلمس الحجر الأسود . ");
            //alert.setIcon();

            alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {

                    startActivity(new Intent(Enter.this, Saffa.class));
                }
            });
            alert.show();




          /*  Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // do something
                    startActivity(new Intent(Enter.this, Saffa.class));
                    // If you just use this that is not a valid context. Use ActivityName.this
                }
            }, 1000);*/


        }

    }

    public void rest(View view) {
        c = 0;
        Doua.setText(Shot[c]);
        Count.setText(String.valueOf(c));

        //startActivity(new Intent(Enter.this, Saffa.class));

    }

    public void inc(View view) {
        inc();
    }

    public void dec(View view) {
        if (c != 0)
            dec();
    }


    // Function to find distance
    static void shortest_distance(double x1, double y1,
                                  double a, double b,
                                  double c) {
        double d = Math.abs(((a * x1 + b * y1 + c)) /
                (Math.sqrt(a * a + b * b)));
        System.out.println("Perpendicular " +
                "distance is " + d);
        return;
    }

    // Function to find the line given two points
    void lineFromPoints(Pair P, Pair Q) {
        x = Q.second - P.second;
        y = P.first - Q.first;
        z = x * (P.first) + y * (P.second);


    }


}

class Pair {
    double first, second;

    public Pair(double first, double second) {
        this.first = first;
        this.second = second;
    }


}