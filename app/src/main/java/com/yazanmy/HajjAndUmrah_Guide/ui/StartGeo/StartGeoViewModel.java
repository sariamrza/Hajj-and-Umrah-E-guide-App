package com.yazanmy.HajjAndUmrah_Guide.ui.StartGeo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class StartGeoViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public StartGeoViewModel() {
        mText = new MutableLiveData<>();


    }

    public LiveData<String> getText() {
        return mText;
    }
}