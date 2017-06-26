package com.davidmadethis.dampp.http;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by root on 6/20/17.
 */

public class Http {
    //TODO: i'll Change this once I've moved the app to heroku
    public static final String API_URL = "https://dampp.herokuapp.com/api/v1/";
//    public static final String API_URL = "http://10.0.23.1/api/v1/";

    public Http() {

    }

    public Call<JsonObject> login(String json) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        DamppService api = retrofit.create(DamppService.class);
        return api.login(json);

    }

    public Call<Object> match(String token) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        DamppService api = retrofit.create(DamppService.class);
        return api.matches(token);

    }

    public Call<Object> suggestions(String token) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        DamppService api = retrofit.create(DamppService.class);
        return api.suggestions(token);

    }

    public Call<JsonObject> register(String body) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        DamppService api = retrofit.create(DamppService.class);
        return api.register(body);

    }

}
