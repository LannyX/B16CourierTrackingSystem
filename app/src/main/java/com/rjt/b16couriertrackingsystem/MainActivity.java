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
import android.widget.ImageView;

import com.rjt.b16couriertrackingsystem.barcodescanner.ScannerActivity;
import com.rjt.b16couriertrackingsystem.map.MapsActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainContract.MainView {

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
    @BindView(R.id.imageViewRequest)
    ImageView imageViewRequest;
    @BindView(R.id.imageViewAll)
    ImageView imageViewAll;
    @BindView(R.id.imageViewVendor)
    ImageView imageViewVendor;
    @BindView(R.id.imageViewNumber)
    ImageView imageViewNumber;
    @BindView(R.id.imageViewToMe)
    ImageView imageViewToMe;
    @BindView(R.id.imageViewFromMe)
    ImageView imageViewFromMe;
    @BindView(R.id.imageViewWatchList)
    ImageView imageViewWatchList;
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

        imageViewRequest.setImageResource(R.drawable.request);
        imageViewAll.setImageResource(R.drawable.all);
        imageViewVendor.setImageResource(R.drawable.vendor);
        imageViewNumber.setImageResource(R.drawable.number);
        imageViewToMe.setImageResource(R.drawable.tome);
        imageViewFromMe.setImageResource(R.drawable.fromme);
        imageViewWatchList.setImageResource(R.drawable.list);



        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mDrawer = findViewById(R.id.drawer_layout);
        nvDrawer = findViewById(R.id.nvView);
        setupDrawerContent(nvDrawer);

        //initialize presenter
        presenter = new MainPresenter(this);
    }

    private void setPictureInvisible() {
        imageViewRequest.setVisibility(View.INVISIBLE);
        imageViewAll.setVisibility(View.INVISIBLE);
        imageViewVendor.setVisibility(View.INVISIBLE);
        imageViewNumber.setVisibility(View.INVISIBLE);
        imageViewToMe.setVisibility(View.INVISIBLE);
        imageViewFromMe.setVisibility(View.INVISIBLE);
        imageViewWatchList.setVisibility(View.INVISIBLE);
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
                setPictureInvisible();
                presenter.openPickupRequest(this);
                break;
            case R.id.shipment_status:
                setButtonInvisible();
                setPictureInvisible();
                presenter.openStatusAll(this);
                break;
            case R.id.search_nearby:
                setButtonInvisible();
                setPictureInvisible();
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
                setPictureInvisible();
                setButtonInvisible();
                presenter.openPickupRequest(this);
                break;
            case R.id.buttonStatusAll:
                setPictureInvisible();
                setButtonInvisible();
                presenter.openStatusAll(this);
                break;
            case R.id.buttonStatusVendor:
                setPictureInvisible();
                presenter.openStatusVendor(this);
                setButtonInvisible();
                break;
            case R.id.buttonStatusNumber:
                setPictureInvisible();
                presenter.openStatusTracking(this);
                setButtonInvisible();
                break;
            case R.id.buttonStatusToME:
                setPictureInvisible();
                presenter.openStatusToMe(this);
                setButtonInvisible();
                break;
            case R.id.buttonStatusFromMe:
                setPictureInvisible();
                presenter.openStatusFromMe(this);
                setButtonInvisible();
                break;
            case R.id.buttonStatusWatchList:
                setPictureInvisible();
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
