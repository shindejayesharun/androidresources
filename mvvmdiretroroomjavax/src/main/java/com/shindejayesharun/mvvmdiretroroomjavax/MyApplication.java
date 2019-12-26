package com.shindejayesharun.mvvmdiretroroomjavax;

import android.app.Application;
import com.shindejayesharun.mvvmdiretroroomjavax.di.ApiModule;
import com.shindejayesharun.mvvmdiretroroomjavax.di.AppComponent;
import com.shindejayesharun.mvvmdiretroroomjavax.di.AppModule;
import com.shindejayesharun.mvvmdiretroroomjavax.di.DaggerAppComponent;
import com.shindejayesharun.mvvmdiretroroomjavax.di.RoomModule;



public class MyApplication extends Application {
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent= DaggerAppComponent.builder()
                    .appModule(new AppModule(this))
                   // .apiModule(new ApiModule())
                   // .roomModule(new RoomModule(this))
                    .build();

    }

    public AppComponent getAppComponent(){
        return appComponent;
    }
}
