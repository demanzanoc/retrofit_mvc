package com.example.retrofit_mvp.model.interactor;

import com.example.retrofit_mvp.interfaces.MainActivityInteractor;
import com.example.retrofit_mvp.interfaces.MainActivityPresenter;
import com.example.retrofit_mvp.model.entities.User;
import com.example.retrofit_mvp.rest.ApiAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class MainActivityInteractorImpl implements MainActivityInteractor, Callback<List<User>> {

    private StringBuilder data;
    private MainActivityPresenter presenter;

    public MainActivityInteractorImpl(MainActivityPresenter presenter) {
        this.presenter = presenter;
        data = new StringBuilder();
    }

    @Override
    public void getDataUser() {
        Call<List<User>> call = ApiAdapter.getJsonPlaceHolderApi().getPosts();
        call.enqueue(this);
    }

    @EverythingIsNonNull
    @Override
    public void onResponse(Call<List<User>> call, Response<List<User>> response) {
        if (!response.isSuccessful()) {
            //enviamos respuesta de error a view
            presenter.showErrorMessage("Codigo: " + response.code());
            return;
        }
        List<User> postsList = response.body();
        if (postsList != null) {
            for (User post : postsList) {
                data.append("userId: ").append(post.getUserId()).append("\n");
                data.append("id: ").append(post.getId()).append("\n");
                data.append("title: ").append(post.getTitle()).append("\n");
                data.append("body: ").append(post.getBody()).append("\n\n");
            }
            //enviamos respuesta con data a view
            presenter.showPosts(data);
        } else {
            presenter.showErrorMessage("Codigo: " + response.code());
        }
    }

    @EverythingIsNonNull
    @Override
    public void onFailure(Call<List<User>> call, Throwable t) {
        //enviamos respuesta de fallo a view
        presenter.showErrorMessage("Error: " + t.getMessage());
    }

}
