package com.example.parkingdemo.ui.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

import static com.example.parkingdemo.ui.activity.SplashActivity.carParkList;

/**
 * Created by ss on 1.8.2017.
 */

public class FragmentMap extends Fragment implements OnMapReadyCallback {

    View view;
    GoogleMap gMap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_map, container, false);

        init();

        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        gMap = googleMap;
        CameraUpdate zoom = CameraUpdateFactory.zoomTo(12);

        for (CarPark carPark : carParkList) {
            LatLng latLng = new LatLng(Double.valueOf(carPark.getLatitude()), Double.valueOf(carPark.getLongitude()));

            gMap.addMarker(new MarkerOptions()
                    .position(latLng)
                    .title(carPark.getCarparkingname())
                    .icon(BitmapDescriptorFactory
                            .defaultMarker(BitmapDescriptorFactory.HUE_RED)));
            gMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        }
        gMap.animateCamera(zoom);

    }

    private void init() {
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);
    }
}
