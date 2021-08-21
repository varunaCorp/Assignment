package com.minda.erouteassignment.viewmodel;

import com.minda.erouteassignment.api.ApiInterface;
import com.minda.erouteassignment.api.RetrofitClient;
import com.minda.erouteassignment.model.User;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class UserViewModel extends ViewModel {

    private MutableLiveData<User> users;


    public LiveData<User> getUser(){
       if(users ==null){
           users = new MutableLiveData<User>();
           getUserFromApi();

       }
       return users;

    }

private void getUserFromApi(){
        ApiInterface apiInterface = RetrofitClient.getInstance().getApi();
        Call<User> call = apiInterface.getUsers();
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response!=null){
                    users.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });

}

}
