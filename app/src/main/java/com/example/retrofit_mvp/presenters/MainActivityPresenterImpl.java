package com.example.retrofit_mvp.presenters;

import com.example.retrofit_mvp.interactors.MainActivityInteractorImpl;
import com.example.retrofit_mvp.interfaces.MainActivityInteractor;
import com.example.retrofit_mvp.interfaces.MainActivityPresenter;
import com.example.retrofit_mvp.interfaces.MainActivityView;
import com.example.retrofit_mvp.views.MainActivityViewImpl;

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
    public void getData() {;
    }

    @Override
    public int getUserId() {
        return 0;
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public String getBody() {
        return null;
    }

    @Override
    public void getDataUser() {
        interactor.getDataUser();
    }
}
