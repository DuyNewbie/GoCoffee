package com.example.gocoffee.Screen.Login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.gocoffee.R;
import com.example.gocoffee.Screen.MainActivity;

public class WelcomeActivity extends AppCompatActivity {

    private CardView imgNext;
    private RelativeLayout idmanchao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        idmanchao = findViewById(R.id.idmanchao);
        imgNext = findViewById(R.id.ic_wecome);
        Intent intent = new Intent(WelcomeActivity.this , Wecome2Activity.class);
        SharedPreferences sharedPreferences = getSharedPreferences("sharef1",Context.MODE_PRIVATE);
        boolean landau = sharedPreferences.getBoolean("f1",false);
        if (landau){
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }else {
            imgNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SharedPreferences prefs = getSharedPreferences("sharef1",Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putBoolean("f1",true);
                    editor.apply();
                    startActivity(intent);
                    finish();
                }
            });
        }


    }
}