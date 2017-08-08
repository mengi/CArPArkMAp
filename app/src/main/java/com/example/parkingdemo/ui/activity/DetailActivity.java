package com.example.parkingdemo.ui.activity;

import android.media.Image;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.parkingdemo.R;
import com.example.parkingdemo.model.CarPark;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.squareup.picasso.Picasso;

import static com.example.parkingdemo.ui.activity.SplashActivity.carParkList;

/**
 * Created by ss on 2.8.2017.
 */

public class DetailActivity extends AppCompatActivity implements OnMapReadyCallback {

    boolean showFAB = true;
    int carParkPosition;
    GoogleMap gMap;

    ImageView imageViewPath;
    TextView textViewCarParkName, textViewCapacity, textViewWashingState, textViewTime;
    SupportMapFragment mapFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        try {
            init();
            carParkPosition = getIntent().getExtras().getInt("POSITION");
        } catch (Exception e) {
            e.printStackTrace();
        }

        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) findViewById(R.id.map_coordinator);
        View bottomSheet = coordinatorLayout.findViewById(R.id.map_bottom_sheet);

        BottomSheetBehavior behavior = BottomSheetBehavior.from(bottomSheet);

        behavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {

                switch (newState) {

                    case BottomSheetBehavior.STATE_DRAGGING:

                        break;

                    case BottomSheetBehavior.STATE_COLLAPSED:

                        break;

                    case BottomSheetBehavior.STATE_EXPANDED:

                        break;
                }
            }

            @Override
            public void onSlide(View bottomSheet, float slideOffset) {

            }
        });

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        gMap = googleMap;
        CameraUpdate zoom = CameraUpdateFactory.zoomTo(12);

        LatLng latLng = new LatLng(Double.valueOf(carParkList.get(carParkPosition).getLatitude()),
                Double.valueOf(carParkList.get(carParkPosition).getLongitude()));

        gMap.addMarker(new MarkerOptions()
                .position(latLng)
                .title(carParkList.get(carParkPosition).getCarparkingname())
                .icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        gMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));

        gMap.animateCamera(zoom);
    }

    public void init() {
        mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        imageViewPath = (ImageView) findViewById(R.id.imageViewPath);
        textViewCarParkName = (TextView) findViewById(R.id.textViewCarParkName);
        textViewTime = (TextView) findViewById(R.id.textViewTime);
        textViewWashingState = (TextView) findViewById(R.id.textViewWashingState);
        textViewCapacity = (TextView) findViewById(R.id.textViewWashingState);


        Picasso.with(this).load(carParkList.get(carParkPosition).getImagepath()).into(imageViewPath);
        textViewCarParkName.setText(carParkList.get(carParkPosition).getCarparkingname());
        textViewTime.setText(carParkList.get(carParkPosition).getDurationofservice());
        textViewCapacity.setText(carParkList.get(carParkPosition).getCapacity());
        textViewWashingState.setText(carParkList.get(carParkPosition).getWashing());

        mapFragment.getMapAsync(this);
    }

}
