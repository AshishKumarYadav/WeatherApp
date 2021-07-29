package com.ashish.transo.Network;

import com.ashish.transo.Pojo.ForecastResponseModel;
import com.ashish.transo.Pojo.ResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("current?access_key=b0fe1fd23db02f74286965d6ffad1cbb")
    Call<ResponseModel> getCurrentData(@Query("query") String query);

    @GET("forecast?access_key=b0fe1fd23db02f74286965d6ffad1cbb")
    Call<ForecastResponseModel> getForCastData(@Query("query") String query,@Query("forecast_days") int forecast_days);



}
