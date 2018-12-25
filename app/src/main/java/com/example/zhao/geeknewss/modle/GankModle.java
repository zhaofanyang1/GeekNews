package com.example.zhao.geeknewss.modle;

import com.example.zhao.geeknewss.Request;
import com.example.zhao.geeknewss.base.modle.HttpFinishCallback;
import com.example.zhao.geeknewss.beans.zhihu.gank.AndroidBean;
import com.example.zhao.geeknewss.beans.zhihu.gank.FuLiBean;
import com.example.zhao.geeknewss.beans.zhihu.gank.IosBean;
import com.example.zhao.geeknewss.beans.zhihu.gank.QianDuanBean;
import com.example.zhao.geeknewss.https.ApiManager;
import com.example.zhao.geeknewss.https.BaseObserver;
import com.example.zhao.geeknewss.utils.RxUtils;

public class GankModle {
    public interface GankCallback<T> extends HttpFinishCallback {
        void setShowGank(T t, Request request);
    }

    public void getData(final GankCallback gankCallback, final Request request, int page) {
        switch (request) {
            case ANDROIDBEAN:
                gankCallback.setshowProgressBar();
                ApiManager.getGankServer().getAndroidBean("" + page, "zfy").compose(RxUtils.<AndroidBean>rxObserableSchedulerHelper()).subscribe(new BaseObserver<AndroidBean>(gankCallback) {
                    @Override
                    public void onNext(AndroidBean value) {
                        gankCallback.setShowGank(value, request);
                    }
                });
                break;
            case IOSBEAN:
                gankCallback.setshowProgressBar();
                ApiManager.getGankServer().getIosBean("" + page, "zfy").compose(RxUtils.<IosBean>rxObserableSchedulerHelper()).subscribe(new BaseObserver<IosBean>(gankCallback) {
                    @Override
                    public void onNext(IosBean value) {
                        gankCallback.setShowGank(value, request);
                    }
                });
                break;
            case QIANDUANBEAN:
                gankCallback.setshowProgressBar();
                ApiManager.getGankServer().getQianDuanBean("" + page, "zfy").compose(RxUtils.<QianDuanBean>rxObserableSchedulerHelper()).subscribe(new BaseObserver<QianDuanBean>(gankCallback) {
                    @Override
                    public void onNext(QianDuanBean value) {
                        gankCallback.setShowGank(value, request);
                    }
                });
                break;
            case FULIBEAN:
                gankCallback.setshowProgressBar();
                ApiManager.getGankServer().getFuLiBean("" + page, "zfy").compose(RxUtils.<FuLiBean>rxObserableSchedulerHelper()).subscribe(new BaseObserver<FuLiBean>(gankCallback) {
                    @Override
                    public void onNext(FuLiBean value) {
                        gankCallback.setShowGank(value, request);
                    }
                });
                break;


        }
    }

}
