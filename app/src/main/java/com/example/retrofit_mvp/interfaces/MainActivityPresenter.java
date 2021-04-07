package com.example.retrofit_mvp.interfaces;

public interface MainActivityPresenter {

    void showPosts(StringBuilder data);

    void showErrorMessage(String message);

    void getDataUser();

}
