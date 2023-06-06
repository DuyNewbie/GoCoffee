package com.example.gocoffee.Screen.Login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gocoffee.R;
import com.example.gocoffee.Screen.MainActivity;
import com.example.gocoffee.api.ApiService;
import com.example.gocoffee.api.RetrofitClient;
import com.example.gocoffee.fragment.HomeFragment;
import com.example.gocoffee.models.AllUser;
import com.example.gocoffee.models.MessegerUser;
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
import retrofit2.Retrofit;
import retrofit2.http.Field;
import retrofit2.http.GET;

public class LoginUserActivity extends AppCompatActivity {

    private TextView tv_signUp, error_username, error_password;
    private EditText edt_User, edt_Pass;
    private Button btnLogin;
    private List<AllUser> mUsers;
    private List<User> mUser;
    private User muser;
    private Boolean mess;

    String msg = "";
    private SharedPreferences loginPreferences;
    private SharedPreferences.Editor loginPrefsEditor;
    private CheckBox saveLoginCheckBox;
    private Boolean saveLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user);
        edt_User = findViewById(R.id.edusername);
        edt_Pass = findViewById(R.id.edpassword);
        btnLogin = findViewById(R.id.btn_Login);
        tv_signUp = findViewById(R.id.login_tv_signUp);
        error_username = findViewById(R.id.login_error_username);
        error_password = findViewById(R.id.login_error_password);
        saveLoginCheckBox = findViewById(R.id.login_chk);


        mUsers = new ArrayList<>();
//        mUser =  new ArrayList<>();
        ArrayList<AllUser> user = new ArrayList<>();
        loginPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);
        loginPrefsEditor = loginPreferences.edit();
        saveLogin = loginPreferences.getBoolean("saveLogin", false);
        if (saveLogin == true) {
            edt_User.setText(loginPreferences.getString("username", ""));
            edt_Pass.setText(loginPreferences.getString("password", ""));
            saveLoginCheckBox.setChecked(true);
        }
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Username = edt_User.getText().toString().trim();
                String Password = edt_Pass.getText().toString();
                boolean validateResult = validateUser(Username, Password);
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(edt_User.getWindowToken(), 0);





                if (validateResult == true) {
//                    if (mUser == null || mUser.isEmpty()){
//                        Toast.makeText(getApplicationContext(), "Chưa có user", Toast.LENGTH_SHORT).show();
//                    }

                    for (User user : mUser) {

                        if (!Username.equals(user.getUsername())) {
                            error_username.setText("Tài khoản không tồn tại!");
                            edt_User.setBackground(getDrawable(R.drawable.bg_error));

                        } else {
                            if (!Password.equals(user.getPassword())) {
                                error_password.setText("Sai mật khẩu");
                                edt_Pass.setBackground(getDrawable(R.drawable.bg_error));
                                return;
                            } else {
                                clearError();
                                Toast.makeText(getApplicationContext(), "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                                if (saveLoginCheckBox.isChecked()) {
                                    loginPrefsEditor.putBoolean("saveLogin", true);
                                    loginPrefsEditor.putString("username", Username);
                                    loginPrefsEditor.putString("password", Password);
                                    loginPrefsEditor.commit();
                                } else {
                                    loginPrefsEditor.clear();
                                    loginPrefsEditor.commit();
                                }

                                Intent intent = new Intent(LoginUserActivity.this, MainActivity.class);
                                muser = user;
                                Bundle bundle = new Bundle();
                                bundle.putString("name", user.getFullname());
                                bundle.putString("role", user.getRole());
                                bundle.putString("avata", user.getAvata());
                                intent.putExtras(bundle);
                                startActivity(intent);
                                LoginUserActivity.this.finish();

                            }
                        }

//                        if (Username.equals(user.getUsername()) && Password.equals(user.getPassword())){
//                            ////Đăng nhập thành công
//                            Toast.makeText(getApplicationContext(), "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
//                            PostUser(Username,Password);
//                            Intent intent = new Intent(LoginUserActivity.this, MainActivity.class);
//                            muser = user;
//                            Bundle bundle = new Bundle();
//                            bundle.putString("name", user.getFullname());
//                            bundle.putString("role", user.getRole());
//                            bundle.putString("avata", user.getAvata());
//                            intent.putExtras(bundle);
//                            startActivity(intent);
//                        }
//                        else {
//
//                        }
                    }
                }


            }
        });


        tv_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginUserActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

        CallUser();
        PostUser();
    }

    private boolean validateUser(String username, String password) {
        if (username.isEmpty()) {
//            setUsernameError('Username field cannot be empty');
            error_username.setText("Tài khoản không được để trống");
            edt_User.setBackground(getDrawable(R.drawable.bg_error));

            return false;
        } else if (password.isEmpty()) {
            error_username.setText("");
            error_password.setText("Mật khẩu không được để trống");
            edt_User.setBackground(getDrawable(R.drawable.textlogin));
            edt_Pass.setBackground(getDrawable(R.drawable.bg_error));

            return false;
        }
        clearError();
        return true;
    }

    private void clearError(){
        error_password.setText("");
        error_username.setText("");
        edt_User.setBackground(getDrawable(R.drawable.textlogin));
        edt_Pass.setBackground(getDrawable(R.drawable.textlogin));
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

    private void PostUser() {

//        ApiService apiService = RetrofitClient.getRetrofitInstance().create(ApiService.class);
//        Call<MessegerUser> call = apiService.postUser("cuongtest","a");
//        call.enqueue(new Callback<MessegerUser>() {
//            @Override
//            public void onResponse(Call<MessegerUser> call, Response<MessegerUser> response) {
//                String mess = response.body().getMsg().toString();
//                Toast.makeText(getApplicationContext(),mess,Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onFailure(Call<MessegerUser> call, Throwable t) {
//                Toast.makeText(getApplicationContext(),"Đăng nhập không thành công",Toast.LENGTH_SHORT).show();
//            }
//        });
        ApiService.apiService.postUser("cuongtest","a").enqueue(new Callback<MessegerUser>() {
            @Override
            public void onResponse(Call<MessegerUser> call, Response<MessegerUser> response) {
                Toast.makeText(getApplicationContext(),response.body().getMsg(),Toast.LENGTH_SHORT).show();
                mess= response.body().getCheckLogin();
            }

            @Override
            public void onFailure(Call<MessegerUser> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"call khoong thanh cong",Toast.LENGTH_SHORT).show();

            }
        });
    }
}