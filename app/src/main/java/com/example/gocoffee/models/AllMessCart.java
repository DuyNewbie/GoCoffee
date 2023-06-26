package com.example.gocoffee.models;

import com.google.gson.annotations.SerializedName;


public class AllMessCart {
    @SerializedName("msg")
    private String msg;
    @SerializedName("listCart")
    private MessCart[] listCart;

    public AllMessCart(String msg, MessCart[] listCart) {
        this.msg = msg;
        this.listCart = listCart;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public MessCart[] getListCart() {
        return listCart;
    }

    public void setListCart(MessCart[] listCart) {
        this.listCart = listCart;
    }
}
