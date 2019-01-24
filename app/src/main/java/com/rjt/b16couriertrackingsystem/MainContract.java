package com.rjt.b16couriertrackingsystem;

import android.content.Context;

public interface MainContract {

    interface MainView{

    }

    interface MainPresenter{
        void openPickupRequest(MainActivity activity);
    }
}
