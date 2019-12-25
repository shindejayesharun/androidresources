package com.shindejayesharun.mvvmdiretroroomjavax.di;


import android.app.Application;

import androidx.room.Room;

import com.shindejayesharun.mvvmdiretroroomjavax.data.local.AppDatabase;
import com.shindejayesharun.mvvmdiretroroomjavax.data.local.UserDao;
import com.shindejayesharun.mvvmdiretroroomjavax.repository.Repository;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RoomModule {

    private AppDatabase appDatabase;

    public RoomModule(Application application) {
        appDatabase = Room.databaseBuilder(application,AppDatabase.class,"myDb.db")
        .allowMainThreadQueries()
        .build();
    }

    @Provides
    @Singleton
    UserDao provideUserDao(){
       return appDatabase.userDao();
    }


}
