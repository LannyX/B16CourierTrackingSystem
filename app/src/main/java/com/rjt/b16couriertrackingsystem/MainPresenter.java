package com.rjt.b16couriertrackingsystem;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

import com.rjt.b16couriertrackingsystem.api.status.all.AllStatusRequest;
import com.rjt.b16couriertrackingsystem.api.status.from.me.StatusFromMeView;
import com.rjt.b16couriertrackingsystem.api.status.number.StatusNumber;
import com.rjt.b16couriertrackingsystem.api.status.tome.StatusToMeView;
import com.rjt.b16couriertrackingsystem.api.status.vendor.StatusVendor;
import com.rjt.b16couriertrackingsystem.api.status.watch.list.StatusWatchListView;
import com.rjt.b16couriertrackingsystem.status.api.PickupRequest;

public class MainPresenter implements MainContract.MainPresenter {

    public static String TAG = MainPresenter.class.getSimpleName();

    MainContract.MainView view;

    public MainPresenter(MainActivity activity){
        view =  activity;
    }

    @Override
    public void openPickupRequest(MainActivity activity) {
        PickupRequest fm = new PickupRequest();
        FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.drawer_layout, fm , "");
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void openStatusAll(MainActivity activity) {
        AllStatusRequest fm = new AllStatusRequest();
        FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.drawer_layout, fm , "");
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void openStatusVendor(MainActivity activity) {
        StatusVendor fm = new StatusVendor();
        FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.drawer_layout, fm , "");
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void openStatusTracking(MainActivity activity) {
        StatusNumber fm = new StatusNumber();
        FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.drawer_layout, fm , "");
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void openStatusToMe(MainActivity activity) {
        StatusToMeView fm = new StatusToMeView();
        FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.drawer_layout, fm , "");
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void openStatusFromMe(MainActivity activity) {
        StatusFromMeView fm = new StatusFromMeView();
        FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.drawer_layout, fm , "");
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void openStatusWatchList(MainActivity activity) {
        StatusWatchListView fm = new StatusWatchListView();
        FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.drawer_layout, fm , "");
        transaction.addToBackStack(null);
        transaction.commit();
    }


}
