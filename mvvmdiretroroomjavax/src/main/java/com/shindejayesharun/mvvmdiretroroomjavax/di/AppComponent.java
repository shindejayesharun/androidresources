package com.shindejayesharun.mvvmdiretroroomjavax.di;

import com.shindejayesharun.mvvmdiretroroomjavax.ui.MainActivity;

import javax.inject.Singleton;

import dagger.Subcomponent;

@Singleton
@Subcomponent(modules = {AppModule.class,ApiModule.class,RoomModule.class})//ApiModule.class,RoomModule.class
public interface AppComponent {
    void inject(MainActivity mainActivity);
}
