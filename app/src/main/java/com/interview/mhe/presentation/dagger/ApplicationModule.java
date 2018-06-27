package com.interview.mhe.presentation.dagger;

import com.interview.mhe.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class ApplicationModule {

    App app;

    public ApplicationModule(App app) {
        this.app = app;
    }

    @Singleton
    @Provides
    public App provideApplication(){
        return app;
    }
}
