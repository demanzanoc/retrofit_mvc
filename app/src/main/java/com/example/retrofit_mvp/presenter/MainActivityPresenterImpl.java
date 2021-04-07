package com.example.retrofit_mvp.presenter;

import com.example.retrofit_mvp.model.interactor.MainActivityInteractorImpl;
import com.example.retrofit_mvp.interfaces.MainActivityInteractor;
import com.example.retrofit_mvp.interfaces.MainActivityPresenter;
import com.example.retrofit_mvp.interfaces.MainActivityView;
import com.example.retrofit_mvp.view.MainActivityViewImpl;

public class MainActivityPresenterImpl implements MainActivityPresenter {

    private MainActivityView view;
    private MainActivityInteractor interactor;

    public MainActivityPresenterImpl(MainActivityViewImpl view) {
        this.view = view;
        this.interactor = new MainActivityInteractorImpl (this);
    }

    @Override
    public void showPosts(StringBuilder data) {
        view.showPosts(data);
    }

    @Override
    public void showErrorMessage(String message) {
        view.showErrorMessage(message);
    }

    @Override
    public void getDataUser() {
        interactor.getDataUser();
    }
}
