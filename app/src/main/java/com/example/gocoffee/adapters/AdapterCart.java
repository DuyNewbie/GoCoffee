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

import com.example.gocoffee.R;
import com.example.gocoffee.models.Cart;

import java.util.List;

public class AdapterCart extends RecyclerView.Adapter<AdapterCart.ProductViewHolder>{
    private Context context;
    private List<Cart> cartList;

    public AdapterCart(List<Cart> cartList) {
        this.context = context;
        this.cartList = cartList;
    }

    public AdapterCart(Cart cartList) {

    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cart,parent,false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Cart cart = cartList.get(position);
        if (cart == null){
            return;
        }
//        Glide.with(context).load("https://gocoffe.herokuapp.com" + cart.getImgavatacart()).error(R.drawable.img_4).into(holder.imgAvataCart);
        holder.tvNameCart.setText(cart.getNameproductcart());
        holder.tvPriceCart.setText(cart.getPriceproductcart());
//        holder.edSoluong.setText(cart.getSoluong());
    }

    @Override
    public int getItemCount() {
        if (cartList != null){
            return cartList.size();
        }
        return 0;
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
