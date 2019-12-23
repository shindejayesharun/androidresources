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
    private AppDatabase appDatabase;

    public AppModule(Application application) {
        this.application = application;
        appDatabase = Room.databaseBuilder(application, AppDatabase.class,"myDb.db")
                .allowMainThreadQueries()
                .build();
    }


    @Provides
    @Singleton
    Application provideApplication(){
        return application;
    }


    @Provides
    @Singleton
    UserDao provideUserDao(){
        return appDatabase.userDao();
    }

    @Provides
    @Singleton
    Repository provideRepository(){
        return new Repository(provideUserDao(),provideRetrofit());
    }


    @Provides
    @Singleton
    Gson provideGson(){
        GsonBuilder gsonBuilder=new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder.create();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(){
        HttpLoggingInterceptor httpLoggingInterceptor=new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client=new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();

        return new Retrofit.Builder()
                .baseUrl("http://dummy.restapiexample.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }
}
