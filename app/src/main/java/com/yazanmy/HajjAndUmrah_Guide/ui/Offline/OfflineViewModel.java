package com.yazanmy.HajjAndUmrah_Guide.ui.Offline;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class OfflineViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public OfflineViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Offline fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}