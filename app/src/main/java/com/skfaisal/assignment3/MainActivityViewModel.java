package com.skfaisal.assignment3;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class MainActivityViewModel extends AndroidViewModel {
    public MutableLiveData<String> counterValue = new MutableLiveData<>();
    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        Log.d("chkvalue","init viewmodel");
    }
    void incrementValue()
    {
        if(counterValue.getValue()==null)
        {
            counterValue.setValue(""+0);
        }
        else {
            int value = Integer.parseInt(counterValue.getValue());
            value = value + 1;
            counterValue.setValue(""+value);
            Log.d("chk","data:"+value);
            Log.d("chk","data2:"+counterValue.getValue());
        }
    }
    void decrementValue()
    {
        int value = Integer.parseInt(counterValue.getValue());
        value = value - 1;
        counterValue.setValue(""+value);
        Log.d("chk","data:"+value);
        Log.d("chk","data2:"+counterValue.getValue());
    }
}
