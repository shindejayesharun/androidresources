package com.shindejayesharun.mvvmdiretroroomjavax.data.local.db;

import android.app.Application;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class},version = 1,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDao userDao();

    //***use when without di
    private static volatile AppDatabase appDatabase;

    public static AppDatabase getInstance(Application application){
        if(application==null){
            synchronized (AppDatabase.class){
                if(application==null){
                    appDatabase= Room.databaseBuilder(application,AppDatabase.class,"mydb.db")
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return appDatabase;

    }
    //


}
