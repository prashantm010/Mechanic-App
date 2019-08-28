package com.example.prashantmaheshwari.firstapp;

/**
 * Created by prashant maheshwari on 29-01-2018.
 */

public class Details {
    String id;
    String mobile,address,car,type,time,date;

    public Details(String id, String mobile, String address, String car, String type, String time, String date) {
        this.id = id;
        this.mobile = mobile;
        this.address = address;
        this.car = car;
        this.type = type;
        this.time = time;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
