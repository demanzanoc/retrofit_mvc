package com.example.retrofit_mvp.interfaces;

public interface MainActivityView {

    void showPosts(StringBuilder data);

    void showErrorMessage(String message);

    void getData();

}
