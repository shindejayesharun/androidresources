package com.shindejayesharun.mvvmdiretroroomjavax.ui;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.shindejayesharun.mvvmdiretroroomjavax.data.Employee;
import com.shindejayesharun.mvvmdiretroroomjavax.repository.Repository;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainViewModel extends ViewModel {

    Repository repository;

    public MainViewModel(Repository repository) {
        this.repository = repository;
    }

    public void getEmployeesData() {
        Observable<List<Employee>> call3 = repository.getAllUser1();
        call3.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(result -> result)
                .subscribe(this::handleResults, this::handleError);
    }


    private void handleResults(List<Employee> employees) {
        Log.d("done", "done"+employees);

    }

    private void handleError(Throwable t) {
        Log.d("done", "done");
    }
}
