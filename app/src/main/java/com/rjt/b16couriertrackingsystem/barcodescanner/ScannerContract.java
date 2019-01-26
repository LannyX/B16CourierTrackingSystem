package com.rjt.b16couriertrackingsystem.barcodescanner;

import com.google.zxing.integration.android.IntentIntegrator;

public interface ScannerContract {

    interface View{
        void showMsg(String result);
    }

    interface Presenter{
       void requestBarcodeScan(IntentIntegrator qrScan);
    }
}
