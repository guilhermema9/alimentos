package com.example.alimentos.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.alimentos.R;
import com.example.alimentos.services.business.FoodBusiness;
import com.example.alimentos.entities.FoodEntity;

public class DetailsActivity extends AppCompatActivity {

    private ViewHolder viewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        // Mapeamento de elementos de interface
        this.viewHolder.textName = findViewById(R.id.text_name);
        this.viewHolder.textCalories = findViewById(R.id.text_calories);
        this.viewHolder.texQuantity = findViewById(R.id.text_quantity);
        this.viewHolder.textUnit = findViewById(R.id.text_unit);
        this.viewHolder.textDescription = findViewById(R.id.text_description);

        this.getData();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void getData(){
        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            int id = bundle.getInt("foodId");
            FoodEntity foodEntity = new FoodBusiness().getItem(id);
            this.viewHolder.textName.setText(foodEntity.getName());
            this.viewHolder.texQuantity.setText(String.valueOf(foodEntity.getQuantity()));
            this.viewHolder.textUnit.setText(foodEntity.getUnit());
            this.viewHolder.textCalories.setText(String.valueOf(foodEntity.getCalories())+" calorias");
            if(!foodEntity.getDescription().isEmpty()){
                this.viewHolder.textDescription.setText(foodEntity.getDescription());
            }
        }
    }

    private static class ViewHolder{
        TextView textName;
        TextView textCalories;
        TextView texQuantity;
        TextView textUnit;
        TextView textDescription;
    }
}