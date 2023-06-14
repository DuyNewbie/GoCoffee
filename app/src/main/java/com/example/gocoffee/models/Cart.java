package com.example.gocoffee.models;

public class Cart {
    private String nameproductcart,priceproductcart,imgavatacart;
    private int soluong ;

    public Cart(String nameproductcart, String priceproductcart, String imgavatacart, int soluong) {
        this.nameproductcart = nameproductcart;
        this.priceproductcart = priceproductcart;
        this.imgavatacart = imgavatacart;
        this.soluong = soluong;
    }

    public String getNameproductcart() {
        return nameproductcart;
    }

    public void setNameproductcart(String nameproductcart) {
        this.nameproductcart = nameproductcart;
    }

    public String getPriceproductcart() {
        return priceproductcart;
    }

    public void setPriceproductcart(String priceproductcart) {
        this.priceproductcart = priceproductcart;
    }

    public String getImgavatacart() {
        return imgavatacart;
    }

    public void setImgavatacart(String imgavatacart) {
        this.imgavatacart = imgavatacart;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
}
