package com.shindejayesharun.retrofit.data;

import org.json.JSONObject;

import java.util.HashMap;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    @GET("/api/v1/employees")
    Call<ResponseBody> getAllUsers2();

    @FormUrlEncoded()
    @POST("/api/v1/create")
    Call<ResponseBody> postData(@FieldMap HashMap<String,String> hashMap);
}
