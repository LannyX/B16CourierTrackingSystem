package com.rjt.b16couriertrackingsystem.api.status.all;

import com.rjt.b16couriertrackingsystem.MainActivity;

public interface AllStatusRequestContract {

    interface AllStatusView{ }

    interface AllStatusPresenter{
        void requestAllStatus(String email, MainActivity activity);
    }
}
