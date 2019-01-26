package com.rjt.b16couriertrackingsystem.api.status.all;

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

public class AllStatusRequest extends Fragment implements AllStatusRequestContract.AllStatusView {

    @BindView(R.id.editTextStatusAllEmail)
    EditText editTextStatusAllEmail;
    @BindView(R.id.buttonStatusAll)
    Button buttonStatusAll;
    Unbinder unbinder;

    AllStatusRequestContract.AllStatusPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_all_status, container, false);

        presenter = new AllStatusRequestPresenter(this);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.buttonStatusAll)
    public void onViewClicked() {
        presenter.requestAllStatus(editTextStatusAllEmail.getText().toString(), (MainActivity) getActivity());
    }
}
