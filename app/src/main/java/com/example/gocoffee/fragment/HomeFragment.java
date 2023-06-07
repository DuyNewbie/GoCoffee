package com.example.gocoffee.fragment;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.gocoffee.R;
import com.example.gocoffee.adapters.Home_adapter_recyclerview;
import com.example.gocoffee.api.ApiService;
import com.example.gocoffee.models.AllSanPham;
import com.example.gocoffee.models.SanPham;
import com.example.gocoffee.models.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    private SearchView searchView;
    private RecyclerView mRecyclerView;
    private Home_adapter_recyclerview mAdapter;
    private List<SanPham> mArrayList = new ArrayList<>();
    private TextView tvnameuser,tvroleuser;
    private ImageView imgavata;

    private AllSanPham allSanPham = new AllSanPham();


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
        tvnameuser = view.findViewById(R.id.tvnameuser);
        tvroleuser = view.findViewById(R.id.tvrole);
        imgavata = view.findViewById(R.id.imgavata);
        searchView.clearFocus();
        getDataUser();
        getData();


        LinearLayoutManager layoutManager =new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(layoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL);
        mRecyclerView.addItemDecoration(dividerItemDecoration);

        callAPIProducts();

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
//        mArrayList.add(new SanPham("Cofee đen đá khồn đường","Coffe",R.drawable.img_19,20000));
//        mArrayList.add(new SanPham("Cofee đen đá có đường","Coffe",R.drawable.img_19,10000));
//        mArrayList.add(new SanPham("Cofee sữa","Coffe",R.drawable.img_19,30000));
//        mArrayList.add(new SanPham("Bạc xỉu","Coffe",R.drawable.img_19,40000));
//        mArrayList.add(new SanPham("Capuchino","Coffe",R.drawable.img_19,50000));
//        mArrayList.add(new SanPham("Coffe code ","Coffe",R.drawable.img_19,60000));

    }
    private void getDataUser(){
        Bundle bundle = getActivity().getIntent().getExtras();
        String name = bundle.getString("name");
        String role = bundle.getString("role");
        String avata = bundle.getString("avata");
        tvnameuser.setText(name);
        tvroleuser.setText(role);
        Glide.with(getContext()).load("https://gocoffe.herokuapp.com" + avata).error(R.drawable.img_4).into(imgavata);
    }

    private void callAPIProducts(){

        ApiService.apiService.getListSanPham().enqueue(new Callback<AllSanPham>() {
            @Override
            public void onResponse(Call<AllSanPham> call, Response<AllSanPham> response) {
                allSanPham = response.body();
                mArrayList = Arrays.asList(response.body().getListProduct());

                mAdapter = new Home_adapter_recyclerview(getActivity());
                mAdapter.setData(mArrayList);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<AllSanPham> call, Throwable t) {
                Toast.makeText(getActivity(), "Lỗi call api", Toast.LENGTH_SHORT).show();

            }
        });
//        ApiService.apiService.getListSanPham().enqueue(new Callback<List<SanPham>>() {
//            @Override
//            public void onResponse(Call<List<SanPham>> call, Response<List<SanPham>> response) {

//
//            }
//
//            @Override
//            public void onFailure(Call<List<SanPham>> call, Throwable t) {
//            }
//        });
    }







}