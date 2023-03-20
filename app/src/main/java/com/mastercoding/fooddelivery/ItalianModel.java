package com.mastercoding.fooddelivery;

import android.widget.Button;
import androidx.cardview.widget.CardView;

public class ItalianModel {
   private String menui;
  private String moneyi;
  private int imagei;
  private String tpricei;


    // Constructor


    public ItalianModel(String menui,String moneyi,int imagei,String tpricei) {
        this.menui = menui;
        this.moneyi = moneyi;
        this.imagei = imagei;
        this.tpricei=tpricei;

    }


    // Getter and Settter


    public int getImagei() {
        return imagei;
    }

    public void setImagei(int imagei) {
        this.imagei = imagei;
    }

    public String getMenui() {
        return menui;
    }

    public void setMenui(String menui) {
        this.menui = menui;
    }

    public String getMoneyi() {
        return moneyi;
    }

    public void setMoneyi(String moneyi) {
        this.moneyi = moneyi;
    }

    public String getTpricei() {
        return tpricei;
    }

    public void setTpricei(String tpricei) {
        this.tpricei = tpricei;
    }
}
