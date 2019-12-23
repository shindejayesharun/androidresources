package com.shindejayesharun.mvvmdiretroroomjavax.di;

import com.shindejayesharun.mvvmdiretroroomjavax.ui.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(dependencies = {},modules = {AppModule.class})//ApiModule.class,RoomModule.class
public interface AppComponent {
    void inject(MainActivity mainActivity);
}
