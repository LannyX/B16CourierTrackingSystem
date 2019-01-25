package com.rjt.b16couriertrackingsystem.api.module;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rjt.b16couriertrackingsystem.R;

import butterknife.BindView;

public class StatusResponseListAdapter extends RecyclerView.Adapter<StatusResponseListAdapter.ViewHolder> {

    StatusResponseList myList;


    public StatusResponseListAdapter(StatusResponseList list) {
        this.myList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.all_status_view, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        StatusResponseList item = myList;


        allStatusId.setText(item.getStatus().get(i).getShipmentid());
        allStatusName.setText(item.getStatus().get(i).getPackagename());
        allStatusSta.setText(item.getStatus().get(i).getShipmentstatus());
        allStatusVendor.setText(item.getStatus().get(i).getVendor());
        allStatusDelivery.setText(item.getStatus().get(i).getDeliveryaddress());
        allStatusPickup.setText(item.getStatus().get(i).getPickupaddress());
        allStatusDeliveryTime.setText(item.getStatus().get(i).getDeliverytime());
        allStatusPickupTime.setText(item.getStatus().get(i).getPickuptime());
    }

    @Override
    public int getItemCount() {
        return myList.getStatus().size();
    }
    TextView allStatusId;
    TextView allStatusSta;
    TextView allStatusVendor;
    TextView allStatusName;
    TextView allStatusPickup;
    TextView allStatusDelivery;
    TextView allStatusPickupTime;
    TextView allStatusDeliveryTime;
    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            allStatusId = itemView.findViewById(R.id.allStatusId);
            allStatusSta = itemView.findViewById(R.id.allStatusSta);
            allStatusVendor = itemView.findViewById(R.id.allStatusVendor);
            allStatusName = itemView.findViewById(R.id.allStatusName);
            allStatusPickup = itemView.findViewById(R.id.allStatusPickup);
            allStatusDelivery = itemView.findViewById(R.id.allStatusDelivery);
            allStatusPickupTime = itemView.findViewById(R.id.allStatusPickupTime);
            allStatusDeliveryTime = itemView.findViewById(R.id.allStatusDeliveryTime);
        }
    }
}
