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
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.mastercoding.fooddelivery.NorthModel;
import java.util.ArrayList;



public class ChineseAdapter extends RecyclerView.Adapter<ChineseAdapter.ViewHolder> {
    private DBhelper dbHelper;
    private Context context;
    private ArrayList<ChineseModel> ChineseModelArrayList;


    public ChineseAdapter(Context context, ArrayList<ChineseModel> chineseModelArrayList) {
        this.context = context;
        this.ChineseModelArrayList = chineseModelArrayList;
        dbHelper = new DBhelper(context);

    }

    @NonNull
    @Override
    public ChineseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_chinese_layout, parent, false);
        return new ChineseAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChineseAdapter.ViewHolder holder, int position) {
        ChineseModel model = ChineseModelArrayList.get(position);
        holder.moneyc.setText(model.getMoneyc());
        holder.menuc.setText(model.getMenuc());
        holder.imagec.setImageResource(model.getImagec());
        holder.tpricec.setText(model.getTpricec());

        holder.addtocartc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text5 = holder.menuc.getText().toString();
                String text6 = holder.tpricec.getText().toString();

                if (!text5.isEmpty() && !text6.isEmpty()){
                    SQLiteDatabase database = dbHelper.getWritableDatabase();

                    ContentValues values = new ContentValues();

                    values.put(dbHelper.KEY_NAME,text5);
                    values.put(dbHelper.KEY_PRICE,text6);

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
        return ChineseModelArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imagec;
        TextView menuc;
        TextView moneyc;
        TextView textviewc;
        Button button5;
        TextView textview5;
        TextView tpricec;
        Button button6;
        Button buttonc;
        Button addtocartc;
        int counter = 0;
        int result = 0;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imagec = itemView.findViewById(R.id.choewmein);
            menuc = itemView.findViewById(R.id.choewmeinc);
            moneyc = itemView.findViewById(R.id.moneyc);
            button5 = itemView.findViewById(R.id.plusc);
            textview5 = itemView.findViewById(R.id.textViewc);
            tpricec = itemView.findViewById(R.id.tpricec);
            button6 = itemView.findViewById(R.id.minusc);
            buttonc = itemView.findViewById(R.id.cartc);
            addtocartc = itemView.findViewById(R.id.addtocartc);


            button5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    counter = Integer.parseInt(textview5.getText().toString());
                    counter = counter + 1;

                    textview5.setText(String.valueOf(counter));

                    String a = textview5.getText().toString();
                    String b = moneyc.getText().toString();

                    int x = Integer.parseInt(a);
                    int y =  Integer.parseInt(b);

                   result = x*y;


                }
            });
            button6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (counter==0){
                        counter=0;
                    }
                    else{
                        counter = counter - 1;

                        textview5.setText(String.valueOf(counter));

                        String a = textview5.getText().toString();
                        String b = moneyc.getText().toString();

                        int x = Integer.parseInt(a);
                        int y =  Integer.parseInt(b);

                        result = x*y;


                    }
                }
            });

            buttonc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    tpricec.setText(result+"");
                }
            });

        }


    }
}

