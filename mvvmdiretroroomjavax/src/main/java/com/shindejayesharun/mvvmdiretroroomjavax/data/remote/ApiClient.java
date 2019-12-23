package com.shindejayesharun.mvvmdiretroroomjavax.data.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static volatile Retrofit retrofit;

    //***use when without di
    public static ApiClient getInstance(){
        if(retrofit==null){
            synchronized (ApiClient.class){
                if(retrofit==null){
                    retrofit=new Retrofit.Builder()
                            .baseUrl("http://dummy.restapiexample.com/")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                }
            }
        }
        return retrofit.create(ApiClient.class);
    }
    //
}
