package com.example.alimentos.services.business;

import com.example.alimentos.entities.FoodEntity;
import com.example.alimentos.services.repository.FoodRepository;

import java.util.ArrayList;
import java.util.List;

public class FoodBusiness {

    private FoodRepository foodRepository = new FoodRepository();

    public FoodEntity getItem(int id){
        return new FoodRepository().getItem(id);
    }

    public List<FoodEntity> getList(int filter){
        List<FoodEntity> foodList = this.foodRepository.getList();
        List<FoodEntity> filteredList = new ArrayList<>();

        if (filter == 0){
            return foodList;
        }

        for (FoodEntity f : foodList) {
            if (filter == 1){
                if (f.getCalories() <= 99 ){
                    filteredList.add(f);
                }
            } else if (filter == 2){
                if (f.getCalories() >= 100 && f.getCalories() <= 199 ){
                    filteredList.add(f);
                }
            } else if (filter == 3){
                if (f.getCalories() >= 200 ){
                    filteredList.add(f);
                }
            }
        }
        return filteredList;
    }
}
