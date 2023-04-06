package com.mastercoding.fooddelivery;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.ColorSpace;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.mastercoding.fooddelivery.NorthModel;


import java.util.ArrayList;
import java.util.List;

public class NorthAdapter extends RecyclerView.Adapter<NorthAdapter.ViewHolder> {

    private DBhelper dbHelper;
    Context context;
    ArrayList<NorthModel> NorthModelArrayList;


    public NorthAdapter(Context context, ArrayList<NorthModel> NorthModelArrayList) {
        this.context = context;
        this.NorthModelArrayList = NorthModelArrayList;

        dbHelper = new DBhelper(context);


    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // to inflate the layout for each item of recycler view.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_north_layout, parent, false);
        View v2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main_activitynorth, parent, false);
        return new ViewHolder(view, v2);


    }


    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        NorthModel model = NorthModelArrayList.get(position);
        holder.moneyn.setText(model.getMoneyn());
        holder.menun.setText(model.getMenun());
        holder.imagen.setImageResource(model.getImagen());
        holder.tpricen.setText(model.getTpricen());


        holder.buttonaddtocartn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text3 = holder.menun.getText().toString();
                String text4 = holder.tpricen.getText().toString();

                if (!text3.isEmpty() && !text4.isEmpty()) {
                    SQLiteDatabase database = dbHelper.getWritableDatabase();

                    ContentValues values = new ContentValues();

                    values.put(dbHelper.KEY_NAME, text3);
                    values.put(dbHelper.KEY_PRICE, text4);

                    long newRowId = database.insert("cart", null, values);
                    if (newRowId == -1) {
                        Toast.makeText(view.getContext(), "Error inserting into the database", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(view.getContext(), "Item is Successfully added into the cart", Toast.LENGTH_SHORT).show();
                    }

                }


            }
        });


    }


    @Override
    public int getItemCount() {
        // this method is used for showing number of card items in recycler view
        return NorthModelArrayList.size();
    }

    // View holder class for initializing of your views such as TextView and Imageview
    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imagen;
        ImageView addtocart;
        TextView menun;
        TextView moneyn;
        Button incen;
        Button decren;
        TextView tpricen;
        TextView qunatityn;
        Button cartn;
        Button buttonaddtocartn;
        int counter = 0;
        int result = 0;


        public ViewHolder(@NonNull View itemView, View v2) {
            super(itemView);


            imagen = itemView.findViewById(R.id.northlunch);
            addtocart = itemView.findViewById(R.id.addtocart);
            menun = itemView.findViewById(R.id.lunch);
            moneyn = itemView.findViewById(R.id.moneyn);
            incen = itemView.findViewById(R.id.plusn);
            decren = itemView.findViewById(R.id.minusn);
            qunatityn = itemView.findViewById(R.id.textViewn);
            tpricen = itemView.findViewById(R.id.tpricen);
            buttonaddtocartn = itemView.findViewById(R.id.addtocartn);


            dbHelper = new DBhelper(itemView.getContext());

            incen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    counter = Integer.parseInt(qunatityn.getText().toString());

                    counter = counter + 1;
                    qunatityn.setText(String.valueOf(counter));


                    String a = qunatityn.getText().toString();
                    String b = moneyn.getText().toString();

                    int x = Integer.parseInt(a);
                    int y = Integer.parseInt(b);

                    result = x * y;
                    tpricen.setText(result + "");
                }
            });

            decren.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    counter = Integer.parseInt(qunatityn.getText().toString());
                    if (counter == 0) {
                        counter = 0;
                    } else {
                        counter = counter - 1;
                    }
                    qunatityn.setText(counter + "");

                    String a = qunatityn.getText().toString();
                    String b = moneyn.getText().toString();

                    int x = Integer.parseInt(a);
                    int y = Integer.parseInt(b);

                    result = x * y;
                    tpricen.setText(result + "");
                }
            });


        }


    }


}

