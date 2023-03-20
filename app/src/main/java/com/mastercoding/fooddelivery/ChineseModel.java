package com.mastercoding.fooddelivery;

import android.widget.Button;

public class ChineseModel {
   private String menuc;
   private int imagec;
    private String moneyc;
    private String tpricec;



    // Constructor



    public ChineseModel(String menuc, int imagec, String moneyc, String tpricec) {


        this.imagec = imagec;
        this.menuc = menuc;
        this.moneyc = moneyc;
        this.tpricec = tpricec;



    }

    // Getter and Setter


    public int getImagec() {
        return imagec;
    }

    public void setImagec(int imagec) {
        this.imagec = imagec;
    }

    public String getMenuc() {
        return menuc;
    }

    public void setMenuc(String menuc) {
        this.menuc = menuc;
    }

    public String getMoneyc() {
        return moneyc;
    }

    public void setMoneyc(String moneyc) {
        this.moneyc = moneyc;
    }

    public String getTpricec() {
        return tpricec;
    }

    public void setTpricec(String tpricec) {
        this.tpricec = tpricec;
    }
}
