package com.rjt.b16couriertrackingsystem.api.status.all.network;

import com.rjt.b16couriertrackingsystem.api.module.StatusResponse;
import com.rjt.b16couriertrackingsystem.api.module.StatusResponseList;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AllStatusResponseService {

    @GET("shipment_status_all.php?")
    Call<StatusResponseList> getResponseList(@Query("email") String email);
}
