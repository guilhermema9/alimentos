package com.example.alimentos.repository;

import com.example.alimentos.entity.FoodEntity;

import java.util.ArrayList;
import java.util.List;

public class FoodRepository {

    private List<FoodEntity> foodList;

    public FoodRepository() {
        this.foodList = new ArrayList<>();

        this.foodList.add(new FoodEntity(0, "Alface crespa", 8));
        this.foodList.add(new FoodEntity(1, "Azeite", 90));
        this.foodList.add(new FoodEntity(2, "Batata doce", 115));
        this.foodList.add(new FoodEntity(3, "Ervilhas cruas", 81));
        this.foodList.add(new FoodEntity(4, "Feijão carioca", 77));
        this.foodList.add(new FoodEntity(5, "Filé de frango frito", 240));
        this.foodList.add(new FoodEntity(6, "Grão de bico", 720));
        this.foodList.add(new FoodEntity(7, "Macarrão cozido", 221));
        this.foodList.add(new FoodEntity(8, "Pão de forma 12 grãos", 110));
        this.foodList.add(new FoodEntity(9, "Queijo parmesão", 18));
        this.foodList.add(new FoodEntity(10, "Rúcula", 5));
        this.foodList.add(new FoodEntity(11, "Vagem cozida", 44));
        this.foodList.add(new FoodEntity(12, "Vodka", 231));
        this.foodList.add(new FoodEntity(13, "Whiskey", 58));
    }

    public FoodEntity getItem (int id){
        return this.foodList.get(id);
    }

    public List<FoodEntity> getList(){
        return new ArrayList<FoodEntity>();
    }
}
