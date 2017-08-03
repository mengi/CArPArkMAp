package com.example.parkingdemo.ui.activity;

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

import com.example.parkingdemo.R;

/**
 * Created by ss on 2.8.2017.
 */

public class DetailActivity extends AppCompatActivity {

    boolean showFAB = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        /**
         * Bottom Sheet
         */

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
}
