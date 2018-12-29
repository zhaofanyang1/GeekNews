package com.example.zhao.geeknewss.modle;

import com.example.zhao.geeknewss.Request;
import com.example.zhao.geeknewss.base.modle.HttpFinishCallback;
import com.example.zhao.geeknewss.beans.zhihu.juhe.JuHeBean;
import com.example.zhao.geeknewss.beans.zhihu.juhe.JuHeTop;
import com.example.zhao.geeknewss.https.ApiManager;
import com.example.zhao.geeknewss.https.BaseObserver;
import com.example.zhao.geeknewss.utils.RxUtils;

import java.util.Map;

public class JuHeModle {

    public interface JuHeCallback<T> extends HttpFinishCallback {
        void setJuhe(T t, Request request, int page);
    }

    public void getData(final JuHeCallback juHeCallback, Map<String, Object> map, final Request request, final int page) {
        switch (request) {

            case JUHETOP:
                juHeCallback.setshowProgressBar();
                ApiManager.getShuJuServer().getjuhetop("categories", map)
                        .compose(RxUtils.<JuHeTop>rxObserableSchedulerHelper())
                        .subscribe(new BaseObserver<JuHeTop>(juHeCallback) {
                            @Override
                            public void onNext(JuHeTop value) {
                                juHeCallback.setJuhe(value, request, page);
                            }
                        });
                break; case JUHESHUJU:
                juHeCallback.setshowProgressBar();
                ApiManager.getShuJuServer().getjuheshju("list", map)
                        .compose(RxUtils.<JuHeBean>rxObserableSchedulerHelper())
                        .subscribe(new BaseObserver<JuHeBean>(juHeCallback) {
                            @Override
                            public void onNext(JuHeBean value) {
                                juHeCallback.setJuhe(value, request, page);
                            }
                        });
                break;
        }
    }

}
