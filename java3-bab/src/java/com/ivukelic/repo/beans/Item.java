package com.ivukelic.repo.beans;

public class Item {
    
    private String imgSrc;
    private String iconSrc;
    private String name;
    private Double price;

    public Item(String imgSrc, String iconSrc, String name, Double price) {
        this.imgSrc = imgSrc;
        this.iconSrc = iconSrc;
        this.name = name;
        this.price = price;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getIconSrc() {
        return iconSrc;
    }

    public void setIconSrc(String iconSrc) {
        this.iconSrc = iconSrc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    
    
    
}



