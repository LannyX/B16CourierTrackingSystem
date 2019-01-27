package com.rjt.b16couriertrackingsystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.rjt.b16couriertrackingsystem.authentication.login.UserLogin;
import com.rjt.b16couriertrackingsystem.termncondition.TermConditionScreenActivity;


public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startActivity(new Intent(getApplicationContext(), TermConditionScreenActivity.class));
        finish();
    }
}
