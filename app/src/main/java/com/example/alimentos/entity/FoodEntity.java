package com.example.alimentos.entity;

public class FoodEntity {

    private int id;

    public FoodEntity(int id, String name, int calories) {
        this.id = id;
        this.name = name;
        this.calories = calories;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    private String name;
    private int calories;
}
