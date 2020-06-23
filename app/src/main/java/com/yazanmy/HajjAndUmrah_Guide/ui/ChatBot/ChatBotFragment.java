package com.yazanmy.HajjAndUmrah_Guide.ui.ChatBot;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.yazanmy.HajjAndUmrah_Guide.ChatBot.MainChatBot;
import com.yazanmy.HajjAndUmrah_Guide.R;

public class ChatBotFragment extends Fragment {

    private ChatBotViewModel chatBotViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        chatBotViewModel =
                ViewModelProviders.of(this).get(ChatBotViewModel.class);
        View root = inflater.inflate(R.layout.fragment_chatbot, container, false);

        startActivity(new Intent(getContext(), MainChatBot.class));

        final Button btn = root.findViewById(R.id.button7);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                startActivity(new Intent(getContext(), MainChatBot.class));

            }
        });

        return root;
    }


}
