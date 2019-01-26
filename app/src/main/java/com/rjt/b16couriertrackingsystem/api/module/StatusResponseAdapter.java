package com.rjt.b16couriertrackingsystem.api.module;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rjt.b16couriertrackingsystem.R;

import java.util.ArrayList;

import butterknife.BindView;

public class StatusResponseAdapter extends RecyclerView.Adapter<StatusResponseAdapter.ViewHolder> {
    @BindView(R.id.allStatusId)
    TextView allStatusId;
    @BindView(R.id.allStatusSta)
    TextView allStatusSta;
    @BindView(R.id.allStatusVendor)
    TextView allStatusVendor;
    @BindView(R.id.allStatusName)
    TextView allStatusName;
    @BindView(R.id.allStatusPickup)
    TextView allStatusPickup;
    @BindView(R.id.allStatusDelivery)
    TextView allStatusDelivery;
    @BindView(R.id.allStatusPickupTime)
    TextView allStatusPickupTime;
    @BindView(R.id.allStatusDeliveryTime)
    TextView allStatusDeliveryTime;

    private ArrayList<StatusResponse> myList;

    public StatusResponseAdapter(ArrayList<StatusResponse> myList) {
        this.myList = myList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.all_status_view, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
            StatusResponse item = myList.get(i);

            allStatusId.setText(item.getShipmentid());
            allStatusName.setText(item.getPackagename());
            allStatusSta.setText(item.getShipmentstatus());
            allStatusVendor.setText(item.getVendor());
            allStatusDelivery.setText(item.getDeliveryaddress());
            allStatusPickup.setText(item.getPickupaddress());
            allStatusDeliveryTime.setText(item.getDeliverytime());
            allStatusPickupTime.setText(item.getPickuptime());
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
