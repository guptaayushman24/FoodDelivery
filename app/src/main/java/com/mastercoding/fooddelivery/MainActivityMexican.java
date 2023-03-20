package com.mastercoding.fooddelivery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivityMexican extends AppCompatActivity {
    ArrayList<MexicanModel> MexicanModelArrayList = new ArrayList<MexicanModel>();






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_mexican);

        RecyclerView MexicanRV= findViewById(R.id.idRVMexican);

        // Here, we have created new array list and added data to it
        MexicanModelArrayList.add(new MexicanModel("Veg Fajita", R.drawable.vegfaijita, "100","0"));
        MexicanModelArrayList.add(new MexicanModel("Mexican Vegitable Soup", R.drawable.mexicanvegetablesoup,"80","0"));
        MexicanModelArrayList.add(new MexicanModel("Mexican Veg Burger", R.drawable.mexicanvegburger,"90","0"));
        MexicanModelArrayList.add(new MexicanModel("Mexican Pasta", R.drawable.mexicanpizza,"90","0"));
        MexicanModelArrayList.add(new MexicanModel("Mexican Rolls", R.drawable.mexicanrolls,"100","0"));
        MexicanModelArrayList.add(new MexicanModel("Mexican Wraps", R.drawable.mexicanwraps,"70","0"));
       MexicanModelArrayList.add(new MexicanModel("Mexican Pizza", R.drawable.mexicanpizza,"75","0"));
        MexicanModelArrayList.add(new MexicanModel("Shawarmaroll", R.drawable.shawarmaroll,"120","0"));




        // we are initializing our adapter class and passing our arraylist to it.
        MexicanAdapter mexicanadapter = new MexicanAdapter(this,MexicanModelArrayList);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);



        // in below two lines we are setting layoutmanager and adapter to our recycler view.
        MexicanRV.setLayoutManager(linearLayoutManager);
        MexicanRV.setAdapter(mexicanadapter);

        MexicanRV.setItemViewCacheSize(12);


    }
}