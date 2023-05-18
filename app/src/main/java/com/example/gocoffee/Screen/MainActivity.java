package com.example.gocoffee.Screen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.example.gocoffee.R;
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

        AHBottomNavigation bottomNavigation = findViewById(R.id.bottom_navigation);


        AHBottomNavigationItem item1 = new AHBottomNavigationItem(R.string.tab_1, R.drawable.home_24, R.color.color_tab_1);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem(R.string.tab_2, R.drawable.cart_24, R.color.color_tab_1);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem(R.string.tab_3, R.drawable.account_circle_24, R.color.color_tab_1);

        bottomNavigation.addItem(item1);
        bottomNavigation.addItem(item2);
        bottomNavigation.addItem(item3);
        bottomNavigation.setTitleState(AHBottomNavigation.TitleState.SHOW_WHEN_ACTIVE_FORCE);
        bottomNavigation.setColored(true);

        bottomNavigation.setAccentColor(Color.parseColor("#EFE4C8"));
        bottomNavigation.setInactiveColor(Color.parseColor("#747474"));
        if (savedInstanceState == null) {

        }
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout , new HomeFragment()).commit();    //// set default fragment
        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
                switch (position){
                    case 0 :
                        replaceFrament(new HomeFragment());
                        break;
                    case 1 :
                        replaceFrament(new CartFragment());
                        break;
                    case 2 :
                        replaceFrament(new AccountFragment());
                        break;

                    default:
                        break;
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