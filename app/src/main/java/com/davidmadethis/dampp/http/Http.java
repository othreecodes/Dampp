package com.davidmadethis.dampp.http;

import android.content.Context;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Updated by User on 6/20/17.
 */

public class Http {
    //TODO: i'll Change this once I've moved the app to heroku
    public static final String API_URL = "https://dampp.herokuapp.com/api/v1/";
//    public static final String API_URL = "http://10.0.23.1/api/v1/";

    public Http() {

    }

    public static Retrofit getRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }

    public static DamppService getApiService(){
        Retrofit retrofit = getRetrofit();
        DamppService api = retrofit.create(DamppService.class);
        return api;
    }

    public Call<JsonObject> login(String json) {

        DamppService api = getApiService();
        return api.login(json);
    }

    public Call<Object> match(String token) {
        DamppService api = getApiService();
        return api.matches(token);

    }

    public Call<Object> suggestions(String token) {

        DamppService api = getApiService();
        return api.suggestions(token);
    }

    public Call<JsonObject> register(String body) {

        DamppService api = getApiService();
        return api.register(body);

    }

}
