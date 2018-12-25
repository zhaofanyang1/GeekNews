package com.example.zhao.geeknewss.base.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.example.zhao.geeknewss.base.presenter.BasePresenter;

public abstract class BaseFragment<V, P extends BasePresenter<V>> extends SimpleFragment {

    public P presenter;

    @Override
    public void oncreateview() {
        super.oncreateview();
        presenter = createPresenter();
        if (presenter != null) {
            presenter.bingView((V) this);
        }
    }

    protected abstract P createPresenter();
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.destoryView();
            presenter = null;
        }
    }
}
