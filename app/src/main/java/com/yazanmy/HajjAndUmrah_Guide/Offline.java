package com.yazanmy.HajjAndUmrah_Guide;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Offline extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offline);
    }

    public void Btn_Umrah(View view) {

        startActivity(new Intent(Offline.this, Umrah.class));


    }

    public void Btn_Hajj(View view) {
        startActivity(new Intent(Offline.this, Hajj.class));


    }
}
