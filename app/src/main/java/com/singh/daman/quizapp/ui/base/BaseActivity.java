package com.singh.daman.quizapp.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.singh.daman.quizapp.InitApp;
import com.singh.daman.quizapp.di.component.ActivityComponent;
import com.singh.daman.quizapp.di.component.DaggerActivityComponent;
import com.singh.daman.quizapp.di.module.ActivityModule;

/**
 * Created by Daman on 11/3/2017.
 */

public abstract class BaseActivity extends AppCompatActivity implements BaseMvpView{

    private ActivityComponent mActivityComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .appComponent(((InitApp) getApplication()).getComponent())
                .build();

    }

    public ActivityComponent getActivityComponent() {
        return mActivityComponent;
    }

}