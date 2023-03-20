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

public class ItalianAdapter extends RecyclerView.Adapter<ItalianAdapter.ViewHolder> {

    private DBhelper dBhelper;
    Context context;
    ArrayList<ItalianModel> ItalianModelArrayList;

    public  ItalianAdapter(Context context, ArrayList<ItalianModel> italianModelArrayList) {
        this.context = context;
        this.ItalianModelArrayList = italianModelArrayList;

        dBhelper = new DBhelper(context);

    }

    @NonNull
    @Override

    public ItalianAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_italian_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItalianAdapter.ViewHolder holder, int position) {
        ItalianModel model = ItalianModelArrayList.get(position);
        holder.moneyi.setText(model.getMoneyi());
        holder.menui.setText(model.getMenui());
        holder.imagei.setImageResource(model.getImagei());
        holder.tpricei.setText(model.getTpricei());

        holder.addtocarti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text9 = holder.menui.getText().toString();
                String text10 = holder.tpricei.getText().toString();

                if (!text9.isEmpty() && !text10.isEmpty()){
                    SQLiteDatabase database = dBhelper.getWritableDatabase();

                    ContentValues values = new ContentValues();

                    values.put(dBhelper.KEY_NAME,text9);
                    values.put(dBhelper.KEY_PRICE,text10);

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
        return ItalianModelArrayList.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imagei;
        TextView menui;
        TextView moneyi;

        Button button9;
        TextView quantityi;
        TextView tpricei;
        Button button10;
        Button buttoni;
        Button addtocarti;
        int counter = 0;
        int result = 0;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imagei = itemView.findViewById(R.id.italian);
            menui = itemView.findViewById(R.id.pizzai);
            moneyi = itemView.findViewById(R.id.moneyi);
            button9 = itemView.findViewById(R.id.plusi);
            quantityi = itemView.findViewById(R.id.quantityi);
            tpricei = itemView.findViewById(R.id.tpricei);
            button10 = itemView.findViewById(R.id.minusi);
            buttoni = itemView.findViewById(R.id.carti);
            addtocarti = itemView.findViewById(R.id.addtocarti);


            button9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    counter = Integer.parseInt(quantityi.getText().toString());

                    counter = counter+1;
                    quantityi.setText(String.valueOf(counter));


                    String a = quantityi.getText().toString();
                    String b = moneyi.getText().toString();

                    int x = Integer.parseInt(a);
                    int y = Integer.parseInt(b);

                    result = x*y;
                }
            });

            button10.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    counter = Integer.parseInt(quantityi.getText().toString());
                    if (counter==0){
                        counter=0;
                    }
                    else{
                        counter = counter-1;
                    }
                    quantityi.setText(counter+"");

                    String a = quantityi.getText().toString();
                    String b = moneyi.getText().toString();

                    int x = Integer.parseInt(a);
                    int y = Integer.parseInt(b);

                    result = x*y;
                }
            });

            buttoni.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    tpricei.setText(result+"");
                }
            });


        }
    }
}
