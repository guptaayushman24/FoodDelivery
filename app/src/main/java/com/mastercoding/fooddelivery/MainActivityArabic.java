package com.mastercoding.fooddelivery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivityArabic extends AppCompatActivity {
    ArrayList<ArabicModel> arabicModelArrayList = new ArrayList<ArabicModel>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_arabic);


        RecyclerView ArabicRV= findViewById(R.id.idRVArabic);

        // Here, we have created new array list and added data to it
        arabicModelArrayList.add(new ArabicModel("Falafel", "100", R.drawable.falafel,"0"));
        arabicModelArrayList.add(new ArabicModel("Amal Al Din", "80",R.drawable.amalaldin,"0"));
        arabicModelArrayList.add(new ArabicModel("Laban", "90",R.drawable.laban,"0"));
        arabicModelArrayList.add(new ArabicModel("Rice Pudding", "90",R.drawable.ricepudding,"0"));




        // we are initializing our adapter class and passing our arraylist to it.
        ArabicAdapter arabicAdapter = new ArabicAdapter(this, arabicModelArrayList);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);



        // in below two lines we are setting layoutmanager and adapter to our recycler view.
        ArabicRV.setLayoutManager(linearLayoutManager);
        ArabicRV.setAdapter(arabicAdapter);

        ArabicRV.setItemViewCacheSize(12);



    }
}