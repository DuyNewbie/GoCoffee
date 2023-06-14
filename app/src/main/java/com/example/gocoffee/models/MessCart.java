package com.example.gocoffee.models;

import com.google.gson.annotations.SerializedName;

public class MessCart {
    @SerializedName("_id")
    private String _id;
    @SerializedName("id_User")
    private String id_User;
    @SerializedName("id_product")
    private String id_product;
    @SerializedName("quantity")
    private int quantity;

    public MessCart(String _id, String id_User, String id_product, int quantity) {
        this._id = _id;
        this.id_User = id_User;
        this.id_product = id_product;
        this.quantity = quantity;
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

    public String getId_product() {
        return id_product;
    }

    public void setId_product(String id_product) {
        this.id_product = id_product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
