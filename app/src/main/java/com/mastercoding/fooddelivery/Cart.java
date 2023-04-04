package com.mastercoding.fooddelivery;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Cart extends AppCompatActivity {

    Button button;

    DBhelper db;
    ArrayList<CartModel> cartList;
    CartAdapter adapter;
    CartAdapter adapter1;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_cart);
        db = new DBhelper(this);
        cartList = new ArrayList<>();
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        button = findViewById(R.id.totalbutton);
        recyclerView.setHasFixedSize(true);

        viewData();

        adapter1 = new CartAdapter(cartList);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int totalPrice = adapter1.sumprice();
                Toast.makeText(Cart.this, "Your total price is " + totalPrice, Toast.LENGTH_SHORT).show();
                db.deleteAlldata();
                cartList.clear();

            }
        });

    }

    public void viewData() {
        Cursor cursor = db.viewData();
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "No items are added to the cart", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                cartList.add(new CartModel(cursor.getString(1), cursor.getString(2)));
            }
            adapter = new CartAdapter(cartList);
            recyclerView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }
    }

}
