package com.example.prashantmaheshwari.firstapp;

/**
 * Created by prashant maheshwari on 26-01-2018.
 */

public class Car {
    private String id;
    private String Carmodel;
    private String Fuel;
    private String RegistrationNo;

    public Car() {
    }

    public Car(String id, String carmodel, String fuel, String registrationNo) {
        this.id = id;
        Carmodel = carmodel;
        Fuel = fuel;
        RegistrationNo = registrationNo;
    }

    public String getId() {
        return id;
    }

    public String getCarmodel() {
        return Carmodel;
    }

    public String getFuel() {
        return Fuel;
    }

    public String getRegistrationNo() {
        return RegistrationNo;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCarmodel(String carmodel) {
        Carmodel = carmodel;
    }

    public void setFuel(String fuel) {
        Fuel = fuel;
    }

    public void setRegistrationNo(String registrationNo) {
        RegistrationNo = registrationNo;
    }
}
