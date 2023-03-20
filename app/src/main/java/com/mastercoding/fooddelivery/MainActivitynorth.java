package com.mastercoding.fooddelivery;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
public class MainActivitynorth extends AppCompatActivity {



    ArrayList<NorthModel> northModelArrayList=new ArrayList<NorthModel>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activitynorth);
       RecyclerView NorthRV = findViewById(R.id.idRVNorth);


        // Here, we have created new array list and added data to it

        northModelArrayList.add(new NorthModel( "0","Lunch", "100",R.drawable.northindian,R.drawable.addtocart,"0"));
        northModelArrayList.add(new NorthModel( "0","Alooparatha", "80",R.drawable.alooparatha,R.drawable.addtocart,"0"));
        northModelArrayList.add(new NorthModel( "0","Gobiparatha", "90",R.drawable.gobiparatha,R.drawable.addtocart,"0"));
        northModelArrayList.add(new NorthModel( "0","Pannerparatha", "90",R.drawable.pannerparatha,R.drawable.addtocart,"0"));
        northModelArrayList.add(new NorthModel( "0","Mixparatha", "100",R.drawable.mixparatha,R.drawable.addtocart,"0"));
        northModelArrayList.add(new NorthModel( "0","Pannerbuttermasala", "70",R.drawable.pannerbuttermasala,R.drawable.addtocart,"0"));
        northModelArrayList.add(new NorthModel( "0","Creampanner", "75",R.drawable.creampanner,R.drawable.addtocart,"0"));
       northModelArrayList.add(new NorthModel( "0","Kajukari", "120",R.drawable.kajukari,R.drawable.addtocart,"0"));
        northModelArrayList.add(new NorthModel( "0","Dalfry", "70",R.drawable.dalfry,R.drawable.addtocart,"0"));
        northModelArrayList.add(new NorthModel( "0","Roti", "10",R.drawable.roti,R.drawable.addtocart,"0"));
        northModelArrayList.add(new NorthModel("0", "Paratha", "12",R.drawable.paratha,R.drawable.addtocart,"0"));




        // we are initializing our adapter class and passing our arraylist to it.
        NorthAdapter northadapter = new NorthAdapter(getApplicationContext(), northModelArrayList);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);


        // in below two lines we are setting layoutmanager and adapter to our recycler view.
        NorthRV.setLayoutManager(linearLayoutManager);
        NorthRV.setAdapter(northadapter);



        NorthRV.setItemViewCacheSize(12);







       }
}


