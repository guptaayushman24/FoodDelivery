package com.mastercoding.fooddelivery;

import android.widget.Button;

import androidx.cardview.widget.CardView;

public class SouthModel {
    public int id;
    public String name;
    public String price;
    private String menus;
    private int images;
    private String moneys;
    private String tprice;



    // Constructor

    public SouthModel(String menus,int images , String moneys,String tprice) {
        this.images = images;
        this.menus = menus;
        this.moneys = moneys;
        this.tprice = tprice;

    }

    public SouthModel() {
        
    }


    // Getter and Setter


    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }

    public String getMenus() {
        return menus;
    }

    public void setMenus(String menus) {
        this.menus = menus;
    }

    public String getMoneys() {
        return moneys;
    }

    public void setMoneys(String moneys) {
        this.moneys = moneys;
    }

    public String getTprice() {
        return tprice;
    }

    public void setTprice(String tprice) {
        this.tprice = tprice;
    }
}





