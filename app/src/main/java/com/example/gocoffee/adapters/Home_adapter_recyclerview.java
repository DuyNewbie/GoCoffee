package com.example.gocoffee.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.gocoffee.R;
import com.example.gocoffee.Screen.Home.ItemDetail;
import com.example.gocoffee.models.SanPham;

import java.util.List;

public class Home_adapter_recyclerview extends RecyclerView.Adapter<Home_adapter_recyclerview.UserViewHolder> {

    private Context mContext;
    private List<SanPham> mArrayList;


    public Home_adapter_recyclerview(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_recyclerview_home, parent, false);

        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        SanPham object = mArrayList.get(position);
        if (object == null) {
            return;
        }

        Glide.with(mContext).load("https://gocoffe.herokuapp.com" + object.getImage()).error(R.drawable.img_4).into(holder.home_Item_avatar);

        holder.home_Item_name.setText(object.getName());
        holder.home_Item_loai.setText("Loại: " + object.getId_category());
        holder.home_Item_price.setText(object.getPrice() + " VNĐ");
        String detail = object.getDetail();

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ItemDetail.class);
                Bundle bundle = new Bundle();
                bundle.putString("object_idproduct",object.get_id());
                bundle.putString("object_name", object.getName());
                bundle.putString("object_img", object.getImage());
                bundle.putString("object_category", object.getId_category());
                bundle.putString("object_price", object.getPrice());
                bundle.putString("object_detail", detail);
                intent.putExtras(bundle);
                mContext.startActivity(intent);

            }
        });

    }

    public void setData(List<SanPham> mArrayList) {
        this.mArrayList = mArrayList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (mArrayList != null) return mArrayList.size();
        return 0;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {

        private ImageView home_Item_avatar, home_Item_btnAdd;
        private TextView home_Item_name, home_Item_price, home_Item_loai;


        public UserViewHolder(@NonNull View itemView) {
            super(itemView);

            home_Item_avatar = itemView.findViewById(R.id.home_Item_avatar);
            home_Item_btnAdd = itemView.findViewById(R.id.home_Item_btnAdd);
            home_Item_name = itemView.findViewById(R.id.home_Item_name);
            home_Item_price = itemView.findViewById(R.id.home_Item_price);
            home_Item_loai = itemView.findViewById(R.id.home_Item_loai);

        }
    }
}
