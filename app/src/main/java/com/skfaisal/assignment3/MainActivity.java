package com.skfaisal.assignment3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.faisal.basemodule.base.BaseActivity;
import com.skfaisal.assignment3.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity {
private ActivityMainBinding mBinding;
private MainActivityViewModel viewModel;
    @Override
    public int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void startUI() {
        mBinding = (ActivityMainBinding) getViewDataBinding();
        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        mBinding.setViewModel(viewModel);
        mBinding.setLifecycleOwner(this);

       if(viewModel.counterValue.getValue()==null)
        {
            viewModel.counterValue.setValue(""+0);
        }
        mBinding.btnIncrement.setOnClickListener(v -> {
            viewModel.incrementValue();
        });
        mBinding.btnDecrement.setOnClickListener(v -> {
            viewModel.decrementValue();
        });
        viewModel.counterValue.observeForever(s -> {
            Log.d("chkvalue","value:"+s);
        });
    }


}