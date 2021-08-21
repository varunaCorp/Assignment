package com.minda.erouteassignment.api;

import com.minda.erouteassignment.model.User;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("users")
    Call<User> getUsers();


}
