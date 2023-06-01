package com.example.gocoffee.Screen.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gocoffee.R;
import com.example.gocoffee.Screen.MainActivity;
import com.example.gocoffee.api.ApiService;
import com.example.gocoffee.models.User;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginUserActivity extends AppCompatActivity {

    private EditText edt_User, edt_Pass;
    private Button btnLogin;
    private List<User> mUsers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user);
        edt_User = findViewById(R.id.edusername);
        edt_Pass = findViewById(R.id.edpassword);
        btnLogin = findViewById(R.id.btn_Login);
        mUsers = new ArrayList<>();

        ArrayList<User> user = new ArrayList<>();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Username = edt_User.getText().toString().trim();
                String Password = edt_Pass.getText().toString().trim();
                if (mUsers == null || mUsers.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Tài khoản và mật khẩu sai ", Toast.LENGTH_SHORT).show();
                    return;
                }
                for (User user: mUsers) {
                    if (Username.equals(user.getUsername()) && Password.equals(user.getPassword())){
                        ////Đăng nhập thành công
                        Toast.makeText(getApplicationContext(), "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
//                        muser = user;
//                        Bundle bundle = new Bundle();
//                        bundle.putSerializable("object_user", (Serializable) muser);
//                        intent.putExtras(bundle);
                         Intent iHome = new Intent(getApplicationContext(), MainActivity.class);
                         startActivity(iHome);
                         finish();
                    }
                    else {

                    }
                }
//
            }
        });
        CallUser();
    }
    private void CallUser(){
        ApiService.apiService.getListUser().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                mUsers = response.body();
                Log.i("Keytest", String.valueOf(response.body()));
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Lỗi call api user", Toast.LENGTH_SHORT).show();
            }
        });
    }
}