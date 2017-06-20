package com.davidmadethis.dampp.http;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by root on 6/20/17.
 */

public interface DamppService {

    @Headers("Content-Type: application/json")
    @POST("user/login/")
    Call<Object> login(@Body String json);

}
