package com.mastercoding.fooddelivery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivitysouth extends AppCompatActivity {




    ArrayList<SouthModel> southModelArrayList = new ArrayList<SouthModel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activitysouth);


        RecyclerView SouthRV= findViewById(R.id.idRVSouth);

        // Here, we have created new array list and added data to it
        southModelArrayList.add(new SouthModel("Plain Dosa", R.drawable.plaindosa, "80","0"));
        southModelArrayList.add(new SouthModel("Masala Dosa", R.drawable.masaladosa,"90","0"));
        southModelArrayList.add(new SouthModel("Uttapam", R.drawable.uttapam,"85","0"));
        southModelArrayList.add(new SouthModel("Vada", R.drawable.vada,"70","0"));
        southModelArrayList.add(new SouthModel("Idli", R.drawable.idli,"90","0"));
        southModelArrayList.add(new SouthModel("Curd Rice", R.drawable.curdrice,"50","0"));
        southModelArrayList.add(new SouthModel("Biryani", R.drawable.vegbiryani,"65","0"));
        southModelArrayList.add(new SouthModel("Pongal", R.drawable.pongal,"70","0"));




        // we are initializing our adapter class and passing our arraylist to it.
        SouthAdapter southadapter = new SouthAdapter(this,southModelArrayList);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);



        // in below two lines we are setting layoutmanager and adapter to our recycler view.
        SouthRV.setLayoutManager(linearLayoutManager);
        SouthRV.setAdapter(southadapter);

        SouthRV.setItemViewCacheSize(12);



    }
}