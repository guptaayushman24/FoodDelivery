package com.mastercoding.fooddelivery;

import android.widget.Button;


import androidx.cardview.widget.CardView;
public class MexicanModel {
   private String menum;
   private int imagem;
    private String moneym;
    private String tpricem;




    // Constructor

    public MexicanModel(String menum,int imagem, String moneym,String tpricem) {
        this.menum = menum;
        this.imagem = imagem;
        this.moneym = moneym;
        this.tpricem = tpricem;
          }


    // Getter and Setter


    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public String getMenum() {
        return menum;
    }

    public void setMenum(String menum) {
        this.menum = menum;
    }

    public String getMoneym() {
        return moneym;
    }

    public void setMoneym(String moneym) {
        this.moneym = moneym;
    }

    public String getTpricea() {
        return tpricem;
    }

    public void setTpricea(String tpricea) {
        this.tpricem = tpricem;
    }
}


