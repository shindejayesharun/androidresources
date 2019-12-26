package com.shindejayesharun.mvvmdiretroroomjavax.di;

import com.shindejayesharun.mvvmdiretroroomjavax.ui.MainActivity;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Subcomponent;

@Singleton
@Component(dependencies = {}, modules = {AppModule.class})//ApiModule.class,RoomModule.class
public interface AppComponent {
    void inject(MainActivity mainActivity);
}
