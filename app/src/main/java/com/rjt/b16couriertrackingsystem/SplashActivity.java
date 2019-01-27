package com.rjt.b16couriertrackingsystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.rjt.b16couriertrackingsystem.authentication.login.UserLogin;
import com.rjt.b16couriertrackingsystem.countrylist.CountryListActivity;


public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Boolean isFirstRun = getSharedPreferences("userFile", MODE_PRIVATE)
                .getBoolean("isFirstRun", true);

        if (isFirstRun){
            startActivity(new Intent(getApplicationContext(), CountryListActivity.class));
        }else{
            startActivity(new Intent(getApplicationContext(), UserLogin.class));
        }

        getSharedPreferences("userFile", MODE_PRIVATE).edit()
                .putBoolean("isFirstRun", true).commit();

        finish();
    }
}
