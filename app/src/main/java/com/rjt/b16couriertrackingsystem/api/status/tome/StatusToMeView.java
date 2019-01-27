package com.rjt.b16couriertrackingsystem.api.status.tome;

import android.content.Context;
import android.content.SharedPreferences;
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
import com.rjt.b16couriertrackingsystem.api.status.network.StatusResponseService;
import com.rjt.b16couriertrackingsystem.network.RetrofitClientInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StatusToMeView extends Fragment {
    public static String TAG = StatusToMeView.class.getSimpleName();
    RecyclerView recyclerView;
    StatusResponseListAdapter myAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tome_status_view, container, false);
        recyclerView = view.findViewById(R.id.recyclerViewToMe);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        SharedPreferences sp = getActivity().getSharedPreferences("userFile", Context.MODE_PRIVATE);
        String email = sp.getString("email", "");


        final StatusResponseService statusResponseService = RetrofitClientInstance.getRetrofitInstance()
                .create(StatusResponseService.class);
        Call<StatusResponseList> call = statusResponseService.getResponseToMe(email, "1");
        Log.e(TAG, "CALLING RESPONSE TOME");
        call.enqueue(new Callback<StatusResponseList>() {
            @Override
            public void onResponse(Call<StatusResponseList> call, Response<StatusResponseList> response) {
                StatusResponseList list = response.body();
                Log.e(TAG, response.toString());
                callAdapter(list);
            }

            @Override
            public void onFailure(Call<StatusResponseList> call, Throwable t) {
                t.getMessage();
            }
        });

        return view;
    }

    private void callAdapter(StatusResponseList list) {
        myAdapter = new StatusResponseListAdapter(list);
        recyclerView.setAdapter(myAdapter);
    }
}