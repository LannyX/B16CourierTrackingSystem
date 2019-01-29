package com.rjt.b16couriertrackingsystem.map;

import com.rjt.b16couriertrackingsystem.MainActivity;
import com.rjt.b16couriertrackingsystem.map.model.Result;

import java.util.List;

public interface MapsContract {

    interface View{
        void showToast();
    }
    interface Presenter{

        void viewResultinList(android.view.View view, Boolean hasLocation, MainActivity mainActivity
        , List<Result> nearbyList);
    }
}
