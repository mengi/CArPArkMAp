package com.example.parkingdemo.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by menginar on 02.08.2017.
 */

public class CarParkClient {

    public static String BASE_URL = "http://192.168.1.187/gpscarpark/";

    public static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static CarParkService getCarParkService() {
        return getRetrofitInstance().create(CarParkService.class);
    }
}
