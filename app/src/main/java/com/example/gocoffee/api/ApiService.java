package com.example.gocoffee.api;

import com.example.gocoffee.models.AllMessCart;
import com.example.gocoffee.models.AllSanPham;
import com.example.gocoffee.models.AllUser;
import com.example.gocoffee.models.Cart;
import com.example.gocoffee.models.MessegerAccount;
import com.example.gocoffee.models.MessegerUser;
import com.example.gocoffee.models.PostUser;
import com.example.gocoffee.models.SanPham;
import com.example.gocoffee.models.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    /// Link Api : http://gocoffe.herokuapp.com/api/user  https://gocoffe.herokuapp.com/api/user
    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    ApiService apiService = new Retrofit.Builder().baseUrl("https://gocoffe.herokuapp.com/api/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build().create(ApiService.class);

    @GET("user")
    Call<AllUser> getListUser();
    @GET("user")
    Call<AllUser> getListUser(@Query("tagged") String tags);
    @GET("login-app")
    Call<MessegerUser> postUser(@Query("UserName") String UserName, @Query("PassWord") String PassWord);
    @POST("create-account")
    Call<MessegerAccount> postProduct(@Query("UserName") String UserName,
                                      @Query("PassWord") String PassWord,
                                      @Query("FullName") String FullName,
                                      @Query("Address") String Address,
                                      @Query("Email") String Email,
                                      @Query("Phone") String Phone);


    @GET("product")
    Call<AllSanPham> getListSanPham();

    @GET("product")
    Call<AllSanPham> getProductByCategory(@Query("idCategory") String idCategory);

    @GET("list-cart")
    Call<AllMessCart> getCart(@Query("idUser") String idUser);


}
