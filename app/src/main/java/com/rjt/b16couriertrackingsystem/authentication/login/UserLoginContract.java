package com.rjt.b16couriertrackingsystem.authentication.login;

import android.content.Context;
import android.content.SharedPreferences;

public interface UserLoginContract {

    interface UserLoginView{
        void showMsg(String msg);
        void callingMainActivity();
    }

    interface UserLoginPresenter{
        void requestData(String email, String password, SharedPreferences sharedPreferences);
        void moveToMainActivity(Context context);
    }

}
