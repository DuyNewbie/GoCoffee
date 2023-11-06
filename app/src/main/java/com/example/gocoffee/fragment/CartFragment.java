package com.example.gocoffee.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gocoffee.R;
import com.example.gocoffee.adapters.AdapterCart;
import com.example.gocoffee.api.ApiService;
import com.example.gocoffee.models.AllMessCart;
import com.example.gocoffee.models.Cart;
import com.example.gocoffee.models.MessBill;
import com.example.gocoffee.models.MessCart;
import com.example.gocoffee.models.Product;
import com.example.gocoffee.models.SanPham;

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
    private List<SanPham> mArrayList = new ArrayList<>();
    private RecyclerView recyclerView;
    private List<MessCart> carts= new ArrayList<>();
    private List<Product> products = new ArrayList<>();
    private AdapterCart adapterCart;
    private Button btnDatHang;
    private TextView tvTongTien;
    private int TongTien;
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
        btnDatHang = view.findViewById(R.id.btn_DatHang);
        recyclerView = view.findViewById(R.id.cart_RecyclerView);
        tvTongTien = view.findViewById(R.id.tvTongtien);


        LinearLayoutManager layoutManager =new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        DividerItemDecoration itemDecoration = new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("share", Context.MODE_PRIVATE);
        String idUser = sharedPreferences.getString("idUser","");

        callMessCart(idUser);
        btnDatHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String listidCart = "";
                for (MessCart cart : carts ){
                    listidCart += cart.get_id();
                    listidCart += "-";
                }
                if(carts.isEmpty()){
                    Toast.makeText(getContext(), "Không có sản phẩm", Toast.LENGTH_SHORT).show();
                }
                else {
                    postBill(idUser,listidCart,TongTien);
                }
            }
        });





//        for (MessCart cart : carts){
//            for (SanPham sanPham : mArrayList){
//                if (cart.getId_product().equals(sanPham.get_id())){
////                    cartList.add(new Cart(sanPham.getName(),sanPham.getPrice(),sanPham.getImage(),cart.getQuantity()));
//                    Cart cartList = new Cart(sanPham.getName(), sanPham.getPrice(), sanPham.getImage(),cart.getQuantity());
//                    AdapterCart adapterCart = new AdapterCart(cartList);
//                    recyclerView.setAdapter(adapterCart);
//                }
//            }
//
//        }
//        cartList.add(new Cart("name","1000","tttttt",3));
//        Cart cartList = new Cart("name", "name", "name",9);
//
//        AdapterCart adapterCart1 = new AdapterCart(Collections.singletonList(cartList));
//                    recyclerView.setAdapter(adapterCart1);

    }
    private void callMessCart(String idUser){
        ApiService.apiService.getCart(idUser).enqueue(new Callback<AllMessCart>() {
            @Override
            public void onResponse(Call<AllMessCart> call, Response<AllMessCart> response) {
                carts = Arrays.asList(response.body().getListCart());
//                for (MessCart cart :carts){
//                    products.add(cart.getId_product());
//                }

                adapterCart = new AdapterCart(getActivity());
                adapterCart.setData(carts);
                recyclerView.setAdapter(adapterCart);
                for(MessCart cart : carts){
                    int gia = cart.getId_product().getPrice();
                    int soluong = cart.getQuantityproduct();
                    int giaSP = gia * soluong;
                    TongTien += giaSP;
                }
                tvTongTien.setText(TongTien + "VND");

            }

            @Override
            public void onFailure(Call<AllMessCart> call, Throwable t) {

            }
        });
    }
    private void postBill(String idUser , String listCart , int TongTien){
        ApiService.apiService.postBill(idUser,listCart,TongTien).enqueue(new Callback<MessBill>() {
            @Override
            public void onResponse(Call<MessBill> call, Response<MessBill> response) {
                Toast.makeText(getContext(), "Thành công", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<MessBill> call, Throwable t) {
                Toast.makeText(getContext(), "Không thành công", Toast.LENGTH_SHORT).show();
            }
        });
    }



}