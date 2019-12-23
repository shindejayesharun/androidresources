package com.shindejayesharun.draggerroom.remote;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static volatile Retrofit retrofit;
    ApiClient(){
    }
    public static ApiInterface getInstance(){
        if (retrofit==null){
            synchronized (ApiClient.class){
                if(retrofit==null){
                    HttpLoggingInterceptor httpLoggingInterceptor=new HttpLoggingInterceptor();
                    httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                    OkHttpClient client=new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();


                    retrofit=new Retrofit.Builder()
                            .baseUrl("http://dummy.restapiexample.com/")
                            .addConverterFactory(GsonConverterFactory.create())
                            .client(client)
                            .build();
                }
            }
        }
        return retrofit.create(ApiInterface.class);
    }
}
