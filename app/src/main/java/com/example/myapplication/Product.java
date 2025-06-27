package com.example.myapplication;

public class Product {
    private String name;
    private String category;
    private double price;
    private String description;
    private int imageResId;

    public Product(String name, String category, double price, String description, int imageResId) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.description = description;
        this.imageResId = imageResId;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResId() {
        return imageResId;
    }
}
