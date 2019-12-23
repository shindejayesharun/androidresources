package com.shindejayesharun.mvvmdiretroroomjavax.repository;

import android.util.Log;

import com.shindejayesharun.mvvmdiretroroomjavax.data.local.User;
import com.shindejayesharun.mvvmdiretroroomjavax.data.local.UserDao;
import com.shindejayesharun.mvvmdiretroroomjavax.data.remote.ApiInterface;

import java.util.List;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Repository implements UserDao, ApiInterface {

    @Inject
    UserDao userDao;
    @Inject
    Retrofit retrofit;

    private ApiInterface apiInterface;

    public Repository(UserDao userDao, Retrofit retrofit) {
        this.userDao = userDao;
        this.retrofit=retrofit;
        apiInterface=retrofit.create(ApiInterface.class);
    }

    @Override
    public void insert(User user) {

    }

    @Override
    public List<User> usersList() {
        return null;
    }

    @Override
    public void deleteUser(User user) {

    }

    @Override
    public Call<ResponseBody> getAllUsers() {
        return null;
    }

    @Override
    public Call<ResponseBody> createUser(User user) {
        return null;
    }

    public void getApiCall(){
        Call<ResponseBody> call=apiInterface.getAllUsers();
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
