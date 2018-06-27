package com.interview.mhe.presentation.dagger;

import com.interview.mhe.domain.DataManagerImpl;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, RetrofitModule.class})
public interface RootComponent {
    void inject(DataManagerImpl dataManager);

}
