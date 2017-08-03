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

import java.util.ArrayList;

import static com.example.parkingdemo.ui.activity.MainActivity.forceCrash;

/**
 * Created by ss on 1.8.2017.
 */

public class FragmentMapList extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList<String> arrayList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_map_list, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        arrayList = new ArrayList<>();

        arrayList.add(0, "Deneme 0");
        arrayList.add(1, "Deneme 1");
        arrayList.add(2, "Deneme 2");
        arrayList.add(3, "Deneme 3");

        mAdapter = new RecyclerAdapter(arrayList);
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }
}
