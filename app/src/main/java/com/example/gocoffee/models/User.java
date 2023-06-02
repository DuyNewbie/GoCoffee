package com.example.gocoffee.models;

public class User {
    private String username;
    private String password;
    private String fullname;
    private String phone;
    private String role;
    private String avata;

    public User(String username, String password, String fullname, String phone, String role, String avata) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.phone = phone;
        this.role = role;
        this.avata = avata;
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
