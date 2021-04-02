package com.example.retrofit_mvp.interfaces;

public interface MainActivityPresenter {

    void showPosts(StringBuilder data);

    void getData();

    int getUserId();

    int getId();

    String getTitle();

    String getBody();

    void getDataUser();

}
