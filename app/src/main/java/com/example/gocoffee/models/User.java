package com.example.gocoffee.models;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("_id")
    private String _id;
    @SerializedName("username")
    private String username;
    @SerializedName("password")
    private String password;
    @SerializedName("fullname")
    private String fullname;
    @SerializedName("phone")
    private String phone;
    @SerializedName("role")
    private String role;
    @SerializedName("avata")
    private String avata;

    @SerializedName("email")
    private String email;

    @SerializedName("address")
    private String address;

    public User(String _id, String username, String password, String fullname, String phone, String role, String avata) {
        this._id = _id;
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.phone = phone;
        this.role = role;
        this.avata = avata;
    }

    public User(String _id, String username, String password, String fullname, String phone, String role, String avata, String email) {
        this._id = _id;
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.phone = phone;
        this.role = role;
        this.avata = avata;
        this.email = email;
    }

    public User(String _id, String username, String password, String fullname, String phone, String role, String avata, String email, String address) {
        this._id = _id;
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.phone = phone;
        this.role = role;
        this.avata = avata;
        this.email = email;
        this.address = address;
    }

    public User() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAvata() {
        return avata;
    }

    public void setAvata(String avata) {
        this.avata = avata;
    }
}
