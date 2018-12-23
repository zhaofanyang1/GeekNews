package com.example.zhao.geeknewss.view;

import android.util.Log;

import com.example.zhao.geeknewss.base.view.BaseView;
import com.example.zhao.geeknewss.beans.zhihu.DailyListBean;

public interface ZhiHuView extends BaseView {
    void showDailyListBean(DailyListBean dailyListBean);

    void showError(String error);
}
