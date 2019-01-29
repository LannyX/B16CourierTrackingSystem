package com.rjt.b16couriertrackingsystem.termncondition;

import android.content.Context;

public interface TermConditionScreenContract {

    interface TermConditionScreenView{
        void showMsg(String msg);
    }

    interface TermConditionScreenPresenter{
        void moveToNextActivity(Context context);
        void unableToProceed();
    }
}
