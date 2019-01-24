package com.rjt.b16couriertrackingsystem.status.api;

public interface PickupRequestContract {

    interface PickupView{

    }

    interface PickupPresenter{
        void sendRequest(String packageName, String pickAddr, String deliverAddr, String time, String email);
    }
}
