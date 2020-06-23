package com.yazanmy.HajjAndUmrah_Guide;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.hololo.tutorial.library.Step;
import com.hololo.tutorial.library.TutorialActivity;

public class Tutorial2 extends TutorialActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addFragment(new Step.Builder().setTitle("التوجه إلى منى والمبيت بها")
                .setContent("ثم في صباح اليوم الثامن من ذي الحجة (ويسمي يوم التروية) تتوجه إلى منطقة (منى) وهي منطقة مجاورة لمكة المكرمة وتقضي اليوم هناك وتبيت هناك وتصلي الصلوات هناك في مواقيتها قصرا دون جمع.")
                .setBackgroundColor(Color.parseColor("#82ccdd")) // int background color
                .setDrawable(R.drawable.mona) // int top drawable
                .setSummary("This is summary")
                .build());
        addFragment(new Step.Builder().setTitle(("الوقوف بعرفة"))
                .setContent("ثم في صباح اليوم التالي وهو التاسع من ذي الحجة (ويسمي يوم عرفة) تتوجه بعد الشروق إلى منطقة (عرفة) وهي مجاورة لمكة أيضا ولكن بعد منطقة (مني) بعدة كيلو مترات. وتصلي الظهر والعصر جمعا وقصرا بمسجد نمرة (وهو على حدود عرفة جزء منه فيها وجزء منه خارجها) وتقضي اليوم بعرفة حتى غروب الشمس في دعاء وذكر وابتهال إلى الله تعالى.")
                .setBackgroundColor(Color.parseColor("#60a3bc"))
                .setDrawable(R.drawable.arafa)
                .setSummary("This is summary")
                .build());

        addFragment(new Step.Builder().setTitle(("لمبيت بمزدلفة"))
                .setContent("بعد غروب شمس اليوم التاسع من ذي الحجة (يوم عرفة) تنطلق إلى منطقة (مزدلفة) وهي منطقة بين (منى) و (عرفة) ، وتصلي فيها المغرب والعشاء جمعا وقصرا وتبيت الليلة هناك حتى الفجر (وقد رخص النبي صلى الله عليه وسلم للنساء والعجزة في الإفاضة الى المسجد الحرام بعد نصف الليل).")
                .setBackgroundColor(Color.parseColor("#3c6382"))
                .setDrawable(R.drawable.mozdlfa)
                .setSummary("This is summary")
                //.setFinishText("هيا للطواف") // Finish button text
                .build());

        ///
        addFragment(new Step.Builder().setTitle(("رمي الجمرة الكبرى والذبح والحلق وطواف الإفاضة"))
                .setContent("عد صلاة الفجر يوم العاشر من ذي الحجة (ويسمى يوم النحر أو يوم الحج الأكبر) وهو يوم عيد الأضحى المبارك : تتوجه من منطقة (مزدلفة) إلى منطقة (منى) حيث توجد الجمرات الثلاثة. وتأخذ معك عدد (7) حصيات بحجم حبة الفول تقريبا : حيث تقوم برمي الجمرة الكبرى (وتسمى جمرة العقبة) ، ثم تقوم بذبح الهدي ،ثم تقوم بحلاقة رأسك أو تقصير شعرك (والحلاقة أفضل طبعا) وبالنسبة للنساء تقص من شعرها قدر أنملة - وبذلك تكون تحللت من إحرامك التحلل الأول (الأصغر) فتحل لك كل محظورات الإحرام إلا النساء - ثم تتوجه إلى البيت الحرام فتطوف بالكعبة المشرفة سبعة أشواط وهو طواف الحج (ويسمى طواف الإفاضة أو طواف الزيارة أوطواف الحج أو طواف الركن) ، ثم تصلى ركعتين وراء مقام إبراهيم أو في أي مكان من الحرم الشريف ، ثم تتوجه إلى الصفا فتبدأ السعي بين الصفا والمروة سبعة أشواط تبدأ من الصفا وتنتهي عند المروة. ثم تعود إلى منطقة (منى) للمبيت هناك")
                .setBackgroundColor(Color.parseColor("#3c6382"))
                .setDrawable(R.drawable.hjarat)
                .setSummary("This is summary")
                //.setFinishText("هيا للطواف") // Finish button text
                .build());

        addFragment(new Step.Builder().setTitle(("المبيت بمنى ورمي الجمرات الثلاث في أيام التشريق الثلاثة"))
                .setContent("بعد صلاة الظهر من يوم الحادي عشر من ذي الحجة (ويسمى يوم القر أو اليوم الأول من أيام التشريق الثلاثة) تتوجه إلى الجمرات آخذا معك عدد (21) حصاة فترمي الجمرة الصغرى بسبعة حصيات ، ثم تدعو الله عز وجل دعاء طويلا ، ثم ترمي الجمرة الوسطى بسبعة حصيات، ثم تدعو الله عز وجل دعاء طويلا ، ثم ترمي الجمرة الكبرى (جمرةالعقبة) بسبعة حصيات ثم تنصرف. وتمكث اليوم في (منى) وتبيت بها.")
                .setBackgroundColor(Color.parseColor("#3c6382"))
                .setDrawable(R.drawable.mona)
                .setSummary("This is summary")
                //.setFinishText("هيا للطواف") // Finish button text
                .build());

        addFragment(new Step.Builder().setTitle(("العودة"))
                .setContent("في اليوم الثاني عشر من ذي الحجة (وهو اليوم الثاني من أيام التشريق ويسمى يوم النفر الأول) تفعل نفس ما فعلته في اليوم الحادي عشر من ذي الحجة. ثم تعود الى (منى) للمبيت بها إلا إذا كنت متعجلا فتقوم بعد الرمي بالتوجه الى المسجد الحرام لتطوف طواف الوداع ثم تتوجه راجعاً إلى بلدك.")
                .setBackgroundColor(Color.parseColor("#3c6382"))
                .setDrawable(R.drawable.back)
                .setSummary("This is summary")
                //.setFinishText("هيا للطواف") // Finish button text
                .build());

    }

    @Override
    public void finishTutorial() {
        Toast.makeText(Tutorial2.this, "Tutorial finished", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Tutorial2.this, MapsActivity.class);
        startActivity(intent);
    }

    @Override
    public void currentFragmentPosition(int position) {
        Toast.makeText(this, "Position : " + position, Toast.LENGTH_SHORT).show();
    }
}