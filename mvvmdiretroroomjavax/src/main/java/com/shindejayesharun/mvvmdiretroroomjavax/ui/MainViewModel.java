package com.shindejayesharun.mvvmdiretroroomjavax.ui;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.shindejayesharun.mvvmdiretroroomjavax.data.Employee;
import com.shindejayesharun.mvvmdiretroroomjavax.data.remote.ApiInterface;
import com.shindejayesharun.mvvmdiretroroomjavax.repository.Repository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {


    Repository repository;

    public MainViewModel(Repository repository) {
        this.repository=repository;
    }


    public void getEmployeesDataWithRxOnViewModel() {
        Observable<List<Employee>> call3 = repository.getAllUser1();
        call3.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(result -> result)
                .subscribe(this::handleResults, this::handleError);
    }
    private void handleResults(List<Employee> employees) {
        Log.d("done2", "done"+employees);
    }
    private void handleError(Throwable t) {
        Log.d("done", "done");
    }


    public void getEmployeesDataOnViewodel() {
        //ApiInterface api = retrofit.create(ApiInterface.class);
        Call<List<Employee>> call = repository.getAllUsers();
        call.enqueue(new Callback<List<Employee>>() {
            @Override
            public void onResponse(Call<List<Employee>> call, Response<List<Employee>> response) {
                Log.d("Tag", response.body().toString());
            }
            @Override
            public void onFailure(Call<List<Employee>> call, Throwable t) {
                Log.d("Tag", "fail");
            }
        });
    }

    public void getEmployeesDataWithRxOnRepository() {
        repository.getAllUsersList().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(result -> result)
                .subscribe(this::handleResults, this::handleError);
    }
}
