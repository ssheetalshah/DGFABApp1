package com.ics.dgfabapp.model;

public class MyListData {

    private String description;
    private int imgId;
    String address;
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



    public MyListData(String description, int imgId ,String address) {
        this.description = description;
        this.imgId = imgId;
        this.address =address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }
}
