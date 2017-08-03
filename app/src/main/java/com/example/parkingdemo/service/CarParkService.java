package com.example.parkingdemo.service;

import com.example.parkingdemo.model.CarPark;
import com.example.parkingdemo.model.CarParkInfo;
import com.example.parkingdemo.model.Message;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by menginar on 02.08.2017.
 */

public interface CarParkService {

    @GET("getCarParkingInfo.php")
    Call<List<CarPark>> getCarParkAll();

    @FormUrlEncoded
    @POST("getCarParkingDetail.php")
    Call<List<CarParkInfo>> getCarParkInfo(
            @Field("carParkCode") String carParkCode
    );

    @FormUrlEncoded
    @POST("getMessageInsert.php")
    Call<Message> getMessageInsert(

            @Field("fullName") String fullName,
            @Field("email") String email,
            @Field("subjet") String subject,
            @Field("message") String message
    );
}
