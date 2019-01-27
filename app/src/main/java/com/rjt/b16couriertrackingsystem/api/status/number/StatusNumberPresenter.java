package com.rjt.b16couriertrackingsystem.api.status.number;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

import com.rjt.b16couriertrackingsystem.MainActivity;
import com.rjt.b16couriertrackingsystem.R;

public class StatusNumberPresenter implements StatusNumberContract.StatusNumberPresenter {

    StatusNumberContract.StatusNumberView view;

    public StatusNumberPresenter(StatusNumberContract.StatusNumberView view) {
        this.view = view;
    }

    @Override
    public void requestNumberStatus(String trackNumber, MainActivity activity) {
        StatusNumberView fm = new StatusNumberView();
        Bundle b = new Bundle();
        b.putString("trackNumber", trackNumber);
        fm.setArguments(b);
        FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.drawer_layout, fm , "");
        transaction.addToBackStack(null);
        transaction.commit();


    }
}
