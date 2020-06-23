package com.yazanmy.HajjAndUmrah_Guide.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.yazanmy.HajjAndUmrah_Guide.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    ImageView bgapp, clover;
    LinearLayout textsplash, texthome, menus;
    Animation frombottom;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        frombottom = AnimationUtils.loadAnimation(getContext(), R.anim.frombottom);

        bgapp = (ImageView) root.findViewById(R.id.bgapp);
        clover = (ImageView) root.findViewById(R.id.clover);
        textsplash = (LinearLayout) root.findViewById(R.id.textsplash);
        texthome = (LinearLayout) root.findViewById(R.id.texthome);
        menus = (LinearLayout) root.findViewById(R.id.menus);

        bgapp.animate().translationY(-1900).setDuration(800).setStartDelay(300);
        clover.animate().alpha(0).setDuration(800).setStartDelay(600);
        textsplash.animate().translationY(140).alpha(0).setDuration(800).setStartDelay(300);

        texthome.startAnimation(frombottom);
        menus.startAnimation(frombottom);

        return root;
    }
}