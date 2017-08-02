package com.example.parkingdemo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by menginar on 02.08.2017.
 */

public class CarParkInfo {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("carparkingcode")
    @Expose
    private String carparkingcode;
    @SerializedName("explanition")
    @Expose
    private String explanition;
    @SerializedName("wage")
    @Expose
    private String wage;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCarparkingcode() {
        return carparkingcode;
    }

    public void setCarparkingcode(String carparkingcode) {
        this.carparkingcode = carparkingcode;
    }

    public String getExplanition() {
        return explanition;
    }

    public void setExplanition(String explanition) {
        this.explanition = explanition;
    }

    public String getWage() {
        return wage;
    }

    public void setWage(String wage) {
        this.wage = wage;
    }

}
