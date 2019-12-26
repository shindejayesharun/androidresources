package com.shindejayesharun.mvvmdiretroroomjavax.di;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.room.Room;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.shindejayesharun.mvvmdiretroroomjavax.data.local.db.AppDatabase;
import com.shindejayesharun.mvvmdiretroroomjavax.data.local.db.UserDao;
import com.shindejayesharun.mvvmdiretroroomjavax.data.local.pref.AppPreference;
import com.shindejayesharun.mvvmdiretroroomjavax.data.remote.ApiInterface;
import com.shindejayesharun.mvvmdiretroroomjavax.repository.Repository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule extends Application {

    private Application application;
    private AppDatabase appDatabase;
    private SharedPreferences sharedPreferences;

    public AppModule(Application application) {
        this.application = application;
        appDatabase = Room.databaseBuilder(application,AppDatabase.class,"myDb.db")
                .allowMainThreadQueries()
                .build();
        sharedPreferences=application.getSharedPreferences("pref",Context.MODE_PRIVATE);
    }

    @Provides
    @Singleton
    Application provideApplication(){
        return application;
    }


    //new
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
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

    }

    @Singleton
    @Provides
    public ApiInterface getApiInterface(Retrofit retrofit){
        return retrofit.create(ApiInterface.class);
    }


    @Singleton
    @Provides
    public Repository provideRepository(Retrofit retrofit, UserDao userDao, AppPreference appPreference){
        return new Repository(getApiInterface(retrofit),userDao,appPreference);
    }

    @Provides
    @Singleton
    UserDao provideUserDao(){
        return appDatabase.userDao();
    }

    @Provides
    @Singleton
    public SharedPreferences provideSharedPref(){
        return sharedPreferences;
    }

    @Provides
    @Singleton
    public AppPreference providePref(){
        return new AppPreference(sharedPreferences);
    }



}
