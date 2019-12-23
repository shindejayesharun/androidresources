package com.shindejayesharun.mvvmdiretroroomjavax.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.shindejayesharun.mvvmdiretroroomjavax.R;
import com.shindejayesharun.mvvmdiretroroomjavax.data.remote.ApiInterface;
import com.shindejayesharun.mvvmdiretroroomjavax.repository.Repository;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Inject
    Repository repository;

    @Inject
    Retrofit retrofit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //repository.getApiCall();

        ApiInterface api=retrofit.create(ApiInterface.class);
        Call<ResponseBody> call=api.getAllUsers();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.d("Tag",response.body().source().toString());
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("Tag","fail");
            }
        });

    }
}
