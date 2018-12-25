package com.example.zhao.geeknewss.modle;

import com.example.zhao.geeknewss.Request;
import com.example.zhao.geeknewss.base.modle.HttpFinishCallback;
import com.example.zhao.geeknewss.beans.zhihu.HotListBean;
import com.example.zhao.geeknewss.beans.zhihu.SectionListBean;
import com.example.zhao.geeknewss.beans.zhihu.weichat.WeiChatBean;
import com.example.zhao.geeknewss.https.ApiManager;
import com.example.zhao.geeknewss.https.BaseObserver;
import com.example.zhao.geeknewss.utils.RxUtils;

import java.util.HashMap;
import java.util.Map;

public class WeixinModule {
    public interface WeixinCallback<T> extends HttpFinishCallback {
        void setShowWeiChatBean(T t, Request request);
    }

    public void getData(final WeixinCallback weixinCallback,final Request request,int page) {
        switch (request) {
            case WEICHAT:
                weixinCallback.setshowProgressBar();
                Map<String, String> map = new HashMap<>();
                //key=52b7ec3471ac3bec6846577e79f20e4c&num=10&page=1
                map.put("key", "52b7ec3471ac3bec6846577e79f20e4c");
                map.put("num", "10");
                map.put("page", "1" + page);
                ApiManager.getWeiServer().getWeiXin(map).compose(RxUtils.<WeiChatBean>rxObserableSchedulerHelper()).subscribe(new BaseObserver<WeiChatBean>(weixinCallback) {
                    @Override
                    public void onNext(WeiChatBean value) {
                        weixinCallback.setShowWeiChatBean(value, request);
                    }
                });

        }
    }
}
