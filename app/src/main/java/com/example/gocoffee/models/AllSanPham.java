package com.example.gocoffee.models;

import com.google.gson.annotations.SerializedName;

public class AllSanPham {

    @SerializedName("msg")
    private String msg;

    @SerializedName("listProduct")
    private SanPham[] listProduct;

    public AllSanPham(String msg, SanPham[] listProduct) {
        this.msg = msg;
        this.listProduct = listProduct;
    }

    public AllSanPham() {
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public SanPham[] getListProduct() {
        return listProduct;
    }

    public void setListProduct(SanPham[] listProduct) {
        this.listProduct = listProduct;
    }
}
