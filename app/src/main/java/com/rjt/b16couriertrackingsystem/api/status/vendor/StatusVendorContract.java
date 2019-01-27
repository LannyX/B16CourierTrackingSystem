package com.rjt.b16couriertrackingsystem.api.status.vendor;

import com.rjt.b16couriertrackingsystem.MainActivity;

public interface StatusVendorContract {

    interface StatusVendorView{}

    interface StatusVendorPresenter{
        void requestVendorStatus(String email,
                                 String vendor,
                                 MainActivity activity);
    }
}
