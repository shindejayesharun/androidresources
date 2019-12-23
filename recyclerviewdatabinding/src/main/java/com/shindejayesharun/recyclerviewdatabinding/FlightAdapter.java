package com.shindejayesharun.recyclerviewdatabinding;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.shindejayesharun.recyclerviewdatabinding.databinding.ItemFlightBinding;

import java.util.List;

public class FlightAdapter extends RecyclerView.Adapter<FlightAdapter.ViewHolder>{

    List<Flight> flights;
    Context context;

    public FlightAdapter(List<Flight> flights, Context context) {
        this.flights = flights;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemFlightBinding binding= DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.item_flight,parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Flight flight=flights.get(position);
        holder.itemFlightBinding.setViewModel(flight);
    }

    @Override
    public int getItemCount() {
        return flights.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ItemFlightBinding itemFlightBinding;
        public ViewHolder(@NonNull ItemFlightBinding itemView) {
            super(itemView.getRoot());
            itemFlightBinding=itemView;
        }
    }
}
