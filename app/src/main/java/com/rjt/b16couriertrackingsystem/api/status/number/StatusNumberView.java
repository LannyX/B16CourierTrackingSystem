package com.rjt.b16couriertrackingsystem.api.status.number;

import android.content.Context;
import android.content.Intent;
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
import android.widget.Button;

import com.rjt.b16couriertrackingsystem.MainActivity;
import com.rjt.b16couriertrackingsystem.R;
import com.rjt.b16couriertrackingsystem.api.module.StatusResponseList;
import com.rjt.b16couriertrackingsystem.api.module.StatusResponseListAdapter;
import com.rjt.b16couriertrackingsystem.api.status.network.StatusResponseService;
import com.rjt.b16couriertrackingsystem.network.RetrofitClientInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class StatusNumberView extends Fragment {

    private static String TAG = StatusNumberView.class.getSimpleName();
    RecyclerView recyclerView;
    StatusResponseListAdapter myAdapter;
    Button buttonBack;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_number_status_view, container, false);
        recyclerView = view.findViewById(R.id.recyclerViewNumber);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        buttonBack = view.findViewById(R.id.toolBarBackButton);


        Bundle b = getArguments();
        String trackNumber = b.getString("trackNumber");
        SharedPreferences sp = getActivity().getSharedPreferences("userFile", Context.MODE_PRIVATE);
        String email = sp.getString("email", "");

        if(validate(trackNumber)){
            final StatusResponseService statusResponseService = RetrofitClientInstance.getRetrofitInstance()
                    .create(StatusResponseService.class);
            Call<StatusResponseList> call = statusResponseService.getResponseNumber(email, trackNumber);
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


        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (Fragment fragment:getActivity().getSupportFragmentManager().getFragments()) {
                    getActivity().getSupportFragmentManager().beginTransaction().remove(fragment).commit();
                }

                Intent i = new Intent(getActivity(),  MainActivity.class);
                startActivity(i);
            }
        });
        return view;
    }

    private void callAdapter(StatusResponseList list) {
        myAdapter = new StatusResponseListAdapter(list);
        recyclerView.setAdapter(myAdapter);
    }


    private boolean validate(String trackNumber) {
        boolean result = false;
        if(!trackNumber.isEmpty()){
            result = true;
        }
        return result;
    }
}
