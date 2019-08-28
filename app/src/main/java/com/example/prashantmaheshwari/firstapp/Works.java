package com.example.prashantmaheshwari.firstapp;

/**
 * Created by prashant maheshwari on 26-02-2018.
 */

public class Works {
    private String id;
    private int image;
    private String title, Money;

    public Works(String id, String title, String money){
    }

    public Works(int image, String title, String Money) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.Money = Money;
    }

    public String getId() {
        return id;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getMoney() {
        return Money;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setTitle() {
        this.title = title;
    }

    public void setMoney(String money) {
        this.Money = money;
    }

}





