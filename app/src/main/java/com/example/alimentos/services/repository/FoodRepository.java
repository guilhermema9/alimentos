package com.example.alimentos.services.repository;

import com.example.alimentos.entities.FoodEntity;

import java.util.ArrayList;
import java.util.List;

public class FoodRepository {

    private List<FoodEntity> foodList;

    public FoodRepository() {
        this.foodList = new ArrayList<>();

        this.foodList.add(new FoodEntity(0, "Alface crespa", 8, 60, "g", "Este alimento contém vitamina A, C e K."));
        this.foodList.add(new FoodEntity(1, "Azeite", 90, 10, "g", ""));
        this.foodList.add(new FoodEntity(2, "Batata doce", 115, 100, "g", "Este alimento é rico em vitamina A."));
        this.foodList.add(new FoodEntity(3, "Ervilhas cruas", 81, 70, "g", ""));
        this.foodList.add(new FoodEntity(4, "Feijão carioca", 77, 75, "g", "Este alimento é rico em ferro."));
        this.foodList.add(new FoodEntity(5, "Filé de frango frito", 240, 100, "g", "Alimento rico em proteínas."));
        this.foodList.add(new FoodEntity(6, "Grão de bico", 720, 200, "g", ""));
        this.foodList.add(new FoodEntity(7, "Macarrão cozido", 221, 140, "g", ""));
        this.foodList.add(new FoodEntity(8, "Pão de forma 12 grãos", 110, 50, "g", "Este alimento tem baixo teor de gordura saturada."));
        this.foodList.add(new FoodEntity(9, "Queijo parmesão", 18, 71, "g", ""));
        this.foodList.add(new FoodEntity(10, "Rúcula", 5, 20, "g", "Este alimento contém cálcio e ferro."));
        this.foodList.add(new FoodEntity(11, "Vagem cozida", 44, 125, "g", ""));
        this.foodList.add(new FoodEntity(12, "Vodka", 231, 100, "ml", "0g de gordura, 0g de proteína. Somente carboridrato."));
        this.foodList.add(new FoodEntity(13, "Whiskey", 58, 23, "ml", ""));
    }

    public FoodEntity getItem (int id){
        return this.foodList.get(id);
    }

    public List<FoodEntity> getList(){
        return foodList;
    }
}
