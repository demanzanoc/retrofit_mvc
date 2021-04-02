package com.example.retrofit_mvp.interfaces;

import com.example.retrofit_mvp.interactors.MainActivityInteractorImpl;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    @GET("posts")
    Call<List<MainActivityInteractorImpl>> getPosts();

}
