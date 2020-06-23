package com.yazanmy.HajjAndUmrah_Guide;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
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

public class Saffa extends AppCompatActivity {

    private TextView Count;
    private TextView Doua;
    private TextView Text;
    private TextView T1;
    private Button Btn;
    private Button Btn2;
    private int c;
    private int F = 0;
    private String[] Shot;
    private LocationManager mLocationManager;
    private double SaffaLatitude;
    private double SaffaLongitude;
    private Location SaffaLocation;
    private double MarwaLatitude;
    private double MarwaLongitude;
    private Location MarwaLocation;
    int LOCATION_REFRESH_TIME = 1000;
    int LOCATION_REFRESH_DISTANCE = 3;
    Vibrator vibrator;

    private final LocationListener mLocationListener = new LocationListener() {
        @Override
        public void onLocationChanged(final Location location) {

            if (F == 0) {
                SaffaLocation = new Location("S");
                SaffaLocation.setLatitude(21.422050);
                SaffaLocation.setLongitude(39.827517);
                SaffaLatitude = SaffaLocation.getLatitude();
                SaffaLongitude = SaffaLocation.getLongitude();

                MarwaLocation = new Location("a");
                MarwaLocation.setLatitude(21.424889);
                MarwaLocation.setLongitude(39.827220);
                MarwaLatitude = MarwaLocation.getLatitude();
                MarwaLongitude = MarwaLocation.getLongitude();
                F++;
            }
            System.out.println(" ---------------------");

            System.out.print("Latitude : " + location.getLatitude());
            System.out.println("  Longitude : " + location.getLongitude());

            System.out.print("SaffaLatitude : " + SaffaLatitude);
            System.out.println("  SaffaLongitude : " + SaffaLongitude);

            System.out.print("MarwaLatitude : " + MarwaLatitude);
            System.out.println("  MarwaLatitude : " + MarwaLongitude);

            System.out.println("  Distance : " + location.distanceTo(SaffaLocation));
            System.out.println("  Bearing : " + location.bearingTo(SaffaLocation));

            System.out.println("  Distance Marawa  : " + location.distanceTo(MarwaLocation));
            System.out.println("  Bearing : " + location.bearingTo(MarwaLocation));


            if (location.distanceTo(SaffaLocation) <= 15 || location.distanceTo(MarwaLocation) <= 15) {
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
        setContentView(R.layout.activity_saffa);
        Shot = new String[8];
        getSupportActionBar().setTitle(getString(R.string.Title_Saffa));

        Count = (TextView) (findViewById(R.id.textView2));
        T1 = (TextView) (findViewById(R.id.textView3));
        Doua = (TextView) (findViewById(R.id.textView4));
        //Text = (TextView) (findViewById(R.id.textView));
        Btn = (Button) (findViewById(R.id.button5));
        c = 0;

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


        Shot[0] = "الله أكبر الله أكبر الله أكبر كبيرا والحمد لله كثيرا وسبحان الله العظيم وبحمده الكريم بكرة وأصيلا ومن الليل فاسجد له وسبحه ليلا طويلا، لا إله إلا الله وحده أنجز وعده ونصر عبده وهزم الأحزاب وحده لا شيء قبله ولا بعده يحيي ويميت وهو حي دائم لا يموت ولا يفوت أبدا بيده الخير وإليه المصير وهو على كل شيء قدير. (رب اغفر وارحم واعف وتكرم وتجاوز عما تعلم إنك تعلم ما لا نعلم إنك أنت الله الأعز الأكرم) ربنا نجنا من النار سالمين غانمين فرحين مستبشرين مع عبادك الصالحين مع الذين أنعم الله عليهم من النبيين والصديقين والشهداء والصالحين وحسن أولئك رفيقا ذلك الفضل من الله وكفى بالله عليما لا إله إلا الله حقاً حقا. لا إله إلا الله تعبداً ودقاً. لا إله إلا لله ولا نعبد إلا إياه مخلصين له الدين ولو كره الكافرون. (إن الصفا والمروة من شعائر الله فمن حج البيت أو اعتمر فلا جناح عليه أن يطوف بهما ومن تطوع خيراً فإن الله شاكر عليم). (ثم يدعو بما شاء)\tالله أكبر الله أكبر الله أكبر كبيرا والحمد لله كثيرا وسبحان الله العظيم وبحمده الكريم بكرة وأصيلا ومن الليل فاسجد له وسبحه ليلا طويلا، لا إله إلا الله وحده أنجز وعده ونصر عبده وهزم الأحزاب وحده لا شيء قبله ولا بعده يحيي ويميت وهو حي دائم لا يموت ولا يفوت أبدا بيده الخير وإليه المصير وهو على كل شيء قدير. (رب اغفر وارحم واعف وتكرم وتجاوز عما تعلم إنك تعلم ما لا نعلم إنك أنت الله الأعز الأكرم) ربنا نجنا من النار سالمين غانمين فرحين مستبشرين مع عبادك الصالحين مع الذين أنعم الله عليهم من النبيين والصديقين والشهداء والصالحين وحسن أولئك رفيقا ذلك الفضل من الله وكفى بالله عليما لا إله إلا الله حقاً حقا. لا إله إلا الله تعبداً ودقاً. لا إله إلا لله ولا نعبد إلا إياه مخلصين له الدين ولو كره الكافرون. (إن الصفا والمروة من شعائر الله فمن حج البيت أو اعتمر فلا جناح عليه أن يطوف بهما ومن تطوع خيراً فإن الله شاكر عليم).";
        Shot[1] = "الله أكبر الله أكبر الله أكبر ولله الحمد لا إله إلا الله الواحد الأحد الفرد الصمد الذي لم يتخذ صاحبة ولا ولدا ولم يكن له شريك في الملك ولم يكن له ولي من الذل وكبره تكبيرا. اللهم إنك قلت في كتابك المنزل \"ادعوني استجب لكم\" دعوناك ربنا فاغفر لنا كما أمرتنا إنك لا تخلف الميعاد، ربنا إننا سمعنا منادياً ينادي للإيمان أن آمنوا بربكم فآمنا ربنا فاغفر لنا ذنوبنا وكفر عنا سيئاتنا وتوفنا مع الأبرار، ربنا وآتنا ما وعدتنا على رسلك ولا تخزنا يوم القيامة إنك لا تخلف الميعاد، ربنا عليك توكلنا وإليك أنبنا وإليك المصير ربنا اغفر لنا ولإخواننا الذين سبقونا بالإيمان ولا تجعل في قلوبنا غلاً للذين آمنوا ربنا إنك رؤوف رحيم.(رب اغفر وارحم واعف وتكرم وتجاوز عما تعلم إنك تعلم ما لا نعلم إنك أنت الله الأعز الأكرم)، (إن الصفا والمروة من شعائر الله فمن حج البيت أو اعتمر فلا جناح عليه أن يطوف بهما ومن تطوع خيراً فإن الله شاكر عليم). ";
        Shot[2] = "الله أكبر الله أكبر الله أكبر ولله الحمد ربنا أتمم لنا نورنا واغفر لنا إنك على كل شيء قدير، اللهم إني أسألك الخير كله عاجله وآجله وأستغفرك لذنبي وأسألك رحمتك يا أرحم الراحمين (رب اغفر وارحم واعف وتكرم وتجاوز عما تعلم إنك تعلم ما لا نعلم إنك أنت الله الأعز الأكرم) رب زدني علما ولا تزغ قلبي بعد إذ هديتني وهب لي من لدنك رحمة إنك أنت الوهاب، اللهم عافني في سمعي وبصري لا إله إلا أنت، اللهم إني أعوذ بك من عذاب القبر لا إله إلا أنت سبحانك إني كنت من الظالمين، اللهم إني أعوذ بك من الكفر والفقر، اللهم إني أعوذ برضاك من سخطك وبمعافاتك من عقوبتك وأعوذ بك منك لا أحصي ثناء عليك أنت كما أثنيت على نفسك فلك الحمد حتى ترضى (إن الصفا والمروة من شعائر الله فمن حج البيت أو اعتمر فلا جناح عليه أن يطوف بهما ومن تطوع خيراً فإن الله شاكر عليم). ";
        Shot[3] = "الله أكبر الله أكبر الله أكبر ولله الحمد، اللهم إني أسألك من خير ما تعلم وأعوذ بك من شر ما تعلم وأستغفرك من كل ما تعلم إنك أنت علام الغيوب، لا إله إلا الله الملك الحق المبين محمد رسول الله الصادق الوعد الأمين، اللهم إني أسألك كما هديتني للإسلام أن لا تنزعه مني حتى تتوفاني وأنا مسلم، اللهم اجعل في قلبي نوراً وفي سمعي نوراً وفي بصري نورا، اللهم اشرح لي صدري ويسر لي أمري وأعوذ بك من شر وساوس الصدر وشتات الأمر وفتنة القبر، اللهم أني أعوذ بك من شر ما يلج في الليل وشر ما يلج في النهار ومن شر ما تهب به الرياح يا أرحم الراحمين، سبحانك ما عبدناك حق عبادتك يا الله، سبحانك ما ذكرناك حق ذكرك يا الله. (رب اغفر وارحم واعف وتكرم وتجاوز عما تعلم إنك تعلم ما لا نعلم إنك أنت الله الأعز الأكرم)، (إن الصفا والمروة من شعائر الله فمن حج البيت أو اعتمر فلا جناح عليه أن يطوف بهما ومن تطوع خيراً فإن الله شاكر عليم).";
        Shot[4] = "الله أكبر الله أكبر الله أكبر ولله الحمد، سبحانك ما شكرناك حق شكرك يا الله سبحانك ما أعلى شأنك يا الله، اللهم حبب إلينا الإيمان وزينه في قلوبنا وكره إلينا الكفر والفسوق والعصيان واجعلنا من الراشدين (رب اغفر وارحم واعف وتكرم وتجاوز عما تعلم إنك تعلم ما لا نعلم إنك أنت الله الأعز الأكرم) اللهم قني عذابك يوم تبعث عبادك، اللهم اهدني بالهدى ونقني بالتقوى واغفر لي في الآخرة والأولى، اللهم ابسط علينا من بركاتك ورحمتك وفضلك ورزقك، اللهم إني أسألك النعيم المقيم الذي لا يحول ولا يزول أبدا، اللهم اجعل في قلبي نوراً وفي سمعي نوراً وفي بصري نوراً وفي لساني نوراً وعن يميني نوراً ومن فوقي نوراً واجعل في نفسي نوراً وعظم لي نورا، رب اشرح لي صدري ويسر لي أمري (إن الصفا والمروة من شعائر الله فمن حج البيت أو اعتمر فلا جناح عليه أن يطوف بهما ومن تطوع خيراً فإن الله شاكر عليم). ";
        Shot[5] = "الله أكبر الله أكبر الله أكبر ولله الحمد، لا إله إلا الله وحده صدق وعده ونصر عبده وهزم الأحزاب وحده لا إله إلا الله ولا نعبد إلا إياه مخلصين له الدين ولو كره الكافرون، اللهم إني أسألك الهدى والتقى والعفاف والغنى، اللهم لك الحمد كالذي تقول وخيرا مما نقول اللهم إني أسألك رضاك والجنة وأعوذ بك من سخطك والنار وما يقربني إليها من قول أو فعل أو عمل، اللهم بنورك اهتدينا وبفضلك استغنينا وفي كنفك وإنعامك وعطائك وإحسانك أصبحنا وأمسينا أنت الأول فليس قبلك شيء والآخر فليس بعدك شيء والظاهر فلا شيء فوقك والباطن فلا شيء دونك نعوذ بك من الفلس والكسل وعذاب القبر وفتنة الغنى ونسألك الفوز بالجنة (رب اغفر وارحم واعف وتكرم وتجاوز عما تعلم إنك تعلم ما لا نعلم إنك أنت الله الأعز الأكرم) (إن الصفا والمروة من شعائر الله فمن حج البيت أو اعتمر فلا جناح عليه أن يطوف بهما ومن تطوع خيراً فإن الله شاكر عليم).";
        Shot[6] = "الله أكبر الله أكبر الله أكبر كبيرا والحمد لله كثيرا، اللهم حبب إلي الإيمان وزينه في قلبي وكره إلي الكفر والفسوق والعصيان واجعلني من الراشدين (رب اغفر وارحم واعف وتكرم وتجاوز عما تعلم إنك تعلم ما لا نعلم إنك أنت الله الأعز الأكرم) اللهم اختم بالخيرات آجالنا وحقق بفضلك آمالنا وسهل لبلوغ رضاك سبلنا وحسن في جميع الأحوال أعمالنا يا منقذ الغرقى يا منجي الهلكى يا شاهد كل نجوى يا منتهى كل شكوى يا قديم الإحسان يا دائم المعروف يا من لا غنى بشيء عنه ولابد لكل شيء منه يا من رزق كل شيء عليه ومصير كل شيء إليه اللهم أني عائذ بك من شر ما أعطيتنا ومن شر ما منعتنا، اللهم توفنا مسلمين وألحقنا بالصالحين غير خزايا ولا مفتونين، رب يسر ولا تعسر، رب أتمم لنا بالخير (إن الصفا والمروة من شعائر الله فمن حج البيت أو اعتمر فلا جناح عليه أن يطوف بهما ومن تطوع خيراً فإن الله شاكر عليم). ";
        Shot[7] = "الله أكبر الله أكبر الله أكبر كبيرا والحمد لله كثيرا، اللهم حبب إلي الإيمان وزينه في قلبي وكره إلي الكفر والفسوق والعصيان واجعلني من الراشدين (رب اغفر وارحم واعف وتكرم وتجاوز عما تعلم إنك تعلم ما لا نعلم إنك أنت الله الأعز الأكرم) اللهم اختم بالخيرات آجالنا وحقق بفضلك آمالنا وسهل لبلوغ رضاك سبلنا وحسن في جميع الأحوال أعمالنا يا منقذ الغرقى يا منجي الهلكى يا شاهد كل نجوى يا منتهى كل شكوى يا قديم الإحسان يا دائم المعروف يا من لا غنى بشيء عنه ولابد لكل شيء منه يا من رزق كل شيء عليه ومصير كل شيء إليه اللهم أني عائذ بك من شر ما أعطيتنا ومن شر ما منعتنا، اللهم توفنا مسلمين وألحقنا بالصالحين غير خزايا ولا مفتونين، رب يسر ولا تعسر، رب أتمم لنا بالخير (إن الصفا والمروة من شعائر الله فمن حج البيت أو اعتمر فلا جناح عليه أن يطوف بهما ومن تطوع خيراً فإن الله شاكر عليم). ";


    }

    public void inc() {
        //Text.setVisibility(View.GONE);

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
            Count.setText("Done");
            Count.setTextColor(ContextCompat.getColor(this, R.color.flatui_emerald));
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("حلق شعر الرأس أو تقصيره");
            alert.setMessage("يعتبر الحلق أو التّقصير من واجبات العمرة إلّا أن الحلق أفضل من التّقصير وذلك للرّجل، أمّا المرأة فليس شرطًا عليها أن تقصّر شعرها، ولا يجوز لها الحلق.");
            //alert.setIcon();

            alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    startActivity(new Intent(Saffa.this, MainActivity.class));
                }
            });
            alert.show();

        }
    }

    public void inc(View view) {
        inc();
    }

    public void dec(View view) {
        if (c != 0)
            dec();
    }

    private void dec() {
        c--;
        if (c == 0)
            //Text.setVisibility(View.INVISIBLE);
            if (c < 8) {
                Doua.setText(Shot[c]);
                Count.setText(String.valueOf(c));
            } else {
                c = 8;
                Count.setText(String.valueOf(c));
                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setTitle("حلق شعر الرأس أو تقصيره");
                alert.setMessage("يعتبر الحلق أو التّقصير من واجبات العمرة إلّا أن الحلق أفضل من التّقصير وذلك للرّجل، أمّا المرأة فليس شرطًا عليها أن تقصّر شعرها، ولا يجوز لها الحلق.");
                //alert.setIcon();

                alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        startActivity(new Intent(Saffa.this, Saffa.class));
                    }
                });
                alert.show();

            }
    }

    public void rest(View view) {
        c = 0;
        Doua.setVisibility(View.INVISIBLE);
        //Text.setVisibility(View.VISIBLE);

        Count.setText(String.valueOf(c));

    }


}
