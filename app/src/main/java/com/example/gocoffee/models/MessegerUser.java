package com.example.gocoffee.models;

public class MessegerUser {
    private String msg;
    private String checkLogin;

    public MessegerUser(String msg, String checkLogin) {
        this.msg = msg;
        this.checkLogin = checkLogin;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCheckLogin() {
        return checkLogin;
    }

    public void setCheckLogin(String checkLogin) {
        this.checkLogin = checkLogin;
    }
}
