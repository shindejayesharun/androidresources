package com.shindejayesharun.mvvmdiretroroomjavax.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;

import com.shindejayesharun.mvvmdiretroroomjavax.AppViewModelFactory;
import com.shindejayesharun.mvvmdiretroroomjavax.MyApplication;
import com.shindejayesharun.mvvmdiretroroomjavax.R;
import com.shindejayesharun.mvvmdiretroroomjavax.repository.Repository;

import javax.inject.Inject;

import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {


    @Inject
    Retrofit retrofit;

    @Inject
    Repository repository;

    private MainViewModel mainViewModel;

    @Inject
    AppViewModelFactory appViewModelFactory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ((MyApplication) getApplication()).getAppComponent().inject(this);

        mainViewModel = ViewModelProviders.of(this,appViewModelFactory).get(MainViewModel.class);

        mainViewModel.getEmployeesDataWithRxOnRepository();
        //mainViewModel.getEmployeesDataWithRxOnViewModel();
        //mainViewModel.getEmployeesDataOnViewodel();


        mainViewModel.repository.setToken("jay");
        String v1=mainViewModel.repository.getToken();
        Log.d("data shared","--"+v1);


        /*Observable<List<Employee>> call3 = repository.getAllUser1();
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
        Toast.makeText(this, "data fail", Toast.LENGTH_SHORT).show();*/
    }

}
