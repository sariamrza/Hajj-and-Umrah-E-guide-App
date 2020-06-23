package com.yazanmy.HajjAndUmrah_Guide;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.hololo.tutorial.library.Step;
import com.hololo.tutorial.library.TutorialActivity;

public class Tutorial extends TutorialActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addFragment(new Step.Builder().setTitle("الاحرام")
                .setContent("يُحرِم المسّلم للحجّ، ويغتسل إن أمكنه ذلك، ويلبس ثياب الإحرام، ويردّد التّلبية بقول: (لبّيك حجّاً، لبّيك اللهمّ لبّيك، لبّيك لا شريك لك لبّيك ، إنّ الحمد والنّعمة لك والملك لا شريك لك).")
                .setBackgroundColor(Color.parseColor("#82ccdd")) // int background color
                .setDrawable(R.drawable.ahram) // int top drawable
                .build());
        // Permission Step
        addFragment(new Step.Builder().setTitle(("التلبية"))
                .setContent("وفور إحرامك تبدأ في التلبية ، ولا تتوقف عن التلبية إلا بعد رمي جمرة العقبة الكبرى في يوم النحر(يوم عيد الأضحى).")
                .setBackgroundColor(Color.parseColor("#60a3bc"))
                .setDrawable(R.drawable.talbya)
                .build());

        addFragment(new Step.Builder().setTitle(("الطواف"))
                .setContent("طواف القدوم: ثم تتوجه إلى مكة حيث تقصد المسجد الحرام لتطوف بالبيت سبعة أشواط (طواف القدوم). وتبقى في مكة إلى أن يأتي اليوم الثامن من ذي الحجة (يوم التروية).")
                .setBackgroundColor(Color.parseColor("#3c6382"))
                .setDrawable(R.drawable.tawaf)
                //.setFinishText("هيا للطواف") // Finish button text
                .build());

    }

    @Override
    public void finishTutorial() {
        Toast.makeText(com.yazanmy.HajjAndUmrah_Guide.Tutorial.this, "Tutorial finished", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Tutorial.this, MapsActivity.class);
        startActivity(intent);
    }

    @Override
    public void currentFragmentPosition(int position) {
        Toast.makeText(this, "Position : " + position, Toast.LENGTH_SHORT).show();
    }
}