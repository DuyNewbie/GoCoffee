package com.example.gocoffee.models;

import com.google.gson.annotations.SerializedName;

public class Product {
    @SerializedName("_id")
    private String _id;
    @SerializedName("name")
    private String name;
    @SerializedName("price")
    private int price;
    @SerializedName("detail")
    private String detail;
    @SerializedName("id_category")
    private String id_category;
    @SerializedName("quantity")
    private String quantity;
    @SerializedName("image")
    private String image;

    public Product(String _id, String name, int price, String detail, String id_category, String quantity, String image) {
        this._id = _id;
        this.name = name;
        this.price = price;
        this.detail = detail;
        this.id_category = id_category;
        this.quantity = quantity;
        this.image = image;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getId_category() {
        return id_category;
    }

    public void setId_category(String id_category) {
        this.id_category = id_category;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
