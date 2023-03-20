package com.mastercoding.fooddelivery;

import android.widget.Button;


public class NorthModel {
    private int imagen;
    private int addtocart;
    private String menun;
    private String moneyn;
    private String quantity;
    private String tpricen;





    // Constructor

    public NorthModel( String quantity,String menun, String moneyn,int imagen,int addtocart,String tpricen) {


        this.imagen = imagen;
        this.addtocart = addtocart;
        this.menun = menun;
        this.moneyn = moneyn;
        this.quantity = quantity;
        this.tpricen = tpricen;




    }



    // Getter and Setter


    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getMenun() {
        return menun;
    }

    public void setMenun(String menun) {
        this.menun = menun;
    }

    public String getMoneyn() {
        return moneyn;
    }

    public void setMoneyn(String moneyn) {
        this.moneyn = moneyn;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public int getAddtocart() {
        return addtocart;
    }

    public void setAddtocart(int addtocart) {
        this.addtocart = addtocart;
    }

    public String getTpricen() {
        return tpricen;
    }

    public void setTpricen(String tpricen) {
        this.tpricen = tpricen;
    }
}

