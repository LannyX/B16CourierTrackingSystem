package com.rjt.b16couriertrackingsystem;

import android.content.Context;

public interface MainContract {

    interface MainView{

    }

    interface MainPresenter{
        void openPickupRequest(MainActivity activity);
        void openStatusAll(MainActivity activity);
        void openStatusVendor(MainActivity activity);
    }
}
