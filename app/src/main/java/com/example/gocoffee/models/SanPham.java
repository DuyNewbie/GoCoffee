package com.example.gocoffee.models;

import com.google.gson.annotations.SerializedName;

public class SanPham {

    @SerializedName("_id")
    private String _id;
    @SerializedName("name")
    private String name;
    @SerializedName("price")
    private String price;
    @SerializedName("detail")
    private String detail;
    @SerializedName("image")
    private String image;
    @SerializedName("id_category")
    private String id_category;
    @SerializedName("quantity")
    private String quantity;

    @SerializedName("__V")
    private String __v;


    public SanPham(String name, String price, String detail, String image, String id_category, String quantity) {
        this.name = name;
        this.price = price;
        this.detail = detail;
        this.image = image;
        this.id_category = id_category;
        this.quantity = quantity;
    }

    public SanPham(String _id, String name, String price, String detail, String image, String id_category, String quantity, String __v) {
        this._id = _id;
        this.name = name;
        this.price = price;
        this.detail = detail;
        this.image = image;
        this.id_category = id_category;
        this.quantity = quantity;
        this.__v = __v;
    }

    public SanPham() {
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public String get__v() {
        return __v;
    }

    public void set__v(String __v) {
        this.__v = __v;
    }
}
