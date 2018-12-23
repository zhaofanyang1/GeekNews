package com.example.zhao.geeknewss.base.presenter;

import java.lang.ref.WeakReference;

public class IBasepresenter<V> implements BasePresenter<V> {

    //弱引用
    private WeakReference<V> weakReference;
    public V v1;

    @Override
    public void bingView(V v) {
        weakReference = new WeakReference<V>(v);
        v1 = weakReference.get();
    }

    @Override
    public void destoryView() {
        if (weakReference != null && weakReference.get() != null) {
            weakReference.clear();
            weakReference = null;
        }

    }
}
