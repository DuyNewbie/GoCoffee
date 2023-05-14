package com.example.gocoffee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.gocoffee.fragment.AccountFragment;
import com.example.gocoffee.fragment.CartFragment;
import com.example.gocoffee.fragment.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String DuyMoiChoi = "test pust code to git 1";
        String Hoangseven = "test pust code to git 1";
        String HungVh = "test pust code to git 1";
        String hiepDeepTry = "Hiệp đẹp trai vô địch vũ trụ";

        navigationView = findViewById(R.id.bottomNavigationView);
        navigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.navigation_home) {
                    replaceFrament(new HomeFragment());
                } else if (itemId == R.id.navigation_cart) {
                    replaceFrament(new CartFragment());
                } else if (itemId == R.id.navigation_account) {
                    replaceFrament(new AccountFragment());
                }
                return true;
            }
        });


    }
    private  void  replaceFrament(Fragment fragment){
        FragmentManager fragmentManager  = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameLayout,fragment);
        transaction.commit();

    }
}