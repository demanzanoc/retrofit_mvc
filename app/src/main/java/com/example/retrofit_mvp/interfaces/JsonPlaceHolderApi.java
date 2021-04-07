package com.example.retrofit_mvp.interfaces;

import com.example.retrofit_mvp.model.entities.User;
import com.example.retrofit_mvp.rest.Endpoints;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    @GET(Endpoints.GET_DATA)
    Call<List<User>> getPosts();

}
