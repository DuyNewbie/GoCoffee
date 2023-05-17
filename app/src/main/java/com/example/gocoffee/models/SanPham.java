package com.example.gocoffee.models;

public class SanPham {

    private String name,category,description;
    private int image,amount;
    private double price;

    public SanPham() {
    }

    public SanPham(String name, String category, int image, double price) {
        this.name = name;
        this.category = category;
        this.image = image;
        this.price = price;
    }


    public SanPham(String name, String category, int image, String description, int amount, double price) {
        this.name = name;
        this.category = category;
        this.image = image;
        this.description = description;
        this.amount = amount;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
