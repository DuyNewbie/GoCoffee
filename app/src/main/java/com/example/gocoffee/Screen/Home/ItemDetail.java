package com.example.gocoffee.Screen.Home;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.gocoffee.R;
import com.example.gocoffee.Screen.Login.LoginUserActivity;
import com.example.gocoffee.api.ApiService;
import com.example.gocoffee.fragment.HomeFragment;
import com.example.gocoffee.models.MessAddCart;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemDetail extends AppCompatActivity {

    private ImageView btnback;
    private TextView tvName, tvPrice, tvDetail, tvTongTien;
    private ImageView imgBanner;

    private ImageButton tang, giam;

    private EditText edtSoLuong;

    private Button btnAdd;

    private int soLuong = 1;
    private int tongTien = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        tvName = findViewById(R.id.tvitemDetail_name);
        tvPrice = findViewById(R.id.tvitemDetail_price);
        imgBanner = findViewById(R.id.imgitemDetail_banner);
        btnback = findViewById(R.id.itemDetail_back);
        tvDetail = findViewById(R.id.itemDetail_description);
        tang = findViewById(R.id.itemDetail_number_tang);
        giam = findViewById(R.id.itemDetail_number_giam);
        edtSoLuong = findViewById(R.id.itemDetail_number);
        tvTongTien = findViewById(R.id.itemDetail_tongTien);
        btnAdd = findViewById(R.id.itemDetail_add);



        Bundle bundle = getIntent().getExtras();
        String idproduct = bundle.getString("object_idproduct");
        String name = bundle.getString("object_name");
        String price = bundle.getString("object_price");
        String img = bundle.getString("object_img");
        String detail = bundle.getString("object_detail");
        tvName.setText(name);
        tvPrice.setText(price + "VNĐ");
        tvDetail.setText(detail);
        edtSoLuong.setText(soLuong + "");
        tongTien += Integer.parseInt(price);

        tvTongTien.setText("Thành tiền: " + tongTien + " VND");

        SharedPreferences sharedPreferences = getApplication().getSharedPreferences("share", Context.MODE_PRIVATE);
        boolean isLogin = sharedPreferences.getBoolean("IsLogin", false);

        String idUser = sharedPreferences.getString("idUser","");




        tang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soLuong = Integer.parseInt(edtSoLuong.getText().toString());
                soLuong++;
                tongTien = soLuong * Integer.parseInt(price);
                tvTongTien.setText("Thành tiền: " + tongTien + " VND");
                edtSoLuong.setText("" + soLuong);
            }
        });

        giam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soLuong = Integer.parseInt(edtSoLuong.getText().toString());
                if (soLuong >= 2) {
                    soLuong--;
                    edtSoLuong.setText("" + soLuong);
                    tongTien = soLuong * Integer.parseInt(price);
                    tvTongTien.setText("Thành tiền: " + tongTien + " VND");
                }

            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!isLogin) {
                    Intent intent = new Intent(ItemDetail.this, LoginUserActivity.class);
                    startActivity(intent);
                    Toast.makeText(ItemDetail.this, "Đăng nhập để mua hàng!", Toast.LENGTH_SHORT).show();
                } else {
                    soLuong = Integer.parseInt(edtSoLuong.getText().toString());
                    if (soLuong <= 0) {
                        Toast.makeText(ItemDetail.this, "Số lượng phải lớn hơn 0!", Toast.LENGTH_SHORT).show();
                        return;
                    } else {
                        Dialog dialog = new Dialog(ItemDetail.this);

                        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                        dialog.setContentView(R.layout.dialog_hoadon);
                        dialog.show();

                        TextView tvSoLuong = dialog.findViewById(R.id.dialog_soLuong);
                        TextView tvTongTien = dialog.findViewById(R.id.dialog_tongTien);

                        tvSoLuong.setText("Số lượng sản phẩm: " + soLuong);
                        tvTongTien.setText("Tổng tiền: " + tongTien + " VND");

                        Button ok = dialog.findViewById(R.id.dialog_Ok);
                        Button cancel = dialog.findViewById(R.id.dialog_Cancel);

                    ok.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ////
                            postAddCart(idUser,idproduct,soLuong);
                            dialog.dismiss();
                        }
                    });

                        cancel.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog.dismiss();
                            }
                        });

                    }
                }


            }
        });





        Glide.with(getApplicationContext()).load("https://gocoffe.herokuapp.com" + img).error(R.drawable.img_4).into(imgBanner);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ItemDetail.this, HomeFragment.class);
                finish();
            }
        });




    }
    private void postAddCart(String idUser,String idProduct,int Quantity){
        ApiService.apiService.postCart(idUser, idProduct, Quantity).enqueue(new Callback<MessAddCart>() {
            @Override
            public void onResponse(Call<MessAddCart> call, Response<MessAddCart> response) {
                Toast.makeText(getApplicationContext(), response.body().getMsg(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<MessAddCart> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Call không thành công", Toast.LENGTH_SHORT).show();

            }
        });
    }


}