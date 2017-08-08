package com.example.parkingdemo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by menginar on 02.08.2017.
 */

public class CarPark {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("carparkingname")
    @Expose
    private String carparkingname;
    @SerializedName("capacity")
    @Expose
    private String capacity;
    @SerializedName("carparkingcode")
    @Expose
    private String carparkingcode;
    @SerializedName("washing")
    @Expose
    private String washing;
    @SerializedName("durationofservice")
    @Expose
    private String durationofservice;
    @SerializedName("latitude")
    @Expose
    private String latitude;
    @SerializedName("longitude")
    @Expose
    private String longitude;
    @SerializedName("imagepath")
    @Expose

    private String imagepath;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCarparkingname() {
        return carparkingname;
    }

    public void setCarparkingname(String carparkingname) {
        this.carparkingname = carparkingname;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getCarparkingcode() {
        return carparkingcode;
    }

    public void setCarparkingcode(String carparkingcode) {
        this.carparkingcode = carparkingcode;
    }

    public String getWashing() {
        return washing;
    }

    public void setWashing(String washing) {
        this.washing = washing;
    }

    public String getDurationofservice() {
        return durationofservice;
    }

    public void setDurationofservice(String durationofservice) {
        this.durationofservice = durationofservice;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getImagepath() {
        return imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }

}