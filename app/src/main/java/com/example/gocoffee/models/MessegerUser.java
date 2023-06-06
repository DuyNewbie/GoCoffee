package com.example.gocoffee.models;

import com.google.gson.annotations.SerializedName;

public class MessegerUser {
    @SerializedName("msg")
    private String msg;
    @SerializedName("checkLogin")
    private Boolean checkLogin;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Boolean getCheckLogin() {
        return checkLogin;
    }

    public void setCheckLogin(Boolean checkLogin) {
        this.checkLogin = checkLogin;
    }

    public MessegerUser(String msg, Boolean checkLogin) {
        this.msg = msg;
        this.checkLogin = checkLogin;
    }
}
