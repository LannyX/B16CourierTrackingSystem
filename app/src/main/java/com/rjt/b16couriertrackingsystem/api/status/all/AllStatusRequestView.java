package com.rjt.b16couriertrackingsystem.api.status.all;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rjt.b16couriertrackingsystem.R;
import com.rjt.b16couriertrackingsystem.api.module.StatusResponse;
import com.rjt.b16couriertrackingsystem.api.module.StatusResponseList;
import com.rjt.b16couriertrackingsystem.api.module.StatusResponseListAdapter;
import com.rjt.b16couriertrackingsystem.api.status.all.network.AllStatusResponseService;
import com.rjt.b16couriertrackingsystem.network.RetrofitClientInstance;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllStatusRequestView extends Fragment {

    public static String TAG = AllStatusRequestView.class.getSimpleName();
    RecyclerView recyclerView;
    StatusResponseListAdapter myAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_all_status_view, container, false);
        recyclerView = view.findViewById(R.id.allStatusRecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        Bundle b = getArguments();
        String email = b.getString("email");

        if(validate(email)){
            final AllStatusResponseService allStatusResponseService = RetrofitClientInstance.getRetrofitInstance()
                    .create(AllStatusResponseService.class);
            Call<StatusResponseList> call = allStatusResponseService.getResponseList(email);
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


    private boolean validate(String email) {
        boolean result = false;
        if(!email.isEmpty()){
            result = true;
        }
        return result;
    }
}
