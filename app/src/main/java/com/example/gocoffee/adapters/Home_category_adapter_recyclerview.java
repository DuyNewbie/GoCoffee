package com.example.gocoffee.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gocoffee.R;
import com.example.gocoffee.api.ApiService;
import com.example.gocoffee.models.AllSanPham;
import com.example.gocoffee.models.Category;
import com.example.gocoffee.models.SanPham;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Home_category_adapter_recyclerview extends RecyclerView.Adapter<Home_category_adapter_recyclerview.UserViewHolder>{

    private Context mContext;
    private List<Category> mArrayList;
    private List<SanPham> sanPhamList = new ArrayList<>();

    private Home_adapter_recyclerview sanPhamAdapter;

    private RecyclerView sanphamRecyclerView;

    public Home_category_adapter_recyclerview(Context mContext, RecyclerView sanphamRecyclerView) {
        this.mContext = mContext;
        this.sanphamRecyclerView = sanphamRecyclerView;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_category_recyclerview_home,parent,false);
        return new UserViewHolder(view);

    }

    public void setData(List<Category> mArrayList){
        this.mArrayList = mArrayList;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        Category object = mArrayList.get(position);
        if (object == null){
            return;
        }

        holder.name.setText(object.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (object.getName().contains("All")){
                    callAPIProduct();
                }
                else {
                    callAPIProducts(object.get_id());
                }
                Toast.makeText(mContext, "Loading....", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        if (mArrayList != null )return mArrayList.size();
        return 0;
    }



    public class UserViewHolder extends RecyclerView.ViewHolder  {


        TextView name;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.item_gategory_name);

        }
    }

    private void callAPIProducts( String id){

        ApiService.apiService.getProductByCategory(id).enqueue(new Callback<AllSanPham>() {
            @Override
            public void onResponse(Call<AllSanPham> call, Response<AllSanPham> response) {
                sanPhamList = Arrays.asList(response.body().getListProduct());
                sanPhamAdapter = new Home_adapter_recyclerview(mContext);
                sanPhamAdapter.setData(sanPhamList);
                sanphamRecyclerView.setAdapter(sanPhamAdapter);
            }

            @Override
            public void onFailure(Call<AllSanPham> call, Throwable t) {
                Toast.makeText(mContext, "Lỗi call api", Toast.LENGTH_SHORT).show();
            }
        });
//
    }
    private void callAPIProduct(){
        ApiService.apiService.getListSanPham().enqueue(new Callback<AllSanPham>() {
            @Override
            public void onResponse(Call<AllSanPham> call, Response<AllSanPham> response) {
                sanPhamList = Arrays.asList(response.body().getListProduct());
                sanPhamAdapter = new Home_adapter_recyclerview(mContext);
                sanPhamAdapter.setData(sanPhamList);
                sanphamRecyclerView.setAdapter(sanPhamAdapter);
            }

            @Override
            public void onFailure(Call<AllSanPham> call, Throwable t) {
                Toast.makeText(mContext, "Lỗi call api", Toast.LENGTH_SHORT).show();
            }
        });
//
    }


}
