package com.example.gocoffee.Screen.Setting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.gocoffee.R;
import com.example.gocoffee.api.ApiService;
import com.example.gocoffee.models.AllUser;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChangeProfile extends AppCompatActivity {
    private ImageView btnback;

    private Boolean mess;

    private ImageView avatar;
    private EditText edtName,edtAddress,edtEmail,edtPhone;

    private Button btnUpdate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_profile);
        btnback = findViewById(R.id.btnback3);

        avatar = findViewById(R.id.profile_avatar);
        edtAddress = findViewById(R.id.profile_address);
        edtEmail = findViewById(R.id.profile_email);
        edtName = findViewById(R.id.profile_name);
        edtPhone = findViewById(R.id.profile_phone);

        btnUpdate = findViewById(R.id.profile_btn_update);

        SharedPreferences sharedPreferences = getApplication().getSharedPreferences("share", Context.MODE_PRIVATE);

        String name = sharedPreferences.getString("name","");
        String email = sharedPreferences.getString("email","");
        String phone = sharedPreferences.getString("phone","");
        String address =sharedPreferences.getString("address","");
        String username = sharedPreferences.getString("username","");


        Glide.with(getApplication()).load("https://gocoffe.herokuapp.com" + sharedPreferences.getString("avata","")).error(R.drawable.img_14).into(avatar);

        edtName.setText(name);
        edtEmail.setText(email);
        edtPhone.setText(phone);
        edtAddress.setText(address);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postUpdateUser(name,username,address,email,phone);
            }
        });
    }

    private void postUpdateUser (String name,String userName,String address,String email,String phone){

        ApiService.apiService.postUpdateUser(name,userName,email,phone,address).enqueue(new Callback<AllUser>() {
            @Override
            public void onResponse(Call<AllUser> call, Response<AllUser> response) {

                Toast.makeText(getApplicationContext(),"Update thành công",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<AllUser> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Update thất bại!",Toast.LENGTH_SHORT).show();

            }
        });
    }
}