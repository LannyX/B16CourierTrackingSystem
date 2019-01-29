package com.rjt.b16couriertrackingsystem.map;

import android.os.Bundle;
import android.view.View;

import com.rjt.b16couriertrackingsystem.MainActivity;
import com.rjt.b16couriertrackingsystem.R;
import com.rjt.b16couriertrackingsystem.map.model.Result;

import java.io.Serializable;
import java.util.List;

public class MapsPresenter implements MapsContract.Presenter{


    @Override
    public void viewResultinList(View view, Boolean hasLocation, MainActivity mainActivity
    , List<Result> nearbyList) {
        if(hasLocation == true){
            Bundle b = new Bundle();
            b.putSerializable("unique", (Serializable) nearbyList);
            NearbyFragment nearbyFragment = new NearbyFragment();
            nearbyFragment.setArguments(b);

            mainActivity.getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.mapView, nearbyFragment)
                    .commit();
        }else {
            showToast();
        }
    }

    private void showToast() {
    }
}
