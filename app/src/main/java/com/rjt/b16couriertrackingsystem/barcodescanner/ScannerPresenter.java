package com.rjt.b16couriertrackingsystem.barcodescanner;

import com.google.zxing.integration.android.IntentIntegrator;

public class ScannerPresenter implements ScannerContract.Presenter{
    private static final String TAG = "ScannerPresenter";
    ScannerContract.View view;

    public ScannerPresenter (ScannerActivity activity){
        view = activity;
    }

    @Override
    public void requestBarcodeScan(IntentIntegrator qrScan) {
//        qrScan = new IntentIntegrator(ScannerPresenter.this);
        qrScan.initiateScan();
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
//        if (intentResult!=null){
//            if (intentResult.getContents()==null){
//                Toast.makeText(getApplicationContext(), "No Scan Data Found!", Toast.LENGTH_SHORT).show();
//            }
//            else {
//              Log.d(TAG, "onActivityResult: " + intentResult.getContents());
//                Toast.makeText(getApplicationContext(), "Scanned " + intentResult.getContents(), Toast.LENGTH_SHORT).show();
//            }
//        }
//        else
//        {
//            super.onActivityResult(requestCode, resultCode, data);
//        }
//    }



}
