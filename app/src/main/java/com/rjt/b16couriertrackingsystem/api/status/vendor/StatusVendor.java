package com.rjt.b16couriertrackingsystem.api.status.vendor;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.rjt.b16couriertrackingsystem.MainActivity;
import com.rjt.b16couriertrackingsystem.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class StatusVendor extends Fragment implements StatusVendorContract.StatusVendorView {

    Button buttonStatusVendor;
    Unbinder unbinder;

    StatusVendorContract.StatusVendorPresenter presenter;
    String email;
    ImageButton imageButtonCST;
    ImageButton imageButtonFedex;
    ImageButton imageButtonHCL;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vendor_status, container, false);

        imageButtonCST = view.findViewById(R.id.imageButtonCST);
        imageButtonFedex = view.findViewById(R.id.imageButtonFedex);
        imageButtonHCL = view.findViewById(R.id.imageButtonHCL);

        SharedPreferences sp = getActivity().getSharedPreferences("userFile", Context.MODE_PRIVATE);
        email = sp.getString("email", "");

        presenter = new StatusVendorPresenter(this);
        unbinder = ButterKnife.bind(this, view);

        imageButtonCST.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.requestVendorStatus(email,
                        "CST",
                        (MainActivity) getActivity());
            }
        });

        imageButtonFedex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.requestVendorStatus(email,
                        "Fedex",
                        (MainActivity) getActivity());
            }
        });

        imageButtonHCL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.requestVendorStatus(email,
                        "hcl",
                        (MainActivity) getActivity());
            }
        });

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
