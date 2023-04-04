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

public class MexicanAdapter extends RecyclerView.Adapter<MexicanAdapter.ViewHolder> {

    private DBhelper dBhelper;
    Context context;
     ArrayList<MexicanModel> MexicanModelArrayList;

    public MexicanAdapter(Context context, ArrayList<MexicanModel> MexicanModelArrayList) {
        this.context = context;
        this.MexicanModelArrayList = MexicanModelArrayList;
        dBhelper = new DBhelper(context);

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_mexican_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MexicanModel model = MexicanModelArrayList.get(position);
        holder.moneym.setText(model.getMoneym());
        holder.menum.setText(model.getMenum());
        holder.imagem.setImageResource(model.getImagem());
        holder.tpricem.setText(model.getTpricea());

        holder.addtocartm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text7 = holder.menum.getText().toString();
                String text8 = holder.tpricem.getText().toString();

                if (!text7.isEmpty() && !text8.isEmpty()){
                    SQLiteDatabase database = dBhelper.getWritableDatabase();

                    ContentValues values = new ContentValues();

                    values.put(dBhelper.KEY_NAME,text7);
                    values.put(dBhelper.KEY_PRICE,text8);

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
        return MexicanModelArrayList.size();
    }
public  class ViewHolder extends RecyclerView.ViewHolder{
    ImageView imagem;
    TextView menum ;
    TextView moneym;

    Button button7;
    TextView textview7;
    TextView tpricem;
    Button button8;
    Button buttonm;
    Button addtocartm;
    int counter = 0;
    int result=0;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        imagem = itemView.findViewById(R.id.vegfajita);
        menum = itemView.findViewById(R.id.vegfajitam);
        moneym = itemView.findViewById(R.id.moneym);
        button7 = itemView.findViewById(R.id.plusm);
        textview7 = itemView.findViewById(R.id.textViewm);
        tpricem = itemView.findViewById(R.id.tpricem);
        button8 = itemView.findViewById(R.id.minusm);
        buttonm = itemView.findViewById(R.id.cartm);
        addtocartm = itemView.findViewById(R.id.addtocartm);


        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter = Integer.parseInt(textview7.getText().toString());
                counter = counter + 1;
                textview7.setText(String.valueOf(counter));

                String a = textview7.getText().toString();
                String b = moneym.getText().toString();


                int x = Integer.parseInt(a);
                int y = Integer.parseInt(b);


                result = x*y;
            }
        });


        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (counter==0){
                    counter=0;
                }
                else{
                    counter = counter -1;
                }
                 textview7.setText(String.valueOf(counter));

                String a = textview7.getText().toString();
                String b = moneym.getText().toString();

                int x = Integer.parseInt(a);
                int y = Integer.parseInt(b);

                result = x*y;

            }
        });


        buttonm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tpricem.setText(result+"");
            }
        });





    }
}
}