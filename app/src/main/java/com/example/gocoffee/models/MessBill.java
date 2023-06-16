package com.example.gocoffee.models;

import com.google.gson.annotations.SerializedName;

public class MessBill {
    @SerializedName("msg")
    private String msg;
    @SerializedName("isComplete")
    private boolean isComplete;

    public MessBill(String msg, boolean isComplete) {
        this.msg = msg;
        this.isComplete = isComplete;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }
}
