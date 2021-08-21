package com.minda.erouteassignment.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static final String BaseURL="https://gorest.co.in/public-api/";


    private static RetrofitClient retrofitClient;
    private Retrofit retrofit;
    private RetrofitClient(){
        retrofit=new Retrofit.Builder()
                .baseUrl(BaseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public static synchronized RetrofitClient getInstance(){
        if (retrofitClient==null){
            retrofitClient=new RetrofitClient();
        }
        return retrofitClient;
    }
    public ApiInterface getApi(){
        return retrofit.create(ApiInterface.class);
    }
}
