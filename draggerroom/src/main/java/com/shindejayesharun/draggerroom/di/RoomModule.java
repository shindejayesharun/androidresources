package com.shindejayesharun.draggerroom.di;

import android.app.Application;

import androidx.room.Room;

import com.shindejayesharun.draggerroom.local.AppDatabase;
import com.shindejayesharun.draggerroom.local.UserDao;
import com.shindejayesharun.draggerroom.repository.LocalRepository;
import com.shindejayesharun.draggerroom.repository.LocalRepositoryImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RoomModule {
    private AppDatabase appDatabase;

    public RoomModule(Application application){
        appDatabase = Room.databaseBuilder(application,AppDatabase.class,"appdb.db").build();
    }

    @Singleton
    @Provides
    AppDatabase provideRoomDatabase(){
        return appDatabase;
    }

    @Singleton
    @Provides
    UserDao provideUserDao(){
        return appDatabase.userDao();
    }

    @Singleton
    @Provides
    LocalRepository provideLocalRepository(){
        return new LocalRepositoryImpl(provideUserDao());
    }
}
