package com.rjt.b16couriertrackingsystem.termncondition;

import android.content.Context;
import android.content.Intent;

import com.rjt.b16couriertrackingsystem.authentication.login.UserLogin;

public class TermConditionScreenPresenter implements TermConditionScreenContract.TermConditionScreenPresenter{
    TermConditionScreenContract.TermConditionScreenView mView;

    public TermConditionScreenPresenter(TermConditionScreenActivity activity) {
        mView = activity;
    }

    @Override
    public void moveToNextActivity(Context context) {
        Intent i = new Intent(context, UserLogin.class);
        context.startActivity(i);
    }

    @Override
    public void unableToProceed() {
        mView.showMsg("Please confirm to proceed");
    }


}
