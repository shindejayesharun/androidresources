package com.shindejayesharun.mvvmdiretroroomjavax.repository;

import android.content.SharedPreferences;

import com.shindejayesharun.mvvmdiretroroomjavax.data.Employee;
import com.shindejayesharun.mvvmdiretroroomjavax.data.local.db.User;
import com.shindejayesharun.mvvmdiretroroomjavax.data.local.db.UserDao;
import com.shindejayesharun.mvvmdiretroroomjavax.data.local.pref.AppPreference;
import com.shindejayesharun.mvvmdiretroroomjavax.data.local.pref.PrefHandler;
import com.shindejayesharun.mvvmdiretroroomjavax.data.remote.ApiInterface;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;

public class Repository implements UserDao, ApiInterface, PrefHandler {
    private ApiInterface apiInterface;
    private UserDao userDao;
    private AppPreference appPreference;

    public Repository(ApiInterface apiInterface, UserDao userDao, AppPreference appPreference) {
        this.apiInterface = apiInterface;
        this.userDao=userDao;
        this.appPreference=appPreference;
    }

    @Override
    public void insert(User user) {
        userDao.insert(user);
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

    public Observable<List<Employee>> getAllUsersList() {
       return apiInterface.getAllUser1();
    }


    @Override
    public void setToken(String token) {
        appPreference.setToken(token);
    }

    @Override
    public String getToken() {
        return appPreference.getToken();
    }
}
