package com.mastercoding.fooddelivery;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ArabicAdapter extends RecyclerView.Adapter<ArabicAdapter.ViewHolder> {

    private static DBhelper dbHelper;
     Context context;
     ArrayList<ArabicModel> ArabicModelArrayList;

    public ArabicAdapter(Context context, ArrayList<ArabicModel> arabicModelArrayList) {
        this.context = context;
        ArabicModelArrayList = arabicModelArrayList;

        dbHelper = new DBhelper(context);


    }

    @NonNull
    @Override
    public ArabicAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_arabic_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArabicAdapter.ViewHolder holder, int position) {

        ArabicModel model = ArabicModelArrayList.get(position);
        holder.moneya.setText(model.getMoneya());
        holder.menua.setText(model.getMenua());
        holder.imagea.setImageResource(model.getImagea());
        holder.tpricea.setText(model.getTpricea());


        holder.addtocartm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text11 = holder.menua.getText().toString();
                String text12 = holder.tpricea.getText().toString();

                if (!text11.isEmpty() && !text12.isEmpty()){
                    SQLiteDatabase database = dbHelper.getWritableDatabase();

                    ContentValues values = new ContentValues();

                    values.put(dbHelper.KEY_NAME,text11);
                    values.put(dbHelper.KEY_PRICE,text12);

                    long newRowId = database.insert("cart",null,values);
                    if (newRowId==-1){
                        Toast.makeText(view.getContext(), "Error inserting into the database", Toast.LENGTH_SHORT).show();

                    }
                    else{
                        Toast.makeText(view.getContext(), "Item is Successfully added into the cart", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return ArabicModelArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imagea;
        TextView menua;
        TextView moneya;

        Button button11;
        TextView textview11;
        TextView quantitya;
        TextView tpricea;
        Button button12;
        Button carta;
        Button addtocartm;
        int counter = 0;
        int result = 0;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imagea = itemView.findViewById(R.id.falafel);
            menua = itemView.findViewById(R.id.falafela);
            moneya = itemView.findViewById(R.id.moneya);
            button11 = itemView.findViewById(R.id.plusa);
            textview11 = itemView.findViewById(R.id.textViewa);
            quantitya = itemView.findViewById(R.id.textViewa);
            tpricea = itemView.findViewById(R.id.tpricea);
            button12 = itemView.findViewById(R.id.minusa);
            carta = itemView.findViewById(R.id.carta);
            addtocartm = itemView.findViewById(R.id.addtocarta);


            dbHelper = new DBhelper(itemView.getContext());


            button11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    counter = Integer.parseInt(textview11.getText().toString());

                    counter = counter+1;
                    textview11.setText(String.valueOf(counter));


                    String a = textview11.getText().toString();
                    String b = moneya.getText().toString();

                    int x = Integer.parseInt(a);
                    int y = Integer.parseInt(b);

                    result = x*y;

                }
            });

            button12.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    counter = Integer.parseInt(textview11.getText().toString());
                    if (counter==0){
                        counter=0;
                    }
                    else{
                        counter = counter-1;
                    }
                    textview11.setText(counter+"");

                    String a = textview11.getText().toString();
                    String b = moneya.getText().toString();

                    int x = Integer.parseInt(a);
                    int y = Integer.parseInt(b);

                    result = x*y;
                }
            });


            carta.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    tpricea.setText(result+"");
                }
            });

        }
    }
}
