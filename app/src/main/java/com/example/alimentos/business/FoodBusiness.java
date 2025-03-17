package com.example.alimentos.business;

import com.example.alimentos.entity.FoodEntity;
import com.example.alimentos.repository.FoodRepository;

import java.util.List;

public class FoodBusiness {

    public FoodEntity getItem(int id){
        return new FoodRepository().getItem(id);
    }

    public List<FoodEntity> getList(){
        return new FoodRepository().getList();
    }
}
