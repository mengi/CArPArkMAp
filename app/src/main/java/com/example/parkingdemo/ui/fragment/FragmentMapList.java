package com.example.parkingdemo.ui.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.parkingdemo.R;
import com.example.parkingdemo.util.adapter.RecyclerAdapter;

import static com.example.parkingdemo.ui.activity.SplashActivity.carParkList;


import static com.example.parkingdemo.ui.activity.MainActivity.forceCrash;

/**
 * Created by ss on 1.8.2017.
 */

public class FragmentMapList extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_map_list, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new RecyclerAdapter(carParkList, getContext());
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }

}
