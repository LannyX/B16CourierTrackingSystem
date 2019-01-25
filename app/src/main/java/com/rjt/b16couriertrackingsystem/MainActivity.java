package com.rjt.b16couriertrackingsystem;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainContract.MainView {

    @BindView(R.id.buttonPickupRequest)
    Button buttonPickupRequest;
    @BindView(R.id.buttonStatusAll)
    Button buttonStatusAll;
    @BindView(R.id.buttonStatusVendor)
    Button buttonStatusVendor;
    @BindView(R.id.buttonStatusNumber)
    Button buttonStatusNumber;
    @BindView(R.id.buttonStatusToME)
    Button buttonStatusToME;
    @BindView(R.id.buttonStatusFromMe)
    Button buttonStatusFromMe;
    @BindView(R.id.buttonStatusWatchList)
    Button buttonStatusWatchList;

    MainContract.MainPresenter presenter;

    //My branch
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new MainPresenter(this);

    }

    private void setButtonInvisible() {
        buttonPickupRequest.setVisibility(View.GONE);
        buttonStatusAll.setVisibility(View.GONE);
        buttonStatusVendor.setVisibility(View.GONE);
        buttonStatusNumber.setVisibility(View.GONE);
        buttonStatusToME.setVisibility(View.GONE);
        buttonStatusFromMe.setVisibility(View.GONE);
        buttonStatusWatchList.setVisibility(View.GONE);
    }

    @OnClick({R.id.buttonPickupRequest, R.id.buttonStatusAll, R.id.buttonStatusVendor, R.id.buttonStatusNumber, R.id.buttonStatusToME, R.id.buttonStatusFromMe, R.id.buttonStatusWatchList})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.buttonPickupRequest:
                setButtonInvisible();
                presenter.openPickupRequest(this);
                break;
            case R.id.buttonStatusAll:
                setButtonInvisible();
                presenter.openStatusAll(this);
                break;
            case R.id.buttonStatusVendor:
                setButtonInvisible();
                break;
            case R.id.buttonStatusNumber:
                setButtonInvisible();
                break;
            case R.id.buttonStatusToME:
                setButtonInvisible();
                break;
            case R.id.buttonStatusFromMe:
                setButtonInvisible();
                break;
            case R.id.buttonStatusWatchList:
                setButtonInvisible();
                break;
        }
    }
}
