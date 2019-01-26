package com.rjt.b16couriertrackingsystem.countrylist.network;

import com.rjt.b16couriertrackingsystem.countrylist.model.CountriesList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetCountryListService {

    @GET("country_list.php?")
    Call<CountriesList> getAllCountryList();


}
