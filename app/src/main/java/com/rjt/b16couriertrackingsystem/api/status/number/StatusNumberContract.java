package com.rjt.b16couriertrackingsystem.api.status.number;

import com.rjt.b16couriertrackingsystem.MainActivity;

public interface StatusNumberContract {

    interface StatusNumberView{}

    interface StatusNumberPresenter{
        void requestNumberStatus(String trackNumber, MainActivity activity);
    }
}
