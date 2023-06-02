package com.example.gocoffee.api;

import com.example.gocoffee.models.AllUser;
import com.example.gocoffee.models.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
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
}
