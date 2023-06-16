package com.example.gocoffee.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.gocoffee.R;
import com.example.gocoffee.models.Cart;
import com.example.gocoffee.models.MessCart;
import com.example.gocoffee.models.Product;
import com.example.gocoffee.models.SanPham;

import java.util.List;

public class AdapterCart extends RecyclerView.Adapter<AdapterCart.ProductViewHolder>{

    private Context context;

    private List<Product> products;
    private List<MessCart> carts;

    public AdapterCart(Context context) {
        this.context = context;
    }

    public AdapterCart() {
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cart, parent, false);

        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        MessCart messCart =  carts.get(position);
        Product product = messCart.getId_product();
        holder.edSoluong.setText(messCart.getQuantityproduct()+"");
        holder.tvPriceCart.setText(product.getPrice()+"");
        holder.tvNameCart.setText(product.getName()+"");
        Glide.with(context).load("https://gocoffe.herokuapp.com" + product.getImage()).error(R.drawable.img_4).into(holder.imgAvataCart);

    }

    @Override
    public int getItemCount() {
        if (products != null) return products.size();
        return 0;
    }

    public void setData(List<MessCart> mArrayList) {
        this.carts = mArrayList;
        notifyDataSetChanged();
    }


    public class ProductViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout btnCong,btnTru;
        private EditText edSoluong;
        private TextView tvNameCart,tvPriceCart;
        private ImageView imgAvataCart;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            btnCong = itemView.findViewById(R.id.btnCongCart);
            btnTru = itemView.findViewById(R.id.btnTruCart);
            edSoluong = itemView.findViewById(R.id.edSoluong);
            tvNameCart = itemView.findViewById(R.id.tvNameCart);
            tvPriceCart = itemView.findViewById(R.id.tvPriceCart);
            imgAvataCart = itemView.findViewById(R.id.imgavataCart);
        }
    }
}
