package com.rjt.b16couriertrackingsystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.rjt.b16couriertrackingsystem.barcodescanner.ScannerActivity;
import com.rjt.b16couriertrackingsystem.map.MapsActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainContract.MainView{

    private static final String TAG = "MainActivity";
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
    private DrawerLayout mDrawer;
    private Toolbar toolbar;
    private NavigationView nvDrawer;
    private ActionBarDrawerToggle drawerToggle;

    MainContract.MainPresenter presenter;

    //My branch
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mDrawer = findViewById(R.id.drawer_layout);
        nvDrawer = findViewById(R.id.nvView);
        setupDrawerContent(nvDrawer);

        //initialize presenter
        presenter = new MainPresenter(this);
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawer.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void selectDrawerItem(MenuItem menuItem) {
        // Create a new fragment and specify the fragment to show based on nav item clicked
//        Fragment fragment = null;
//        Class fragmentClass;
        switch (menuItem.getItemId()) {
            case R.id.barcode_scanner:
//                fragmentClass = FirstFragment.class;
                startActivity(new Intent(MainActivity.this, ScannerActivity.class));
                break;
            case R.id.pickup_request:
                setButtonInvisible();
                presenter.openPickupRequest(this);
                break;
            case R.id.shipment_status:
                setButtonInvisible();
                presenter.openStatusAll(this);
                break;
            case R.id.search_nearby:
                setButtonInvisible();
                startActivity(new Intent(MainActivity.this, MapsActivity.class));
                break;
//            default:
//                fragmentClass = FirstFragment.class;
        }
        try {
//            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Insert the fragment by replacing any existing fragment

//        FragmentManager fragmentManager = getSupportFragmentManager();
//        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();

        // Highlight the selected item has been done by NavigationView
        menuItem.setChecked(true);
        // Set action bar title
        setTitle(menuItem.getTitle());
        // Close the navigation drawer
        mDrawer.closeDrawers();
    }


    //setOnClickButtons
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
                presenter.openStatusVendor(this);
                setButtonInvisible();
                break;
            case R.id.buttonStatusNumber:
                presenter.openStatusTracking(this);
                setButtonInvisible();
                break;
            case R.id.buttonStatusToME:
                presenter.openStatusToMe(this);
                setButtonInvisible();
                break;
            case R.id.buttonStatusFromMe:
                presenter.openStatusFromMe(this);
                setButtonInvisible();
                break;
            case R.id.buttonStatusWatchList:
                presenter.openStatusWatchList(this);
                setButtonInvisible();
                break;
        }
    }

    //Hide all buttons in fragments
    private void setButtonInvisible() {
        buttonPickupRequest.setVisibility(View.GONE);
        buttonStatusAll.setVisibility(View.GONE);
        buttonStatusVendor.setVisibility(View.GONE);
        buttonStatusNumber.setVisibility(View.GONE);
        buttonStatusToME.setVisibility(View.GONE);
        buttonStatusFromMe.setVisibility(View.GONE);
        buttonStatusWatchList.setVisibility(View.GONE);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
