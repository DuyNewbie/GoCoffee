package com.example.gocoffee.data_local;

import android.content.Context;
import android.content.SharedPreferences;

public class MySharePreferences {
    public static final String MY_SF = "MY_SF";
    public Context mContext;

    public MySharePreferences(Context context){
        this.mContext = context;
    }

    //lấy dữ liệu kiểu Boolean
    public void putBooleanValue(String key, Boolean value){
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(MY_SF, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public boolean getBooleanValue(String key){
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(MY_SF, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(key, false);
    }
    // lấy trạng thái đăng nhập
    public void putTrangThai(String key, Boolean value){
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(MY_SF, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public boolean getTrangThai(String key){
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(MY_SF, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(key, false);
    }

    // lấy dữ liệu kiểu string
    public void putUser(String key, String value){
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(MY_SF, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public String getUser(String key){
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(MY_SF, Context.MODE_PRIVATE);
        return sharedPreferences.getString(key, "");
    }
}
