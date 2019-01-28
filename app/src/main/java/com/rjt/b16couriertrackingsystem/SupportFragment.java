package com.rjt.b16couriertrackingsystem;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class SupportFragment extends Fragment {


    @BindView(R.id.textView_call_support)
    TextView textViewCallSupport;
    @BindView(R.id.textView_email_support)
    TextView textViewEmailSupport;
    Unbinder unbinder;

    public SupportFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_support, container, false);

        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.textView_call_support, R.id.textView_email_support})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.textView_call_support:
                String phone = "800.345.2222";
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                startActivity(intent);
                break;
            case R.id.textView_email_support:
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto","rjt@gmail.com", null));
                startActivity(emailIntent);
                break;
        }
    }
}
