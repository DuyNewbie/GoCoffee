package com.example.gocoffee.models;

import com.google.gson.annotations.SerializedName;

public class MessCart {
    @SerializedName("_id")
    private String _id;
    @SerializedName("id_User")
    private String id_User;
    @SerializedName("id_product")
    private Product id_product;
    @SerializedName("quantity")
    private int quantityproduct;

    public MessCart(String _id, String id_User, Product id_product, int quantityproduct) {
        this._id = _id;
        this.id_User = id_User;
        this.id_product = id_product;
        this.quantityproduct = quantityproduct;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getId_User() {
        return id_User;
    }

    public void setId_User(String id_User) {
        this.id_User = id_User;
    }

    public Product getId_product() {
        return id_product;
    }

    public void setId_product(Product id_product) {
        this.id_product = id_product;
    }

    public int getQuantityproduct() {
        return quantityproduct;
    }

    public void setQuantityproduct(int quantityproduct) {
        this.quantityproduct = quantityproduct;
    }
}
