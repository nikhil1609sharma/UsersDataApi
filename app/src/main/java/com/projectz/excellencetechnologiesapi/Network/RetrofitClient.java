package com.projectz.excellencetechnologiesapi.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit retrofit;
    private static final String BASE_URL = "https://reqres.in/";
    private static RetrofitClient retrofitClient;

    private RetrofitClient(){
        retrofit = new  Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public static RetrofitClient getInstance(){
        if (retrofitClient==null){
            retrofitClient = new RetrofitClient();
        }
        return retrofitClient;
    }
    public Api getApi(){
        return retrofit.create(Api.class);
    }
}
