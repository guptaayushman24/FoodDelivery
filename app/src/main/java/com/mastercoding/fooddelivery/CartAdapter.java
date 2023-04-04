package com.mastercoding.fooddelivery;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    private  ArrayList<CartModel> cartList;

    public static class CartViewHolder extends RecyclerView.ViewHolder {
        public TextView productname;
        public TextView productprice;

        public Button button;

        public CartViewHolder(View itemView) {
            super(itemView);
            productname = itemView.findViewById(R.id.productname);
            productprice = itemView.findViewById(R.id.productprice);
            button = itemView.findViewById(R.id.totalbutton);

        }
    }

    public CartAdapter(ArrayList<CartModel> cartList) {
        this.cartList = cartList;
    }

    @Override
    public CartViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_xml, parent, false);
        CartViewHolder viewHolder = new CartViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CartViewHolder holder, int position) {
        CartModel currentItem = cartList.get(position);
        holder.productname.setText(currentItem.getProductname());
        holder.productprice.setText(currentItem.getProductprice());
    }




    @Override
    public int getItemCount() {
        return cartList.size();
    }

    public int sumprice(){
        int  sum = 0;
        for (int i=0;i< getItemCount();i++){
            int price = Integer.parseInt(cartList.get(i).getProductprice());
            sum = sum + price;
        }
        return sum;
    }
}




