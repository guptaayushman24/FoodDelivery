package com.mastercoding.fooddelivery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivityMenu extends AppCompatActivity {
TextView textView1,textView2,textView3,textView4,textView5,textView6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        textView1 = findViewById(R.id.north);
        textView2 = findViewById(R.id.south);
        textView3 = findViewById(R.id.chinese);
        textView4 = findViewById(R.id.mexican);
        textView5 = findViewById(R.id.italian);
        textView6 = findViewById(R.id.arabic);

        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityMenu.this,MainActivitynorth.class);
                startActivity(intent);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityMenu.this,MainActivitysouth.class);
                startActivity(intent);
            }
        });

        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivityMenu.this,MainActivityChinese.class);
                startActivity(intent);
            }
        });

       textView4.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               Intent intent = new Intent(MainActivityMenu.this,MainActivityMexican.class);
               startActivity(intent);
           }
       });


       textView5.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(MainActivityMenu.this,MainActivityItalian.class);
               startActivity(intent);
           }
       });

       textView6.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(MainActivityMenu.this,MainActivityArabic.class);
               startActivity(intent);
           }
       });


    }
}