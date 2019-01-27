package com.rjt.b16couriertrackingsystem.api.status.vendor;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjt.b16couriertrackingsystem.R;
import com.rjt.b16couriertrackingsystem.api.module.StatusResponseList;
import com.rjt.b16couriertrackingsystem.api.module.StatusResponseListAdapter;
import com.rjt.b16couriertrackingsystem.api.status.all.AllStatusRequestView;
import com.rjt.b16couriertrackingsystem.api.status.network.StatusResponseService;
import com.rjt.b16couriertrackingsystem.network.RetrofitClientInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StatusVendorView  extends Fragment {
    public static String TAG = AllStatusRequestView.class.getSimpleName();
    RecyclerView recyclerView;
    StatusResponseListAdapter myAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vendor_status_view, container, false);
        recyclerView = view.findViewById(R.id.recyclerViewStatusVendor);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        Bundle b = getArguments();
        String email = b.getString("email");
        String vendor = b.getString("vendor");

        if(validate(email, vendor)){
            final StatusResponseService statusResponseService = RetrofitClientInstance.getRetrofitInstance()
                    .create(StatusResponseService.class);
            Call<StatusResponseList> call = statusResponseService.getResponseVendor(email, vendor);
            Log.e(TAG, "CALLING RESPONSE");
            call.enqueue(new Callback<StatusResponseList>() {
                @Override
                public void onResponse(Call<StatusResponseList> call, Response<StatusResponseList> response) {
                    StatusResponseList list = response.body();
                    callAdapter(list);
                }

                @Override
                public void onFailure(Call<StatusResponseList> call, Throwable t) {
                    t.getMessage();
                }
            });
        }

        return view;
    }

    private void callAdapter(StatusResponseList list) {
        myAdapter = new StatusResponseListAdapter(list);
        recyclerView.setAdapter(myAdapter);
    }


    private boolean validate(String email, String vendor) {
        boolean result = false;
        if(!email.isEmpty() || !vendor.isEmpty()){
            result = true;
        }
        return result;
    }
}
