package com.ivukelic.repo.beans;

public class Item {
    
    private String imgSrc;
    private String name;
    private Double price;
    private String type;
    private String id;

    public Item(String imgSrc, String name, Double price, String type, String id) {
        this.imgSrc = imgSrc;
        this.name = name;
        this.price = price;
        this.type = type;
        this.id = id;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
}



