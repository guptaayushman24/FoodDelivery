package com.mastercoding.fooddelivery;
import android.widget.Button;

import androidx.cardview.widget.CardView;
public class ArabicModel {

    private int imagea;
    private String menua;
    private String moneya;
    private String tpricea;


    // Constructor


    public ArabicModel(String menua,String moneya,int imagea,String tpricea) {

        this.menua = menua;
        this.moneya = moneya;
        this.imagea = imagea;
        this.tpricea = tpricea;

    }


    // Getter and Setter


    public int getImagea() {
        return imagea;
    }

    public void setImagea(int imagea) {
        this.imagea = imagea;
    }

    public String getMenua() {
        return menua;
    }

    public void setMenua(String menua) {
        this.menua = menua;
    }

    public String getMoneya() {
        return moneya;
    }

    public void setMoneya(String moneya) {
        this.moneya = moneya;
    }

    public String getTpricea() {
        return tpricea;
    }

    public void setTpricea(String tpricea) {
        this.tpricea = tpricea;
    }
}
