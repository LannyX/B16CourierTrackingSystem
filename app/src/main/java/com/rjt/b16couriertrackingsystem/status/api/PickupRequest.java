package com.rjt.b16couriertrackingsystem.status.api;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.rjt.b16couriertrackingsystem.MainActivity;
import com.rjt.b16couriertrackingsystem.MainContract;
import com.rjt.b16couriertrackingsystem.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class PickupRequest extends Fragment implements PickupRequestContract.PickupView{

    @BindView(R.id.editTextPickupRequestName)
    EditText editTextPickupRequestName;
    @BindView(R.id.editTextPickupRequestAddr)
    EditText editTextPickupRequestAddr;
    @BindView(R.id.editTextPickupRequestDelivery)
    EditText editTextPickupRequestDelivery;
    @BindView(R.id.editTextPickupRequestTime)
    EditText editTextPickupRequestTime;
    @BindView(R.id.buttonRequest)
    Button buttonRequest;
    Unbinder unbinder;

    Button buttonBack;


    PickupRequestContract.PickupPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pickup_request, container, false);
        presenter = new PickupRequestPresenter(this);
        buttonBack = view.findViewById(R.id.toolBarBackButton);
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

        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.buttonRequest)
    public void onViewClicked() {
        presenter.sendRequest(editTextPickupRequestName.getText().toString(),
                editTextPickupRequestAddr.getText().toString(),
                editTextPickupRequestDelivery.getText().toString(),
                editTextPickupRequestTime.getText().toString(),
                "aa@aa.com");
    }

}
