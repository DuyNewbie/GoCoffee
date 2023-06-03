package com.example.gocoffee.models;

import com.google.gson.annotations.SerializedName;

public class PostUser {
    @SerializedName("UserName")
    private String userName;
    @SerializedName("PassWord")
    private String passWord;

    public PostUser(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "PostUser{" +
                "userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}
