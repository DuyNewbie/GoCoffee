package com.example.gocoffee.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.gocoffee.Screen.Setting.ChangeLangage;
import com.example.gocoffee.Screen.Setting.ChangePass;
import com.example.gocoffee.Screen.Setting.ChangeProfile;
import com.example.gocoffee.Screen.Setting.Contact;
import com.example.gocoffee.Screen.Setting.PurchaseHistory;
import com.example.gocoffee.R;
import com.example.gocoffee.Screen.Setting.TermsofService;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AccountFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AccountFragment extends Fragment {
    Context context;

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
        changeProfile = view.findViewById(R.id.changeProfile);
        changePass = view.findViewById(R.id.btnchangepass);
        logoutTK = view.findViewById(R.id.btnlogoutTK);
        history = view.findViewById(R.id.btnhistory);
        dieuKhoan = view.findViewById(R.id.btnDieuKhoan);
        contact = view.findViewById(R.id.btnContact);
        changeLang = view.findViewById(R.id.btnChangeLang);
        thoatapp = view.findViewById(R.id.btnThoat);
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
        thoatapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });
    }
}