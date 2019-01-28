package com.rjt.b16couriertrackingsystem.barcodescanner;

import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.vision.barcode.Barcode;
import java.util.List;
import info.androidhive.barcode.BarcodeReader;

public class ScannerPresenter implements ScannerContract.IPresenter , BarcodeReader.BarcodeReaderListener{

    private ScannerContract.IView iView;
    private static final String TAG = "ScannerPresenter";
    private BarcodeReader barcodeReader;

    public ScannerPresenter(ScannerActivity scannerActivity) {
        this.iView = scannerActivity;
    }

    @Override
    public void decodeBarcode(BarcodeReader barcodeReader) {
        this.barcodeReader = barcodeReader;
    }

    @Override
    public void onScanned(Barcode barcode) {
        Log.d(TAG, "onScanned: " + barcode.toString());
        iView.getResponse(barcode.displayValue);
    }

    @Override
    public void onScannedMultiple(List<Barcode> barcodes) {

    }

    @Override
    public void onBitmapScanned(SparseArray<Barcode> sparseArray) {

    }

    @Override
    public void onScanError(String errorMessage) {

    }

    @Override
    public void onCameraPermissionDenied() {

    }
}
