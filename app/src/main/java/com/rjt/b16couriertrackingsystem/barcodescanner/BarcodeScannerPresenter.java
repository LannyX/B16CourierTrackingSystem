package com.rjt.b16couriertrackingsystem.barcodescanner;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;

public class BarcodeScannerPresenter {

    private static final String TAG = "BarcodeScannerPresenter";
    private static final int RC_HANDLE_CAMERA_PERM = 2;

    private void requestCameraPermission() {
        Log.w(TAG, "Camera permission is not granted. Requesting permission");

        final String[] permissions = new String[]{Manifest.permission.CAMERA};

        if (!ActivityCompat.shouldShowRequestPermissionRationale( new ScannerActivity(),
                Manifest.permission.CAMERA)) {
//            ActivityCompat.requestPermissions(this, permissions, RC_HANDLE_CAMERA_PERM);
            return;
        }

//        final Activity thisActivity = ;

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                ActivityCompat.requestPermissions(thisActivity, permissions,
//                        RC_HANDLE_CAMERA_PERM);
            }
        };
    }
}
