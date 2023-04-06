package com.mastercoding.fooddelivery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivityMenu extends AppCompatActivity {

    CardView cardnorth;
    CardView cardsouth;
    CardView cardchinese;
    CardView cardmexican;

    CardView carditalian;
    CardView cardarabic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);


        cardnorth = findViewById(R.id.northcard);
        cardsouth = findViewById(R.id.southcard);
        cardchinese = findViewById(R.id.chinesecard);
        cardmexican = findViewById(R.id.mexicancard);
        carditalian = findViewById(R.id.italiancard);
        cardarabic = findViewById(R.id.arabiccard);


        cardnorth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivityMenu.this, MainActivitynorth.class);
                startActivity(intent);
            }
        });
        cardsouth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivityMenu.this, MainActivitysouth.class);
                startActivity(intent);
            }
        });

        cardchinese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivityMenu.this, MainActivityChinese.class);
                startActivity(intent);
            }
        });

        cardmexican.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivityMenu.this, MainActivityMexican.class);
                startActivity(intent);
            }
        });


        carditalian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityMenu.this, MainActivityItalian.class);
                startActivity(intent);
            }
        });

        cardarabic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivityMenu.this, MainActivityArabic.class);
                startActivity(intent);
            }
        });


    }
}