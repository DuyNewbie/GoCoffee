package com.example.gocoffee.models;

import com.google.gson.annotations.SerializedName;

public class AllUser {
    @SerializedName("msg")
    private String msg;
    @SerializedName("listUser")
    private User[] listUser;

    public AllUser(String msg, User[] listUser) {
        this.msg = msg;
        this.listUser = listUser;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public User[] getListUser() {
        return listUser;
    }

    public void setListUser(User[] listUser) {
        this.listUser = listUser;
    }
}
