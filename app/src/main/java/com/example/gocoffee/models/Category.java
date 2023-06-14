package com.example.gocoffee.models;

import com.google.gson.annotations.SerializedName;

public class Category {

    @SerializedName("_id")
    private String _id;
    @SerializedName("name")
    private String name;
    @SerializedName("__v")
    private String __v;

    public Category() {
    }

    public Category(String _id, String name) {
        this._id = _id;
        this.name = name;
    }

    public Category(String _id, String name, String __v) {
        this._id = _id;
        this.name = name;
        this.__v = __v;
    }

    public Category(String name) {
        this.name = name;
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

    public String get__v() {
        return __v;
    }

    public void set__v(String __v) {
        this.__v = __v;
    }
}
