package com.example.alimentos.ui;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alimentos.R;
import com.example.alimentos.adapter.FoodAdapter;
import com.example.alimentos.business.FoodBusiness;
import com.example.alimentos.entity.FoodEntity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewHolder viewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        List<FoodEntity> foodList = new FoodBusiness().getList();

        // Passos para a Recycler View
        // 1 - Obter a RecyclerView
        this.viewHolder.recyclerView = findViewById(R.id.recycler_food);
        // 2 - Definir um Adapter
        FoodAdapter adapter = new FoodAdapter(foodList);
        this.viewHolder.recyclerView.setAdapter(adapter);
        // 3 - Definir um layout
        this.viewHolder.recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private static class ViewHolder {
        RecyclerView recyclerView;
    }
}