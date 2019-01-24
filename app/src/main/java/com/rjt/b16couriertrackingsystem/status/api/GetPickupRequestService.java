package com.rjt.b16couriertrackingsystem.status.api;

import com.rjt.b16couriertrackingsystem.countrylist.model.CountriesList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetPickupRequestService {
    @GET("pickup_req.php?")
    Call<ResponseBody> getRequest(@Query("packagename") String packagename,
                                  @Query("pickupaddress") String pickupaddress,
                                  @Query("deliveryaddress") String deliveryaddress,
                                  @Query("pickuptime") String pickuptime,
                                  @Query("email") String email);
}
