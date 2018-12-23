package com.example.zhao.geeknewss.base.activity;

import com.example.zhao.geeknewss.base.presenter.BasePresenter;

public abstract class BaseActivity<V, P extends BasePresenter<V>> extends SimpleActivity {

    public P presenter;

    @Override
    public void viewCreate() {
        super.viewCreate();
        presenter = createPresenter();
        if (presenter != null) {
            presenter.bingView((V) this);
        }
    }

    protected abstract P createPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.destoryView();
            presenter = null;
        }
    }
}
