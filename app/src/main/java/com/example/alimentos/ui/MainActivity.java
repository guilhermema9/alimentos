package com.example.alimentos.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alimentos.services.listener.OnListClick;
import com.example.alimentos.R;
import com.example.alimentos.ui.adapter.FoodAdapter;
import com.example.alimentos.services.business.FoodBusiness;
import com.example.alimentos.entities.FoodEntity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewHolder viewHolder = new ViewHolder();
    private FoodBusiness foodBusiness = new FoodBusiness();
    private OnListClick foodListener;
    private int filter=0;

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

        this.foodListener = new OnListClick() {
            @Override
            public void onClick(int id) {
                Bundle bundle = new Bundle();
                bundle.putInt("foodId", id);
                Intent intent = new Intent(getApplicationContext(), DetailsActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        };

        this.viewHolder.recyclerView = findViewById(R.id.recycler_food);
        this.viewHolder.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        this.listFood();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        item.setChecked(true);
        if (item.getItemId() == R.id.filter_low) {
            this.filter = 1;
        } else if (item.getItemId() == R.id.filter_medium) {
            this.filter = 2;
        } else {
            this.filter = 3;
        }
        this.listFood();
        return super.onOptionsItemSelected(item);
    }

    private void listFood(){
        List<FoodEntity> foodList = this.foodBusiness.getList(this.filter);
        FoodAdapter adapter = new FoodAdapter(foodList, this.foodListener);
        this.viewHolder.recyclerView.setAdapter(adapter);
    }

    private static class ViewHolder {
        RecyclerView recyclerView;
    }
}