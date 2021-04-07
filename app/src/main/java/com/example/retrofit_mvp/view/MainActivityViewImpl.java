package com.example.retrofit_mvp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.retrofit_mvp.R;
import com.example.retrofit_mvp.interfaces.MainActivityPresenter;
import com.example.retrofit_mvp.interfaces.MainActivityView;
import com.example.retrofit_mvp.presenter.MainActivityPresenterImpl;

public class MainActivityViewImpl extends AppCompatActivity implements MainActivityView {

    TextView tvData;
    private MainActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvData = findViewById(R.id.tvData);
        presenter = new MainActivityPresenterImpl(this);
        getData();
    }

    @Override
    public void getData() {
        presenter.getDataUser();
    }

    @Override
    public void showPosts(StringBuilder data) {
        tvData.setText(data);
    }

    @Override
    public void showErrorMessage(String message) {
        Toast.makeText(this, "" + message, Toast.LENGTH_LONG).show();
    }
}