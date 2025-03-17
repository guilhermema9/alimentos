package com.example.alimentos.ViewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alimentos.R;
import com.example.alimentos.entity.FoodEntity;

public class FoodViewHolder extends RecyclerView.ViewHolder {

    private TextView textName, textCalories;

    public FoodViewHolder(@NonNull View itemView) {
        super(itemView);
        this.textName = itemView.findViewById(R.id.text_name);
        this.textCalories = itemView.findViewById((R.id.text_calories));
    }

    public void bind (FoodEntity food){
        this.textName.setText(food.getName());
        this.textCalories.setText(String.valueOf(food.getCalories()));
    }
}
