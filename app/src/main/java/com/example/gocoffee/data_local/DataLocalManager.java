package com.example.gocoffee.data_local;

import android.content.Context;

public class DataLocalManager {
    private static final String PREF_FIRST_INSTALL = "PREF_FIRST_INSTALL";
    private static final String TRANG_THAI = "TRANG_THAI";
    private static final String USER_NAME = "USER_NAME";
    private static final String PASS = "PASS";


    private static DataLocalManager instance;
    private MySharePreferences mySharePreferences;

    public static void init(Context context){
        instance = new DataLocalManager();
        instance.mySharePreferences = new MySharePreferences(context);
    }

    public static DataLocalManager getInstance(){
        if(instance == null){
            instance = new DataLocalManager();
        }
        return instance;
    }


    public static void setLanDauVaoApp(Boolean isFirst){
        DataLocalManager.getInstance().mySharePreferences.putBooleanValue(PREF_FIRST_INSTALL, isFirst);
    }

    public static boolean getLanDauVaoApp(){
        return DataLocalManager.getInstance().mySharePreferences.getBooleanValue(PREF_FIRST_INSTALL);
    }

    public static void setTrangThaiDangNhap(Boolean trangThai){
        DataLocalManager.getInstance().mySharePreferences.putTrangThai(TRANG_THAI, trangThai);
    }

    public static boolean layTrangThaiDangNhap(){
        return DataLocalManager.getInstance().mySharePreferences.getTrangThai(TRANG_THAI);
    }

    public static void setUser(String user){
        DataLocalManager.getInstance().mySharePreferences.putUser(USER_NAME, user);
    }

    public static String getUser(){
        return DataLocalManager.getInstance().mySharePreferences.getUser(USER_NAME);
    }

    public static void setMatKhau(String user){
        DataLocalManager.getInstance().mySharePreferences.putUser(PASS, user);
    }

    public static String getMatKhau(){
        return DataLocalManager.getInstance().mySharePreferences.getUser(PASS);
    }

}
