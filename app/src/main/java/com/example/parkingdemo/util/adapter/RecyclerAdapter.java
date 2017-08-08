package com.example.parkingdemo.util.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.parkingdemo.R;
import com.example.parkingdemo.model.CarPark;

import com.example.parkingdemo.ui.activity.DetailActivity;
import com.example.parkingdemo.ui.activity.MainActivity;
import com.squareup.picasso.Picasso;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by ss on 1.8.2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private List<CarPark> carParkArrayList;
    private Context context;


    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        TextView cardText, cardTitle;
        ImageButton infoButton, mapButton;

        public ViewHolder(View view) {
            super(view);
            final Context context = itemView.getContext();

            imageView = (ImageView) view.findViewById(R.id.card_image);
            cardTitle = (TextView) view.findViewById(R.id.card_title);
            cardText = (TextView) view.findViewById(R.id.card_text);
            infoButton = (ImageButton) view.findViewById(R.id.info_button);
            mapButton = (ImageButton) view.findViewById(R.id.map_button);
        }
    }
    public RecyclerAdapter(List<CarPark> carParks, Context context) {
        this.carParkArrayList = carParks;
        this.context = context;
    }
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview, parent, false);
        final ViewHolder viewHolder = new ViewHolder(v);

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        return viewHolder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.cardTitle.setText(carParkArrayList.get(position).getCarparkingname());
        holder.cardText.setText(carParkArrayList.get(position).getCapacity());
        Picasso.with(context).load(carParkArrayList.get(position).getImagepath()).into(holder.imageView);

        holder.infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, DetailActivity.class));
            }
        });

        holder.mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("POSITION", position);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return carParkArrayList.size();
    }
}