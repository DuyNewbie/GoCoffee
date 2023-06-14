package com.example.gocoffee.models;

import com.google.gson.annotations.SerializedName;

public class AllSanPham {

    @SerializedName("msg")
    private String msg;

    @SerializedName("listProduct")
    private SanPham[] listProduct;

    @SerializedName("listCategory")
    private Category[] listCategory;


    public AllSanPham(String msg, SanPham[] listProduct, Category[] listCategory) {
        this.msg = msg;
        this.listProduct = listProduct;
        this.listCategory = listCategory;
    }

    public AllSanPham() {
    }

    public Category[] getListCategory() {
        return listCategory;
    }

    public void setListCategory(Category[] listCategory) {
        this.listCategory = listCategory;
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
