package com.yazanmy.HajjAndUmrah_Guide.ui.StartGeo;

import android.content.DialogInterface;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.github.msarhan.ummalqura.calendar.UmmalquraCalendar;
import com.yazanmy.HajjAndUmrah_Guide.MapsActivity;
import com.yazanmy.HajjAndUmrah_Guide.R;
import com.yazanmy.HajjAndUmrah_Guide.Tutorial;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class StartGeoFragment extends Fragment {

    private StartGeoViewModel startGeoViewModel;
    private UmmalquraCalendar cal;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        startGeoViewModel =
                ViewModelProviders.of(this).get(StartGeoViewModel.class);
        View root = inflater.inflate(R.layout.fragment_start, container, false);
        final TextView textView = root.findViewById(R.id.text_gallery);
        final TextView Hajjri = root.findViewById(R.id.textView);
        final Button Umarah = root.findViewById(R.id.startUmrah);
        final Button Hajj = root.findViewById(R.id.startHajj);


        cal = new UmmalquraCalendar();
        SimpleDateFormat dateFormat = new SimpleDateFormat("", new Locale("ar"));
        dateFormat.setCalendar(cal);
        //dateFormat.applyPattern("EEEE d MMMM, y");

        dateFormat.applyPattern("EEEE d ");
        // Hajjri.setText( dateFormat.format(cal.getTime()));
        String temp = dateFormat.format(cal.getTime()) + " " + cal.getDisplayName(Calendar.MONTH, (java.util.Calendar.LONG), new Locale("ar")) + ", ";
        Hajjri.setText(temp + cal.get(Calendar.YEAR));

        if (cal.get(Calendar.MONTH) == 11) {
            Umarah.setEnabled(false);
            Umarah.setBackground(getResources().getDrawable(R.drawable.btn_danger));
            Umarah.setTextColor(getResources().getColor(R.color.flatui_pomegranate));

        } else {
            Hajj.setEnabled(false);
            Hajj.setBackground(getResources().getDrawable(R.drawable.btn_danger));
            Hajj.setTextColor(getResources().getColor(R.color.flatui_pomegranate));


        }

        Umarah.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                if (cal.get(Calendar.MONTH) == 11) {
                    AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
                    alert.setTitle("تحذير");
                    alert.setMessage("هذا الخيار غير متاح في شهر ذو الحجة");
                    //alert.setIcon();

                    alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    alert.show();

                } else {

                    Intent intent = new Intent(getActivity(), MapsActivity.class);
                    startActivity(intent);
                }


            }
        });

        Hajj.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (cal.get(Calendar.MONTH) != 11) {

                    AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
                    alert.setTitle("تحذير");
                    alert.setMessage("هذا الخيار متاح فقط في شهر ذو الحجة");
                    //alert.setIcon();
                    alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    alert.show();
                } else {

                    Intent intent = new Intent(getActivity(), Tutorial.class);
                    startActivity(intent);
                }

            }
        });


        startGeoViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}