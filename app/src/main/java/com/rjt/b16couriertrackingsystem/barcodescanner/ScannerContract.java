package com.rjt.b16couriertrackingsystem.barcodescanner;

import info.androidhive.barcode.BarcodeReader;

public interface ScannerContract {

    interface IView{
        void getResponse(String response);
    }

    interface IPresenter{
        void decodeBarcode(BarcodeReader barcodeReader);
    }

}
