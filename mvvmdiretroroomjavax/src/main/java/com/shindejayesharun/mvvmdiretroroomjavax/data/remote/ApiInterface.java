package com.shindejayesharun.mvvmdiretroroomjavax.data.remote;

import com.shindejayesharun.mvvmdiretroroomjavax.data.Employee;
import com.shindejayesharun.mvvmdiretroroomjavax.data.local.User;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    @GET("/api/v1/employees")
    Call<List<Employee>> getAllUsers();

    @GET("/api/v1/employees")
    Observable<List<Employee>> getAllUser1();

    @POST()
    Call<ResponseBody> createUser(@FieldMap User user);
}
