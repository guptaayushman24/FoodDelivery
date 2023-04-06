package com.mastercoding.fooddelivery;

import static com.mastercoding.fooddelivery.DBhelper.DATABASE_NAME;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
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


public class SouthAdapter extends RecyclerView.Adapter<SouthAdapter.ViewHolder> {
    private DBhelper dbHelper;
    Context context;
    private ArrayList<SouthModel> SouthModelArrayList;

    // Constructor

    public SouthAdapter(Context context, ArrayList<SouthModel> southModelArrayList) {
        this.context = context;
        SouthModelArrayList = southModelArrayList;
        dbHelper = new DBhelper(context);


    }


    @NonNull
    @Override
    public SouthAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_south_layout, parent, false);
        return new SouthAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SouthAdapter.ViewHolder holder, int position) {
        SouthModel model = SouthModelArrayList.get(position);
        holder.moneys.setText(model.getMoneys());
        holder.menus.setText(model.getMenus());
        holder.tprice.setText(model.getTprice());
        holder.images.setImageResource(model.getImages());

        holder.buttonaddtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("TAG", "Button clicked!"); // Add this line
                String text1 = holder.menus.getText().toString();
                String text2 = holder.tprice.getText().toString();
                Log.d("TAG", "Text1" + text1);
                Log.d("TAG", "Text2" + text2);

                if (!text1.isEmpty() && !text2.isEmpty()) {
                    SQLiteDatabase database = dbHelper.getWritableDatabase();

                    ContentValues values = new ContentValues();
                    values.put(dbHelper.KEY_NAME, text1);
                    values.put(dbHelper.KEY_PRICE, text2);


                    long newRowId = database.insert("cart", null, values);

                    if (newRowId == -1) {
                        Toast.makeText(view.getContext(), "Error inserting into database", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(view.getContext(), "Item is Successfully added into the cart", Toast.LENGTH_SHORT).show();

                    }

                }

            }
        });


    }


    @Override
    public int getItemCount() {
        return SouthModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView images;
        TextView menus;
        TextView moneys;

        Button button3;
        TextView textview3;
        TextView tprice;
        Button button4;
        Button buttons;
        Button buttonaddtocart;
        int counter = 0;
        int result = 0;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            images = itemView.findViewById(R.id.plaindosa);
            menus = itemView.findViewById(R.id.plaindosas);
            moneys = itemView.findViewById(R.id.moneys);
            button3 = itemView.findViewById(R.id.pluss);
            textview3 = itemView.findViewById(R.id.textViews);
            tprice = itemView.findViewById(R.id.tprice);
            button4 = itemView.findViewById(R.id.minuss);
            buttonaddtocart = itemView.findViewById(R.id.addtocart);

            dbHelper = new DBhelper(itemView.getContext());


            button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    counter = Integer.parseInt(textview3.getText().toString());
                    counter = counter + 1;
                    Log.d("DEBUG", "increment button clicked, value: " + counter);
                    textview3.setText(String.valueOf(counter));
                    String a = textview3.getText().toString();
                    String b = moneys.getText().toString().replaceAll("[^\\d.]", "");

                    int x = Integer.parseInt(a);
                    int y = Integer.parseInt(b);

                    result = x * y;
                    tprice.setText(result + "");


                }
            });
            button4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    counter = Integer.parseInt(textview3.getText().toString());
                    if (counter == 0) {
                        counter = 0;
                    } else {
                        counter = counter - 1;
                    }
                    textview3.setText(counter + "");
                    String a = textview3.getText().toString();
                    String b = moneys.getText().toString().replaceAll("[^\\d.]", "");

                    int x = Integer.parseInt(a);
                    int y = Integer.parseInt(b);

                    result = x * y;
                    tprice.setText(result + "");
                }
            });


        }
    }
}
