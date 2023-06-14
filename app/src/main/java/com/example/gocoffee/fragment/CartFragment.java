package com.example.gocoffee.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.gocoffee.R;
import com.example.gocoffee.adapters.Home_adapter_recyclerview;
import com.example.gocoffee.adapters.Home_category_adapter_recyclerview;
import com.example.gocoffee.api.ApiService;
import com.example.gocoffee.models.AllMessCart;
import com.example.gocoffee.models.AllSanPham;
import com.example.gocoffee.models.Cart;
import com.example.gocoffee.models.MessCart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CartFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CartFragment extends Fragment {
    private List<Cart> cartList = new ArrayList<>();
    private RecyclerView recyclerView;
    private List<MessCart> carts;
    public CartFragment() {
        // Required empty public constructor
    }


    public static CartFragment newInstance(String param1, String param2) {
        CartFragment fragment = new CartFragment();
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
        return inflater.inflate(R.layout.fragment_cart, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        LinearLayoutManager layoutManager =new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
//        recyclerView.setLayoutManager(layoutManager);
//        callAPIProducts();
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("share", Context.MODE_PRIVATE);
        String idUser = sharedPreferences.getString("idUser","");
//        callMessCart(idUser);
    }
    private void callAPIProducts(){
        ApiService.apiService.getListSanPham().enqueue(new Callback<AllSanPham>() {
            @Override
            public void onResponse(Call<AllSanPham> call, Response<AllSanPham> response) {
//                allSanPham = response.body();
//                mCategoryList = Arrays.asList(response.body().getListCategory());
//                mArrayList = Arrays.asList(response.body().getListProduct());
//
//                category_adapter = new Home_category_adapter_recyclerview(getActivity());
//                category_adapter.setData(mCategoryList);
//                mRecyclerView.setAdapter(category_adapter);
//
//                mAdapter = new Home_adapter_recyclerview(getActivity());
//                mAdapter.setData(mArrayList);
//                mRecyclerView.setAdapter(mAdapter);

            }

            @Override
            public void onFailure(Call<AllSanPham> call, Throwable t) {
                Toast.makeText(getActivity(), "Lỗi call api", Toast.LENGTH_SHORT).show();

            }
        });
    }
    private void callMessCart(String idUser){
        ApiService.apiService.getCart(idUser).enqueue(new Callback<AllMessCart>() {
            @Override
            public void onResponse(Call<AllMessCart> call, Response<AllMessCart> response) {
                Toast.makeText(getActivity(),response.body().getMsg(),Toast.LENGTH_SHORT).show();
                carts = Arrays.asList(response.body().getListCart());
            }

            @Override
            public void onFailure(Call<AllMessCart> call, Throwable t) {

            }
        });
    }

}