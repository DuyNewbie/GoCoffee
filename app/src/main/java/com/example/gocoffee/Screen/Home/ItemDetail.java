package com.example.gocoffee.Screen.Home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.gocoffee.R;
import com.example.gocoffee.fragment.HomeFragment;

public class ItemDetail extends AppCompatActivity {

    private ImageView btnback;
    private TextView tvName,tvPrice,tvDetail;
    private ImageView imgBanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);
        tvName = findViewById(R.id.tvitemDetail_name);
        tvPrice = findViewById(R.id.tvitemDetail_price);
        imgBanner = findViewById(R.id.imgitemDetail_banner);
        btnback = findViewById(R.id.itemDetail_back);
        tvDetail = findViewById(R.id.itemDetail_description);
        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("object_name");
        String price = bundle.getString("object_price");
        String img = bundle.getString("object_img");
        String detail = bundle.getString("object_detail");
        tvName.setText(name);
        tvPrice.setText(price+"VNĐ");
        tvDetail.setText(detail);
        Glide.with(getApplicationContext()).load("https://gocoffe.herokuapp.com" + img).error(R.drawable.img_4).into(imgBanner);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ItemDetail.this, HomeFragment.class);
                finish();
            }
        });

    }
}