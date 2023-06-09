package com.example.gocoffee.Screen.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gocoffee.R;

public class SignUpActivity extends AppCompatActivity {
    private TextView error_username,error_password,error_password_enter,tv_signup;
    private EditText edusername,edpassword,edpasswordenter;
    private Button btnReg;
    private ImageView btnback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        error_username = findViewById(R.id.signup_error_username);
        error_password = findViewById(R.id.signup_error_password);
        error_password_enter = findViewById(R.id.signup_error_password_enter);
        tv_signup = findViewById(R.id.tv_signup);
        edusername = findViewById(R.id.edsignup_name);
        edpassword = findViewById(R.id.edsignup_password);
        edpasswordenter = findViewById(R.id.edsignup_password_enter);
        btnReg = findViewById(R.id.btn_reg);
        btnback = findViewById(R.id.btnback7);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edusername.getText().toString().trim();
                String password = edpassword.getText().toString();
                String passwordenter = edpasswordenter.getText().toString();
                boolean chackvalidate = validateSignup(username,password,passwordenter);
                if (chackvalidate){
                    if (!password.equals(passwordenter)){
                        error_password_enter.setText("Nhập lại mật khẩu !");
                        error_password_enter.setBackground(getDrawable(R.drawable.bg_error));
                    }
                    else {
                        ClearErr();
                        Intent intent = new Intent(getApplicationContext(),RegisterActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("usernamereg",username);
                        bundle.putString("passwordreg",password);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                }
            }
        });
    }
    private boolean validateSignup(String username, String password,String passwordenter){
        if (username.isEmpty()){
            error_username.setText("Tài khoản không được để trống");
            error_username.setBackground(getDrawable(R.drawable.bg_error));
            return false;
        }
        else if(password.isEmpty()){
            error_username.setText("");
            error_username.setBackground(getDrawable(R.drawable.textlogin));
            error_password.setText("Mật khẩu không được để trống");
            error_password.setBackground(getDrawable(R.drawable.bg_error));
            return false;
        }
        else if(passwordenter.isEmpty()){
            error_username.setText("");
            error_password.setText("");
            error_username.setBackground(getDrawable(R.drawable.textlogin));
            error_password.setBackground(getDrawable(R.drawable.textlogin));
            error_password_enter.setText("Mật khẩu không được để trống");
            error_password_enter.setBackground(getDrawable(R.drawable.bg_error));
            return false;
        }
        ClearErr();
        return true;
    }
    private void ClearErr(){
        error_username.setText("");
        error_password.setText("");
        error_password_enter.setText("");
        error_username.setBackground(getDrawable(R.drawable.textlogin));
        error_password.setBackground(getDrawable(R.drawable.textlogin));
        error_password_enter.setBackground(getDrawable(R.drawable.textlogin));
    }
}