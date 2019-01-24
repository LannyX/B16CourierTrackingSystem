package com.rjt.b16couriertrackingsystem.status.api;

import android.util.Log;

import com.rjt.b16couriertrackingsystem.network.RetrofitClientInstance;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PickupRequestPresenter implements PickupRequestContract.PickupPresenter {

    public static String TAG = PickupRequestPresenter.class.getSimpleName();

    PickupRequestContract.PickupView view;

    public PickupRequestPresenter(PickupRequest pickupRequest){
        view =  pickupRequest;
    }

    @Override
    public void sendRequest(String packageName, String pickAddr, String deliverAddr, String time, String email) {
        if(validate(packageName, pickAddr, deliverAddr, time, email)){
            final GetPickupRequestService getPickupRequestService = RetrofitClientInstance.getRetrofitInstance()
                    .create(GetPickupRequestService.class);
            Call<ResponseBody> call = getPickupRequestService.getRequest(packageName, pickAddr, deliverAddr, time, email);
            call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    Log.e(TAG, response.toString());
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    Log.e(TAG, t.getMessage());
                }
            });
        }
    }

    private boolean validate(String packageName, String pickAddr, String deliverAddr, String time, String email) {
        boolean result = false;
        if(!packageName.isEmpty() || !pickAddr.isEmpty() || !deliverAddr.isEmpty() ||
        !time.isEmpty() || !email.isEmpty()){
            result = true;
        }
        return result;
    }
}
