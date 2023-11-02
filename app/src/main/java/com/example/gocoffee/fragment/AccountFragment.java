package com.example.gocoffee.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.gocoffee.Screen.Login.LoginUserActivity;
import com.example.gocoffee.Screen.Login.SignUpActivity;
import com.example.gocoffee.Screen.Setting.ChangeLangage;
import com.example.gocoffee.Screen.Setting.ChangePass;
import com.example.gocoffee.Screen.Setting.ChangeProfile;
import com.example.gocoffee.Screen.Setting.Contact;
import com.example.gocoffee.Screen.Setting.PurchaseHistory;
import com.example.gocoffee.R;
import com.example.gocoffee.Screen.Setting.TermsofService;
import com.example.gocoffee.api.apiLink;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AccountFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AccountFragment extends Fragment {
    Context context;
    private TextView tvnameaccount,tvroleaccount,btnDangKi;
    private ImageView imgacount;
    private LinearLayout ttDangNhap,ttDoneDangNhap;
    private Button btnDangNhap;

    LinearLayout changeProfile,changePass,logoutTK,history,dieuKhoan,contact,changeLang,thoatapp;
    public AccountFragment() {
        // Required empty public constructor
    }


    public static AccountFragment newInstance(String param1, String param2) {
        AccountFragment fragment = new AccountFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnDangNhap = view.findViewById(R.id.btnDangNhap);
        btnDangKi = view.findViewById(R.id.btnDangKi);
        ttDangNhap = view.findViewById(R.id.ttDangNhap);
        ttDoneDangNhap = view.findViewById(R.id.ttDoneDangNhap);
        changeProfile = view.findViewById(R.id.changeProfile);
        changePass = view.findViewById(R.id.btnchangepass);
        logoutTK = view.findViewById(R.id.btnlogoutTK);
        history = view.findViewById(R.id.btnhistory);
        dieuKhoan = view.findViewById(R.id.btnDieuKhoan);
        contact = view.findViewById(R.id.btnContact);
        changeLang = view.findViewById(R.id.btnChangeLang);
        thoatapp = view.findViewById(R.id.btnThoat);
        tvnameaccount = view.findViewById(R.id.tvnameaccount);
        tvroleaccount = view.findViewById(R.id.tvroleaccount);
        imgacount = view.findViewById(R.id.imgaccount);
//        if (DataLocalManager.layTrangThaiDangNhap()){
//            ttDangNhap.setVisibility(View.GONE);
//            getDataUser();
//        }
//        else{
//            ttDangNhap.setVisibility(View.INVISIBLE);
//        }
//        getDataUser();


        /// xử lý trạng thái đăng nhập
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("share", Context.MODE_PRIVATE);
        boolean isLogin = sharedPreferences.getBoolean("IsLogin",false);
        if (isLogin){
            ttDangNhap.setVisibility(View.VISIBLE);
            ttDoneDangNhap.setVisibility(View.GONE);
            getDataUser();
        }
        else {
            ttDangNhap.setVisibility(View.GONE);
            ttDoneDangNhap.setVisibility(View.VISIBLE);
        }

        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), LoginUserActivity.class));
            }
        });
        btnDangKi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), SignUpActivity.class));
            }
        });

        changeProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ChangeProfile.class);
                startActivity(intent);
            }
        });
        changePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ChangePass.class);
                startActivity(intent);
            }
        });
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), PurchaseHistory.class);
                startActivity(intent);
            }
        });
        dieuKhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), TermsofService.class);
                startActivity(intent);
            }
        });
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Contact.class);
                startActivity(intent);
            }
        });
        changeLang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ChangeLangage.class);
                startActivity(intent);
            }
        });

        logoutTK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), LoginUserActivity.class));
                getActivity().finish();
                SharedPreferences settings = getActivity().getSharedPreferences("share", Context.MODE_PRIVATE);
                settings.edit().clear().commit();

            }
        });
        thoatapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });
    }
    private void getDataUser(){
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("share", Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("name","");
        String role = sharedPreferences.getString("role","");
        String avata = sharedPreferences.getString("avata","");
        tvnameaccount.setText(name);
        tvroleaccount.setText(role);
        Glide.with(getContext()).load(apiLink.BASE_API + avata).error(R.drawable.img_4).into(imgacount);
    }
}