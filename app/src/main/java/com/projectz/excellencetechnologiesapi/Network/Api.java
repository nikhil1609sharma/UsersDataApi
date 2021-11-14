package com.projectz.excellencetechnologiesapi.Network;

import com.projectz.excellencetechnologiesapi.Model.UserModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    @GET("api/users")
    Call<UserModel>getUserData(
            @Query("page") String page
    );


}
