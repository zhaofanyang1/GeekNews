package com.example.zhao.geeknewss.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.zhao.geeknewss.R;
import com.example.zhao.geeknewss.base.activity.BaseActivity;
import com.example.zhao.geeknewss.beans.zhihu.DailyListBean;
import com.example.zhao.geeknewss.presenter.ZhiHuPresenter;
import com.example.zhao.geeknewss.view.ZhiHuView;

public class ZhihuActivity extends BaseActivity<ZhiHuView, ZhiHuPresenter<ZhiHuView>> implements ZhiHuView {


    @Override
    protected void initData() {
        presenter.getDailyListBean();
    }

    @Override
    public int createlayoutId() {
        return R.layout.activity_main2;
    }

    @Override
    protected ZhiHuPresenter<ZhiHuView> createPresenter() {
        return new ZhiHuPresenter<>();
    }

    @Override
    public void showDailyListBean(DailyListBean dailyListBean) {
        Log.e("ZhihuActivity", "dailyListBean:" + dailyListBean);
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void HideProgressBar() {

    }
}
