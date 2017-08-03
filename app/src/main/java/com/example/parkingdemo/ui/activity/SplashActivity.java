package com.example.parkingdemo.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.crashlytics.android.ndk.CrashlyticsNdk;
import com.example.parkingdemo.R;
<<<<<<< HEAD
import com.example.parkingdemo.model.CarPark;
import com.example.parkingdemo.model.CarParkInfo;
import com.example.parkingdemo.service.CarParkClient;
import com.example.parkingdemo.service.CarParkService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
=======
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;
>>>>>>> 4bc29047474c163b72f5b0777c33f3b743550d70

/**
 * Created by menginar on 02.08.2017.
 */

public class SplashActivity extends AppCompatActivity{

    public static List<CarPark> carParkList;

    CarParkService carParkService;

    View view;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics(), new CrashlyticsNdk());
        setContentView(R.layout.activity_splash);

        view = getWindow().getDecorView().getRootView();

        if (!isNetworkAvailable()) {
            Snackbar.make(view, "Not Connected", Snackbar.LENGTH_SHORT).show();
        } else {
            getCarParkAll();
        }
    }

    private void getCarParkAll() {
        carParkList = new ArrayList<>();
        try {
            carParkService = CarParkClient.getCarParkService();
            Call<List<CarPark>> listCall = carParkService.getCarParkAll();
            listCall.enqueue(new Callback<List<CarPark>>() {
                @Override
                public void onResponse(Call<List<CarPark>> call, Response<List<CarPark>> response) {
                    carParkList = response.body();
                    Intent intent = new Intent(getApplication(), MainActivity.class);
                    startActivity(intent);
                    finish();
                }

                @Override
                public void onFailure(Call<List<CarPark>> call, Throwable t) {
                    Snackbar.make(view, "Connection Failed With Server", Snackbar.LENGTH_SHORT).show();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
