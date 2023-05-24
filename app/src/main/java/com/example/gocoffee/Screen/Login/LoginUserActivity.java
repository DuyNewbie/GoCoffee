package com.example.gocoffee.Screen.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.gocoffee.R;
import com.example.gocoffee.Screen.MainActivity;

public class LoginUserActivity extends AppCompatActivity {

    private EditText edt_User, edt_Pass;
    private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user);

        btnLogin = findViewById(R.id.btn_Login);
        Intent iHome = new Intent(this , MainActivity.class);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(iHome);
                finish();
            }
        });
    }
}