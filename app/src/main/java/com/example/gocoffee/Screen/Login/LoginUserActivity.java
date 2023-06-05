package com.example.gocoffee.Screen.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gocoffee.R;
import com.example.gocoffee.Screen.MainActivity;
import com.example.gocoffee.api.ApiService;
import com.example.gocoffee.fragment.HomeFragment;
import com.example.gocoffee.models.AllUser;
import com.example.gocoffee.models.PostUser;
import com.example.gocoffee.models.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Field;

public class LoginUserActivity extends AppCompatActivity {

    private TextView tv_signUp;
    private EditText edt_User, edt_Pass;
    private Button btnLogin;
    private List<AllUser> mUsers;
    private List<User> mUser;
    private User muser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user);
        edt_User = findViewById(R.id.edusername);
        edt_Pass = findViewById(R.id.edpassword);
        btnLogin = findViewById(R.id.btn_Login);
        tv_signUp = findViewById(R.id.login_tv_signUp);



        mUsers = new ArrayList<>();
//        mUser =  new ArrayList<>();
        ArrayList<AllUser> user = new ArrayList<>();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mUser == null || mUser.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Tài khoản và mật khẩu sai ", Toast.LENGTH_SHORT).show();
                }
                for (User user: mUser) {
                    String Username = edt_User.getText().toString().trim();
                    String Password = edt_Pass.getText().toString().trim();
                    if (Username.equals(user.getUsername()) && Password.equals(user.getPassword())){
                        ////Đăng nhập thành công
                        Toast.makeText(getApplicationContext(), "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                        PostUser(Username,Password);
                        Intent intent = new Intent(LoginUserActivity.this, MainActivity.class);
                        muser = user;
                        Bundle bundle = new Bundle();
                        bundle.putString("name", user.getFullname());
                        bundle.putString("role", user.getRole());
                        bundle.putString("avata", user.getAvata());
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                    else {

                    }
                }

            }
        });

        tv_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginUserActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });

        CallUser();

    }
    private void CallUser() {
        ApiService.apiService.getListUser().enqueue(new Callback<AllUser>() {
            @Override
            public void onResponse(Call<AllUser> call, Response<AllUser> response) {
                mUser = Arrays.asList(response.body().getListUser());
            }

            @Override
            public void onFailure(Call<AllUser> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Lỗi call api", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void PostUser(String Username,String Password){
        ApiService.apiService.postUser(Username,Password).enqueue(new Callback<PostUser>() {
            @Override
            public void onResponse(Call<PostUser> call, Response<PostUser> response) {
                Toast.makeText(LoginUserActivity.this,"Send thành công", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<PostUser> call, Throwable t) {
                Toast.makeText(LoginUserActivity.this, "Call thất bại", Toast.LENGTH_SHORT).show();
            }
        });
    }
}