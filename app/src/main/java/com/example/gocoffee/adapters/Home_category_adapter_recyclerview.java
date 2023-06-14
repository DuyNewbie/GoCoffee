package com.example.gocoffee.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gocoffee.R;
import com.example.gocoffee.models.Category;
import com.example.gocoffee.models.SanPham;

import java.util.List;

public class Home_category_adapter_recyclerview extends RecyclerView.Adapter<Home_category_adapter_recyclerview.UserViewHolder>{

    private Context mContext;
    private List<Category> mArrayList;

    public Home_category_adapter_recyclerview(Context mContext) {
        this.mContext = mContext;
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
}
