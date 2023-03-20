package com.mastercoding.fooddelivery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivityChinese extends AppCompatActivity {

    ChineseAdapter chineseadapter;


    ArrayList<ChineseModel> chineseModelArrayList = new ArrayList<ChineseModel>();
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_chinese);
        RecyclerView ChineseRV= findViewById(R.id.idRVChinese);

        // Here, we have created new array list and added data to it

        chineseModelArrayList.add(new ChineseModel("Choewmein", R.drawable.choewmein, "80","0"));
        chineseModelArrayList.add(new ChineseModel("Manchurein", R.drawable.manchurein,"90","0"));
        chineseModelArrayList.add(new ChineseModel("Dumpling", R.drawable.dumpling,"85","0"));
        chineseModelArrayList.add(new ChineseModel("Haka Noodle", R.drawable.hakkanoodle,"70","0"));
        chineseModelArrayList.add(new ChineseModel("Hot Pot", R.drawable.hotpot,"90","0"));
        chineseModelArrayList.add(new ChineseModel("Schezwanfriedrice", R.drawable.schezwanfriedrice,"50","0"));
        chineseModelArrayList.add(new ChineseModel("Schezwannodles", R.drawable.schezwannoodles,"65","0"));




        // we are initializing our adapter class and passing our arraylist to it.
        chineseadapter = new ChineseAdapter(this,chineseModelArrayList);



        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);



        // in below two lines we are setting layoutmanager and adapter to our recycler view.
        ChineseRV.setLayoutManager(linearLayoutManager);
        ChineseRV.setAdapter(chineseadapter);
        ChineseRV.setItemViewCacheSize(12);





    }
}