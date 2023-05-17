package com.example.gocoffee.fragment;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.gocoffee.R;
import com.example.gocoffee.adapters.Home_adapter_recyclerview;
import com.example.gocoffee.models.SanPham;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    private SearchView searchView;
    private RecyclerView mRecyclerView;
    private Home_adapter_recyclerview mAdapter;
    private ArrayList<SanPham> mArrayList = new ArrayList<>();


    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        searchView = view.findViewById(R.id.searchView);
        mRecyclerView = view.findViewById(R.id.home_RecyclerView);

        searchView.clearFocus();

        getData();

        mAdapter = new Home_adapter_recyclerview(getActivity());
        mAdapter.setData(mArrayList);
        LinearLayoutManager layoutManager =new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filerList(newText);
                return true;
            }
        });
    }

    private void filerList(String newText) {
        ArrayList<SanPham> filteredList = new ArrayList<>();
        for (SanPham sp : mArrayList){
            if (sp.getName().toLowerCase().contains(newText.toLowerCase())){
                filteredList.add(sp);
            }
        }

        if (!filteredList.isEmpty()){
            mAdapter.setData(filteredList);
        }else {
            filteredList.clear();
            mAdapter.setData(filteredList);

        }
    }

    private void getData() {
        mArrayList.add(new SanPham("Trời hôm nay âm u","Coffe",R.drawable.img_19,20000));
        mArrayList.add(new SanPham("Kiểu thiếu emm","Coffe",R.drawable.img_19,10000));
        mArrayList.add(new SanPham("Sóng bắt nguồn từ gió","Coffe",R.drawable.img_19,30000));
        mArrayList.add(new SanPham("Gió bắt nguồn từ đâu","Coffe",R.drawable.img_19,40000));
        mArrayList.add(new SanPham("Anh cũng không biết nữa","Coffe",R.drawable.img_19,50000));
        mArrayList.add(new SanPham("Từ khi nào ta yêu nhauu ","Coffe",R.drawable.img_19,60000));

    }


}