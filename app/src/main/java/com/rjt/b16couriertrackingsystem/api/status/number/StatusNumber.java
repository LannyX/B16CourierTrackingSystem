package com.rjt.b16couriertrackingsystem.api.status.number;

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
import com.rjt.b16couriertrackingsystem.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class StatusNumber extends Fragment implements StatusNumberContract.StatusNumberView {


    @BindView(R.id.editTextStatusNumber)
    EditText editTextStatusNumber;
    @BindView(R.id.buttonStatusNumber)
    Button buttonStatusNumber;
    Unbinder unbinder;

    StatusNumberContract.StatusNumberPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_number_status, container, false);

        presenter = new StatusNumberPresenter(this);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.buttonStatusNumber)
    public void onViewClicked() {
        presenter.requestNumberStatus(editTextStatusNumber.getText().toString(), (MainActivity) getActivity());
    }
}
