package com.wipro.viewmodeldemo;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.Random;

public class MainActivityViewModel extends AndroidViewModel {
    private String name = "UNKNOWN";
    private static final String TAG = "MainActivityViewModel";
    private int code = 0; // viewmmodel retains the value and not changes everytime

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }

    String getName(String name){
        Log.e(TAG, "getName: called");
        this.name = name;
        Random random = new Random();
        if(code == 0)
            code = random.nextInt(100-1)+1;
        return "Hi "+this.name +" ! Welcome to ViewModelDemo - "+code;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.e(TAG, "onCleared: called");
    }
}


//viewModel retains in the memory the activity that created the model is not finished completely
//we can use the same viewModel for more than one activity, if one activity finishes the activity that will not affect the viewModel attached to another activity.
