package com.rjt.b16couriertrackingsystem.api.status.all;


import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

import com.rjt.b16couriertrackingsystem.MainActivity;
import com.rjt.b16couriertrackingsystem.R;

public class AllStatusRequestPresenter implements AllStatusRequestContract.AllStatusPresenter {

    public static String TAG = AllStatusRequestPresenter.class.getSimpleName();

    AllStatusRequestContract.AllStatusView view;

    public AllStatusRequestPresenter(AllStatusRequest view) {
        this.view = view;
    }


    @Override
    public void requestAllStatus(String email, MainActivity activity) {
        AllStatusRequestView fm = new AllStatusRequestView();
        Bundle b = new Bundle();
        b.putString("email", email);
        fm.setArguments(b);
        FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.drawer_layout, fm , "");
        transaction.addToBackStack(null);
        transaction.commit();


    }
}
