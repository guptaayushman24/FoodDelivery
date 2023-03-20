package com.mastercoding.fooddelivery;

public class ModelProduct {
    String name,price,image;

    public ModelProduct() {
    }


    // Constructor


    public ModelProduct(String name, String price, String image) {
        this.name = name;
        this.price = price;
        this.image = image;

    }

    // Getter and Setter


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
