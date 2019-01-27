package com.rjt.b16couriertrackingsystem.api.status.vendor;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

import com.rjt.b16couriertrackingsystem.MainActivity;
import com.rjt.b16couriertrackingsystem.R;

public class StatusVendorPresenter implements StatusVendorContract.StatusVendorPresenter{

    StatusVendorContract.StatusVendorView view;

    public StatusVendorPresenter(StatusVendorContract.StatusVendorView view) {
        this.view = view;
    }

    @Override
    public void requestVendorStatus(String email, String vendor, MainActivity activity) {
        StatusVendorView fm = new StatusVendorView();
        Bundle b = new Bundle();
        b.putString("email", email);
        b.putString("vendor", vendor);
        fm.setArguments(b);
        FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.drawer_layout, fm , "");
        transaction.addToBackStack(null);
        transaction.commit();

    }
}
