package com.shindejayesharun.mvvmdiretroroomjavax.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.shindejayesharun.mvvmdiretroroomjavax.AppViewModelFactory;
import com.shindejayesharun.mvvmdiretroroomjavax.MyApplication;
import com.shindejayesharun.mvvmdiretroroomjavax.R;
import com.shindejayesharun.mvvmdiretroroomjavax.data.Employee;
import com.shindejayesharun.mvvmdiretroroomjavax.data.remote.ApiInterface;
import com.shindejayesharun.mvvmdiretroroomjavax.repository.Repository;

import java.util.List;
import java.util.ListIterator;
import java.util.function.Consumer;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {


    @Inject
    Retrofit retrofit;

    private MainViewModel mainViewModel;
/*
    @Inject
    AppViewModelFactory appViewModelFactory;*/


    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //((MyApplication) getApplication()).getAppComponent().inject(this);

        /*mainViewModel = ViewModelProviders.of(this, appViewModelFactory).get(MainViewModel.class);

        mainViewModel.getEmployeesData();*/

        //repository.getApiCall();

        ApiInterface api = retrofit.create(ApiInterface.class);
        /*Call<List<Employee>> call = api.getAllUsers();
        call.enqueue(new Callback<List<Employee>>() {
            @Override
            public void onResponse(Call<List<Employee>> call, Response<List<Employee>> response) {
                Log.d("Tag", response.body().toString());
            }

            @Override
            public void onFailure(Call<List<Employee>> call, Throwable t) {
                Log.d("Tag", "fail");
            }
        });*/


        CompositeDisposable compositeDisposable = new CompositeDisposable();

       /* Observable<List<Employee>> call3 = api.getAllUser1();
        call3.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(result -> result)
                .subscribe(this::handleResults, this::handleError);
    }

    private void handleResults(List<Employee> employees) {
        Log.d("done", "done");
        Toast.makeText(this, "data" + employees, Toast.LENGTH_SHORT).show();
    }

    private void handleError(Throwable t) {
        Toast.makeText(this, "data fail", Toast.LENGTH_SHORT).show();
    }*/
    }
}
