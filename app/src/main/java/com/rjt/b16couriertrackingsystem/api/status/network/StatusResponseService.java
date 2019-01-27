package com.rjt.b16couriertrackingsystem.api.status.network;

import com.rjt.b16couriertrackingsystem.api.module.StatusResponse;
import com.rjt.b16couriertrackingsystem.api.module.StatusResponseList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface StatusResponseService {

    @GET("shipment_status_all.php?")
    Call<StatusResponseList> getResponseList(@Query("email") String email);

    @GET("shipment_status_vendor.php?")
    Call<StatusResponseList> getResponseVendor(@Query("email") String email,
                                               @Query("vendor") String vendor);

    @GET("shipment_status_tracknumber.php?")
    Call<StatusResponseList> getResponseNumber(@Query("email") String email,
                                               @Query("tracknumber") String tracknumber);

    @GET("shipment_status_tome.php?")
    Call<StatusResponseList> getResponseToMe(@Query("email") String email,
                                             @Query("tome") String tome);

    @GET("shipment_status_fromme.php?")
    Call<StatusResponseList> getResponseFromMe(@Query("email") String email,
                                               @Query("fromme") String fromme);

    @GET("shipment_status_watchlist.php?")
    Call<StatusResponseList> getReponseWatchList(@Query("email") String email,
                                            @Query("watchlist") String list);
}
