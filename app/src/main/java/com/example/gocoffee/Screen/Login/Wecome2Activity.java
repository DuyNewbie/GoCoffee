package com.example.gocoffee.Screen.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.gocoffee.R;

public class Wecome2Activity extends AppCompatActivity {

    private ImageView imgNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wecome2);

        imgNext = findViewById(R.id.ic_Wecome2);
        Intent intent = new Intent(Wecome2Activity.this , WelcomeActivity.class);

        imgNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
                finish();
            }
        });
    }
}