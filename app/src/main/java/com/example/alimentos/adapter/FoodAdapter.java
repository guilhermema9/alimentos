package com.example.alimentos.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alimentos.OnListClick;
import com.example.alimentos.R;
import com.example.alimentos.ViewHolder.FoodViewHolder;
import com.example.alimentos.entity.FoodEntity;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodViewHolder> {

    private List<FoodEntity> foodList;
    private OnListClick onListClick;

    public FoodAdapter(List<FoodEntity> list, OnListClick listener){
        this.foodList = list;
        this.onListClick = listener;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_food, parent, false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        FoodEntity foodEntity = this.foodList.get(position);
        holder.bind(foodEntity, this.onListClick);
    }

    @Override
    public int getItemCount() {
        return this.foodList.size();
    }
}
