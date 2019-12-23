package com.shindejayesharun.draggerroom;

import android.app.Application;

import com.shindejayesharun.draggerroom.di.ApiComponents;
import com.shindejayesharun.draggerroom.di.ApiModule;
import com.shindejayesharun.draggerroom.di.AppModule;
import com.shindejayesharun.draggerroom.di.DaggerApiComponents;
import com.shindejayesharun.draggerroom.di.RoomModule;

public class MyApplication extends Application {
    private ApiComponents mApiComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mApiComponent = DaggerApiComponents.builder()
                .appModule(new AppModule(this))
                .apiModule(new ApiModule("http://dummy.restapiexample.com/"))
                .roomModule(new RoomModule(this))
                .build();

    }

    public ApiComponents getmApiComponent(){
        return mApiComponent;
    }

}
