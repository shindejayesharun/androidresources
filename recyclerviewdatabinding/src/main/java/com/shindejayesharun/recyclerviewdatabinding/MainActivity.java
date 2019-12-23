package com.shindejayesharun.recyclerviewdatabinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.shindejayesharun.recyclerviewdatabinding.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        RecyclerView recyclerView=findViewById(R.id.recycyelrview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<Flight> flightList=new ArrayList<>();
        flightList.add(new Flight(1,"Boing f52","Mumbai","Delhi","08:30 am","11:45 am","5600"));
        flightList.add(new Flight(2,"Delta f54","New York","Mubai","08:30 am","11:45 am","5600"));
        flightList.add(new Flight(3,"Indian Airlines e672","Delhi","Goa","08:30 am","11:45 am","5600"));
        flightList.add(new Flight(4,"Atlantic n40","San Fasco","San Vegas","08:30 am","11:45 am","5600"));

        FlightAdapter flightAdapter=new FlightAdapter(flightList,this);
        recyclerView.setAdapter(flightAdapter);




    }
}
