package com.interview.mhe;

import android.app.Application;

import com.interview.mhe.presentation.dagger.ApplicationModule;
import com.interview.mhe.presentation.dagger.DaggerRootComponent;
import com.interview.mhe.presentation.dagger.RetrofitModule;
import com.interview.mhe.presentation.dagger.RootComponent;

public class App extends Application {
    private static RootComponent mRootComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        //Dagger - init component
        initRootComponent();
    }

    private void initRootComponent() {
        mRootComponent = DaggerRootComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .retrofitModule(new RetrofitModule())
                .build();
    }

    public static RootComponent getComponent() {
        return mRootComponent;
    }
}
