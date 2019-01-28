package com.rjt.b16couriertrackingsystem.barcodescanner;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.rjt.b16couriertrackingsystem.R;

import info.androidhive.barcode.BarcodeReader;

public class ScannerActivity extends AppCompatActivity implements ScannerContract.IView  {

    private static final String TAG = "ScannerActivity";
    ScannerContract.IPresenter presenter;
    private BarcodeReader barcodeReader;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);

        presenter = new ScannerPresenter(this);
        barcodeReader = (BarcodeReader) getSupportFragmentManager().findFragmentById(R.id.barcode_fragment);

        presenter.decodeBarcode(barcodeReader);
    }

    @Override
    public void getResponse(String response) {
        Log.d(TAG, "getResponse from presenter: " + response);
       Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
    }
}
