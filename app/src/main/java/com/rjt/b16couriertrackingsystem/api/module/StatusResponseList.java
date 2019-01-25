package com.rjt.b16couriertrackingsystem.api.module;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StatusResponseList {

    @SerializedName("Shipments")
    private List<StatusResponse> status;

    public List<StatusResponse> getStatus(){
        return status;
    }
}
