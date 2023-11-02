package com.example.gocoffee.api;

import com.example.gocoffee.models.AllMessCart;
import com.example.gocoffee.models.AllSanPham;
import com.example.gocoffee.models.AllUser;
import com.example.gocoffee.models.MessAddCart;
import com.example.gocoffee.models.MessBill;
import com.example.gocoffee.models.MessegerAccount;
import com.example.gocoffee.models.MessegerUser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    ApiService apiService = new Retrofit.Builder().baseUrl(apiLink.BASE_API + "/api/")
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
    @POST("add-cart")
    Call<MessAddCart> postCart(@Query("idUser") String idUser,
                               @Query("idProduct") String idProduct,
                               @Query("Quantity") int Quantity);

    @POST("change-info")
    Call<AllUser> postUpdateUser(@Query("FullName") String name,
                        @Query("UserName") String userName,
                        @Query("Email") String email,
                        @Query("Phone") String phone,
                        @Query("Address") String address);
    @POST("add-bill")
    Call<MessBill> postBill(@Query("idUser") String idUser,
                            @Query("listCart")String listCart,
                            @Query("Prices") int Prices);

}
