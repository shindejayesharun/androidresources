package com.shindejayesharun.draggerroom.di;


import android.app.Application;

import com.shindejayesharun.draggerroom.local.AppDatabase;
import com.shindejayesharun.draggerroom.local.UserDao;
import com.shindejayesharun.draggerroom.ui.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(dependencies = {}, modules = {ApiModule.class,AppModule.class,RoomModule.class})
public interface ApiComponents {
    void inject(MainActivity mainActivity);

    UserDao userDao();

    AppDatabase  appDatabase();

    Application application();
}
