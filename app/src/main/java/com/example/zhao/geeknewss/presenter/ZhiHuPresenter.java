package com.example.zhao.geeknewss.presenter;

import android.support.v7.view.menu.MenuView;

import com.example.zhao.geeknewss.base.presenter.IBasepresenter;
import com.example.zhao.geeknewss.beans.zhihu.DailyListBean;
import com.example.zhao.geeknewss.modle.ZhiHuModuld;
import com.example.zhao.geeknewss.view.ZhiHuView;

public class ZhiHuPresenter<V extends ZhiHuView> extends IBasepresenter<V> implements ZhiHuModuld.ZhihuCallback {

    private ZhiHuModuld zhiHuModuld = new ZhiHuModuld();


    public void getDailyListBean() {
        //v1是弱引用对象
        if (v1 != null) {
            zhiHuModuld.getDailyListBean(this);
        }
    }


    @Override
    public void setDailyListBean(DailyListBean dailyListBean) {

        if (v1 != null) {
            v1.showDailyListBean(dailyListBean);
        }
    }

    @Override
    public void setError(String error) {
        if (v1 != null) {
            v1.showError(error);
        }
    }

    @Override
    public void setshowProgressBar() {

    }

    @Override
    public void sethideProgressBar() {

    }

}
