package com.shindejayesharun.retrofit.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.shindejayesharun.retrofit.R;
import com.shindejayesharun.retrofit.data.ApiClient;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Call<ResponseBody> responseBodyCall=ApiClient.getInstance().getAllUsers2();
        responseBodyCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Toast.makeText(MainActivity.this, ""+response.body().source(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Fail", Toast.LENGTH_SHORT).show();
            }
        });


        JSONObject jsonObject=new JSONObject();
        try {
            jsonObject.put("employee_name","jayesh");
            jsonObject.put("employee_salary","123");
            jsonObject.put("employee_aage","27");
            jsonObject.put("id","9665");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        HashMap<String,String> map=new HashMap<>();
        map.put("name","jayesh");
        map.put("salary","211");
        map.put("age","21");

        Call<ResponseBody> postCall=ApiClient.getInstance().postData(map);
        postCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Toast.makeText(MainActivity.this, "Post done"+response.body().source(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Post fail", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
