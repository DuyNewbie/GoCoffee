package com.example.gocoffee.Screen.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gocoffee.R;
import com.example.gocoffee.api.ApiService;
import com.example.gocoffee.models.MessegerAccount;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    private ImageView btnback;
    private EditText edFullname,edAddress,edEmail,edPhone;
    private Button btnRegAll;
    private TextView errorfullname,erroraddress,erroremail,errorphone;
    private boolean messproduct;
    private ProgressDialog mProgressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        errorfullname = findViewById(R.id.signup_error_fullname);
        erroraddress = findViewById(R.id.signup_error_address);
        erroremail = findViewById(R.id.signup_error_email);
        errorphone = findViewById(R.id.signup_error_phone);
        btnback = findViewById(R.id.btnback8);
        edFullname = findViewById(R.id.edfullname_reg);
        edAddress = findViewById(R.id.edaddres_reg);
        edEmail = findViewById(R.id.edemail_reg);
        edPhone = findViewById(R.id.ednumberphone_reg);
        btnRegAll = findViewById(R.id.btn_regall);
        mProgressDialog = new ProgressDialog(RegisterActivity.this);
        mProgressDialog.setTitle("Đang đăng kí !");
        mProgressDialog.setMessage("Vui lòng đợi ...");

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        btnRegAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = getIntent().getExtras();
                String username = bundle.getString("usernamereg");
                String password = bundle.getString("passwordreg");
                String fullname = edFullname.getText().toString();
                String address = edAddress.getText().toString();
                String email = edEmail.getText().toString();
                String phone = edPhone.getText().toString();
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                boolean validateCheck = validateReg(fullname,address,email,phone);
                if (validateCheck){
                    if (!email.matches(emailPattern)){
                        erroremail.setText("Định dạng email sai !");
                        erroremail.setBackground(getDrawable(R.drawable.bg_error));
                    } else if (phone.length()<8||phone.length()>11) {
                        errorphone.setText("Định dạng số điện thoại sai");
                        errorphone.setBackground(getDrawable(R.drawable.bg_error));
                    }
                    else {
                        mProgressDialog.show();
                        AddProduct(username,password,fullname,address,email,phone);
                        Runnable progressRunnable = new Runnable() {

                            @Override
                            public void run() {
                                mProgressDialog.cancel();
                                //// thực hiện
                                if (!messproduct){
                                    Toast.makeText(getApplicationContext(),"Đăng ký không thành công",Toast.LENGTH_SHORT).show();
                                }
                                else {
                                    Toast.makeText(getApplicationContext(),"Đăng kí thành công",Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(),LoginUserActivity.class);
                                    startActivity(intent);
                                }
                            }
                        };

                        Handler pdCanceller = new Handler();
                        pdCanceller.postDelayed(progressRunnable, 3000);

                        ClearErr();

                    }
                }

            }
        });

    }
    private boolean validateReg(String fullname, String address,String email, String phone){
        if (fullname.isEmpty()){
            errorfullname.setText("Tên không được để trống");
            errorfullname.setBackground(getDrawable(R.drawable.bg_error));
            return false;
        }
        else if (address.isEmpty()){
            errorfullname.setText("");
            errorfullname.setBackground(getDrawable(R.drawable.textlogin));
            erroraddress.setText("Địa chỉ không được để trống");
            erroraddress.setBackground(getDrawable(R.drawable.bg_error));
            return false;
        }
        else if (email.isEmpty()){
            errorfullname.setText("");
            erroraddress.setText("");
            errorfullname.setBackground(getDrawable(R.drawable.textlogin));
            erroraddress.setBackground(getDrawable(R.drawable.textlogin));
            erroremail.setText("Email không được để trống");
            erroremail.setBackground(getDrawable(R.drawable.bg_error));
            return false;
        }
        else if (phone.isEmpty()){
            errorfullname.setText("");
            erroraddress.setText("");
            erroremail.setText("");
            errorfullname.setBackground(getDrawable(R.drawable.textlogin));
            erroraddress.setBackground(getDrawable(R.drawable.textlogin));
            erroremail.setBackground(getDrawable(R.drawable.textlogin));
            errorphone.setText("Số điện thoại không được để trống");
            errorphone.setBackground(getDrawable(R.drawable.bg_error));
            return false;
        }
        ClearErr();
        return true;
    }
    private void ClearErr(){
        errorfullname.setText("");
        erroraddress.setText("");
        erroremail.setText("");
        errorphone.setText("");
        errorfullname.setBackground(getDrawable(R.drawable.textlogin));
        erroraddress.setBackground(getDrawable(R.drawable.textlogin));
        erroremail.setBackground(getDrawable(R.drawable.textlogin));
        errorphone.setBackground(getDrawable(R.drawable.textlogin));
    }
    private void AddProduct(String username,String password,String fullname, String address,String email, String phone){

        ApiService.apiService.postProduct(username,password,fullname,address,email,phone).enqueue(new Callback<MessegerAccount>() {
            @Override
            public void onResponse(Call<MessegerAccount> call, Response<MessegerAccount> response) {

                messproduct = response.body().isComplete();
            }

            @Override
            public void onFailure(Call<MessegerAccount> call, Throwable t) {

                Toast.makeText(RegisterActivity.this, "Call không thành công", Toast.LENGTH_SHORT).show();
            }
        });
    }
}