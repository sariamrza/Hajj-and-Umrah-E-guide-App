package com.yazanmy.HajjAndUmrah_Guide.ui.Offline;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.yazanmy.HajjAndUmrah_Guide.Hajj;
import com.yazanmy.HajjAndUmrah_Guide.R;
import com.yazanmy.HajjAndUmrah_Guide.Umrah;

public class OfflineFragment extends Fragment {

    private OfflineViewModel offlineViewModel;
    private CollapsingToolbarLayout CollapsingToolbarLayout;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        offlineViewModel =
                ViewModelProviders.of(this).get(OfflineViewModel.class);
        View root = inflater.inflate(R.layout.fragment_offline, container, false);
        final TextView textView = root.findViewById(R.id.text_tools);

        final Button btn1 = root.findViewById(R.id.Umrah_btn);
        CollapsingToolbarLayout = (CollapsingToolbarLayout) root.findViewById(R.id.colla);
        //CollapsingToolbarLayout.setTitle(("jj"));


        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getActivity(), Umrah.class);
                startActivity(intent);
            }
        });

        final Button btn2 = root.findViewById(R.id.Hajj_btn);

        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getActivity(), Hajj.class);
                startActivity(intent);
            }
        });


        offlineViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}