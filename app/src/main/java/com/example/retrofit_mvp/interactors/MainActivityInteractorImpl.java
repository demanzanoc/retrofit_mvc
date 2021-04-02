package com.example.retrofit_mvp.interactors;

import com.example.retrofit_mvp.interfaces.JsonPlaceHolderApi;
import com.example.retrofit_mvp.interfaces.MainActivityInteractor;
import com.example.retrofit_mvp.interfaces.MainActivityPresenter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivityInteractorImpl implements MainActivityInteractor {

    private int userId;
    private int id;
    private String title;
    private String body;
    private StringBuilder data;
    private MainActivityPresenter presenter;

    public MainActivityInteractorImpl(MainActivityPresenter presenter) {
        this.presenter = presenter;
        data = new StringBuilder();
        userId = 0;
        id = 0;
        title = "";
        body = "";
    }

    @Override
    public int getUserId() {
        return userId;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getBody() {
        return body;
    }

    @Override
    public void getDataUser() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        Call<List<MainActivityInteractorImpl>> call = jsonPlaceHolderApi.getPosts();
        call.enqueue(new Callback<List<MainActivityInteractorImpl>>() {
            @Override
            public void onResponse(Call<List<MainActivityInteractorImpl>> call, Response<List<MainActivityInteractorImpl>> response) {
                if(!response.isSuccessful()){
                    //enviamos respuesta de error a view
                    presenter.showPosts(data.append("Codigo: ").append(response.code()));
                    return;
                }
                List<MainActivityInteractorImpl> postsList = response.body();
                if (postsList != null){
                    for (MainActivityInteractorImpl post: postsList){
                        data.append("userId: ").append(post.getUserId()).append("\n");
                        data.append("id: ").append(post.getId()).append("\n");
                        data.append("title: ").append(post.getTitle()).append("\n");
                        data.append("body: ").append(post.getBody()).append("\n\n");
                    }
                    //enviamos respuesta con data a view
                    presenter.showPosts(data);
                }else{
                    presenter.showPosts(data.append("Codigo: ").append(response.code()));
                }

            }

            @Override
            public void onFailure(Call<List<MainActivityInteractorImpl>> call, Throwable t) {
                //enviamos respuesta de fallo a view
                presenter.showPosts(data.append("Error: ").append(t.getMessage()));
            }
        });
    }
}
