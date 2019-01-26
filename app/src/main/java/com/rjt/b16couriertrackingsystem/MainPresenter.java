package com.rjt.b16couriertrackingsystem;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentTransaction;

import com.rjt.b16couriertrackingsystem.api.status.all.AllStatusRequest;
import com.rjt.b16couriertrackingsystem.status.api.PickupRequest;

public class MainPresenter implements MainContract.MainPresenter {

    public static String TAG = MainPresenter.class.getSimpleName();

    MainContract.MainView view;

    public MainPresenter(MainActivity activity){
        view = (MainContract.MainView) activity;
    }

    @Override
    public void openPickupRequest(MainActivity activity) {
        PickupRequest fm = new PickupRequest();
        FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.drawer_layout, fm , "");
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void openStatusAll(MainActivity activity) {
        AllStatusRequest fm = new AllStatusRequest();
        FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.drawer_layout, fm , "");
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
