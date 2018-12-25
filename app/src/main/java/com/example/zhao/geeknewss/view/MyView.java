package com.example.zhao.geeknewss.view;

import android.util.Log;

import com.example.zhao.geeknewss.base.view.BaseView;
import com.example.zhao.geeknewss.beans.zhihu.DailyListBean;

public interface MyView<T> extends BaseView {
    void showScuess(T t);

    void showError(String error);
}
