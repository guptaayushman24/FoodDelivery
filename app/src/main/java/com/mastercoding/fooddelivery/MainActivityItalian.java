package com.mastercoding.fooddelivery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivityItalian extends AppCompatActivity {
    ArrayList<ItalianModel> italianModelArrayList = new ArrayList<ItalianModel>();





    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_italian);

        RecyclerView ItalianRV= findViewById(R.id.idRVItalian);

        // Here, we have created new array list and added data to it

        italianModelArrayList.add(new ItalianModel("Pizza", "120", R.drawable.pizza,"0"));
        italianModelArrayList.add(new ItalianModel("Veg Loaded", "150",R.drawable.vegloaded,"0"));
        italianModelArrayList.add(new ItalianModel("Italian Sandwich", "100",R.drawable.italiansandwich,"0"));
        italianModelArrayList.add(new ItalianModel("Italian Veg Rolls", "80",R.drawable.italinrolls,"0"));
        italianModelArrayList.add(new ItalianModel("Italian Salad", "65",R.drawable.italiansalad,"0"));
        italianModelArrayList.add(new ItalianModel("Italian Coffee", "25",R.drawable.italiancoffe,"0"));
        italianModelArrayList.add(new ItalianModel("Italian Wraps","80",R.drawable.italianwraps,"0"));
        italianModelArrayList.add(new ItalianModel("Italian Galeto", "90",R.drawable.italiangaleto,"0"));



        // we are initializing our adapter class and passing our arraylist to it.
        ItalianAdapter italianadapter = new ItalianAdapter(this, italianModelArrayList);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);



        // in below two lines we are setting layoutmanager and adapter to our recycler view.
        ItalianRV.setLayoutManager(linearLayoutManager);
        ItalianRV.setAdapter(italianadapter);

        ItalianRV.setItemViewCacheSize(12);



    }
}