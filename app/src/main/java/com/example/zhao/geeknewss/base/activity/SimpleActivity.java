package com.example.zhao.geeknewss.base.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class SimpleActivity extends AppCompatActivity {

    private Unbinder bind;
    private Activity mactivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(createlayoutId());
        bind = ButterKnife.bind(this);
        mactivity = this;
        viewCreate();
        initData();
    }

    public void viewCreate() {

    }

    protected abstract void initData();

    public abstract int createlayoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (bind != null) {
            bind.unbind();
        }
    }
}
