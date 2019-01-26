package com.rjt.b16couriertrackingsystem.barcodescanner;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.rjt.b16couriertrackingsystem.R;

public class ScannerActivity extends AppCompatActivity implements ScannerContract.View {

    private static final String TAG = "MainActivity";
    private ScannerContract.Presenter presenter;
    private IntentIntegrator qrScan;
    Button button_click;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);

        presenter = new ScannerPresenter(this);
       button_click = findViewById(R.id.button_process);
        qrScan = new IntentIntegrator(this);

        button_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (presenter!=null){
                    Log.d(TAG, "onClick: worked");
                    presenter.requestBarcodeScan(qrScan);
            }
            else{
                    Log.d(TAG, "onClick: presenter is null");
                }
            }});
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
                if (intentResult!=null){
                    if (intentResult.getContents()==null){
                        Toast.makeText(this, "No Scan Data Found!", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Log.d(TAG, "onActivityResult: " + intentResult.getContents());
                        Toast.makeText(this, "Scanned " + intentResult.getContents(), Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    super.onActivityResult(requestCode, resultCode, data);
                }
    }

    @Override
    public void showMsg(String result) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(result);
        builder.show();
    }

}