package com.rjt.b16couriertrackingsystem;

import android.content.Context;

public interface MainContract {

    interface MainView{

    }

    interface MainPresenter{
        void openPickupRequest(MainActivity activity);
        void openStatusAll(MainActivity activity);
        void openStatusVendor(MainActivity activity);
        void openStatusTracking(MainActivity activity);
        void openStatusToMe(MainActivity activity);
        void openStatusFromMe(MainActivity activity);
        void openStatusWatchList(MainActivity activity);
    }
}
