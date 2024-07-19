package com.example.marketapp;

public class item {
    private int item_Image;
    private String item_title;
    private String item_description;

    public item(int item_Image, String item_title, String item_description) {
        this.item_Image = item_Image;
        this.item_title = item_title;
        this.item_description = item_description;
    }

    public int getItem_Image() {
        return item_Image;
    }

    public void setItem_Image(int item_Image) {
        this.item_Image = item_Image;
    }

    public String getItem_title() {
        return item_title;
    }

    public void setItem_title(String item_title) {
        this.item_title = item_title;
    }

    public String getItem_description() {
        return item_description;
    }

    public void setItem_description(String item_description) {
        this.item_description = item_description;
    }
}
