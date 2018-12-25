package com.example.zhao.geeknewss.presenter;

import com.example.zhao.geeknewss.Request;
import com.example.zhao.geeknewss.base.presenter.IBasepresenter;
import com.example.zhao.geeknewss.beans.zhihu.gank.AndroidBean;
import com.example.zhao.geeknewss.beans.zhihu.gank.FuLiBean;
import com.example.zhao.geeknewss.beans.zhihu.gank.IosBean;
import com.example.zhao.geeknewss.beans.zhihu.gank.QianDuanBean;
import com.example.zhao.geeknewss.modle.GankModle;
import com.example.zhao.geeknewss.view.MyView;

public class GankPresenter<V extends MyView> extends IBasepresenter<V> implements GankModle.GankCallback {
    GankModle gankModle = new GankModle();

    public void getGank(Request request, int page) {
        if (v1 != null) {
            gankModle.getData(this, request, page);
        }
    }

    @Override
    public void setShowGank(Object o, Request request) {
        switch (request) {
            case ANDROIDBEAN:
                AndroidBean androidBean = (AndroidBean) o;
                v1.showScuess(androidBean);
                break;
            case IOSBEAN:
                IosBean iosBean = (IosBean) o;
                v1.showScuess(iosBean);
                break;
            case FULIBEAN:
                FuLiBean fuLiBean = (FuLiBean) o;
                v1.showScuess(fuLiBean);
                break;
            case QIANDUANBEAN:
                QianDuanBean qianDuanBean = (QianDuanBean) o;
                v1.showScuess(qianDuanBean);
                break;
        }
    }

    @Override
    public void setshowProgressBar() {
        if (v1 != null) {
            v1.showProgressBar();
        }
    }

    @Override
    public void sethideProgressBar() {
        if (v1 != null) {
            v1.HideProgressBar();
        }
    }

    @Override
    public void setError(String error) {
        if (v1 != null) {
            v1.showError(error);
        }
    }
}
