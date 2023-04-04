package com.mastercoding.fooddelivery;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;

import java.util.ArrayList;

public class DBhelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "ADDCART";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_CART = "cart";
    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "name";
    public static final String KEY_PRICE = "price";

    public DBhelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_CART + "(" +
                KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                KEY_NAME + " TEXT, " +
                KEY_PRICE + " TEXT" +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CART);
        onCreate(db);
    }

    public void addItem(String name, String price) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, name);
        values.put(KEY_PRICE, price);
        database.insert(TABLE_CART, null, values);
        database.close();




    }

    public ArrayList<SouthModel> fetchItem() {
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM " + TABLE_CART, null);
        ArrayList<SouthModel> arrItem = new ArrayList<>();
        while (cursor.moveToNext()) {
            SouthModel model = new SouthModel();
            model.id = cursor.getInt(0);
            model.name = cursor.getString(1);
            model.price = cursor.getString(2);
            arrItem.add(model);
        }
        cursor.close();
        database.close();
        return arrItem;
    }




    public Cursor viewData(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "Select * from " + TABLE_CART;
        Cursor cursor = db.rawQuery(query,null);
        return cursor;
    }


    public void deleteAlldata(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CART,null,null);
        db.close();
    }
}
