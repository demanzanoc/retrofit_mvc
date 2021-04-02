package com.example.retrofit_mvp.interfaces;

import com.example.retrofit_mvp.interactors.MainActivityInteractorImpl;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MainActivityInteractor {

    int getUserId();
    int getId();
    String getTitle();
    String getBody();
    void getDataUser();

}
