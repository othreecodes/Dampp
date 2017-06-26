package com.davidmadethis.dampp.http;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by root on 6/20/17.
 */

public interface DamppService {

    @Headers("Content-Type: application/json")
    @POST("user/login/")
    Call<JsonObject> login(@Body String json);

    @Headers("Content-Type: application/json")
    @GET("user/matches/")
    Call<Object> matches(@Header("authorization") String Token);

    @Headers("Content-Type: application/json")
    @GET("user/suggestions/")
    Call<Object> suggestions(@Header("authorization") String Token);

    @Headers("Content-Type: application/json")
    @POST("user/create/")
    Call<JsonObject> register(@Body String json);


}
