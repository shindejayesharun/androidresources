package com.shindejayesharun.mvvmdiretroroomjavax.repository;

import com.shindejayesharun.mvvmdiretroroomjavax.data.Employee;
import com.shindejayesharun.mvvmdiretroroomjavax.data.local.User;
import com.shindejayesharun.mvvmdiretroroomjavax.data.local.UserDao;
import com.shindejayesharun.mvvmdiretroroomjavax.data.remote.ApiInterface;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;

public class Repository implements UserDao, ApiInterface {
    private ApiInterface apiInterface;

    public Repository(ApiInterface apiInterface) {
        this.apiInterface = apiInterface;
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
    public Call<List<Employee>> getAllUsers() {
        return null;
    }

    @Override
    public Observable<List<Employee>> getAllUser1() {
        return apiInterface.getAllUser1();
    }

    @Override
    public Call<ResponseBody> createUser(User user) {
        return null;
    }

}
