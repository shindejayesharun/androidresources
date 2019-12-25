package com.shindejayesharun.mvvmdiretroroomjavax.di;

import android.app.Application;

import androidx.room.Room;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.shindejayesharun.mvvmdiretroroomjavax.data.local.AppDatabase;
import com.shindejayesharun.mvvmdiretroroomjavax.data.local.UserDao;
import com.shindejayesharun.mvvmdiretroroomjavax.repository.Repository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule extends Application {

    private Application application;

    public AppModule(Application application) {
        this.application = application;

    }

    @Provides
    @Singleton
    Application provideApplication(){
        return application;
    }


}
