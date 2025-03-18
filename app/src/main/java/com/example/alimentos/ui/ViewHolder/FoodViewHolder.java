package com.example.alimentos.ui.ViewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alimentos.services.listener.OnListClick;
import com.example.alimentos.R;
import com.example.alimentos.entities.FoodEntity;

public class FoodViewHolder extends RecyclerView.ViewHolder {

    private TextView textName, textCalories, textQuantity, textUnit;

    public FoodViewHolder(@NonNull View itemView) {
        super(itemView);
        this.textName = itemView.findViewById(R.id.text_name);
        this.textCalories = itemView.findViewById((R.id.text_calories));
        this.textQuantity = itemView.findViewById((R.id.text_quantity));
        this.textUnit = itemView.findViewById((R.id.text_unit));
    }

    public void bind (FoodEntity food, final OnListClick listener){
        this.textName.setText(food.getName());
        this.textCalories.setText(String.valueOf(food.getCalories())+" calorias");
        this.textQuantity.setText(String.valueOf(food.getQuantity()));
        this.textUnit.setText(food.getUnit());

        this.textName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(food.getId());
            }
        });
    }
}
