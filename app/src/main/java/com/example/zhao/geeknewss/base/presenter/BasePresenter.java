package com.example.zhao.geeknewss.base.presenter;

public interface BasePresenter<V> {
    //绑定视图
    void bingView(V v);

    //解绑视图
    void destoryView();

}
