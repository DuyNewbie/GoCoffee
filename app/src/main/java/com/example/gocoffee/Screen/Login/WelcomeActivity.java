package com.example.gocoffee.Screen.Login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.gocoffee.R;
import com.example.gocoffee.Screen.MainActivity;

public class WelcomeActivity extends AppCompatActivity {

    private CardView imgNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        imgNext = findViewById(R.id.ic_wecome);
        Intent intent = new Intent(WelcomeActivity.this , Wecome2Activity.class);

        imgNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
                finish();
            }
        });
    }
}