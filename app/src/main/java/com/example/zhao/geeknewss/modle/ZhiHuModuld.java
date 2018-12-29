package com.example.zhao.geeknewss.modle;

import android.util.Log;

import com.example.zhao.geeknewss.Request;
import com.example.zhao.geeknewss.base.modle.HttpFinishCallback;
import com.example.zhao.geeknewss.beans.zhihu.DailyListBean;
import com.example.zhao.geeknewss.beans.zhihu.HotListBean;
import com.example.zhao.geeknewss.beans.zhihu.SectionChildListBean;
import com.example.zhao.geeknewss.beans.zhihu.SectionListBean;
import com.example.zhao.geeknewss.beans.zhihu.weichat.WeiChatBean;
import com.example.zhao.geeknewss.https.BaseObserver;
import com.example.zhao.geeknewss.https.ApiManager;
import com.example.zhao.geeknewss.utils.RxUtils;

import java.util.HashMap;
import java.util.Map;

public class ZhiHuModuld {
    public interface ZhihuCallback<T> extends HttpFinishCallback {
        void setShowDailyListBean(T t);

        void setShow(T t, Request request);
    }

    public void getDailyListBean(final ZhihuCallback zhihuCallback) {
        zhihuCallback.setshowProgressBar();
        ApiManager.getMyServer().getDailyList()
                .compose(RxUtils.<DailyListBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<DailyListBean>(zhihuCallback) {
                    @Override
                    public void onNext(DailyListBean value) {
                        zhihuCallback.setShowDailyListBean(value);
                    }
                });
    }

    public void getData(final ZhihuCallback zhihuCallback, final Request request, Map<String, Object> map, int id) {
        switch (request) {
            case SECTION:
                zhihuCallback.setshowProgressBar();
                ApiManager.getMyServer().getSectionList().compose(RxUtils.<SectionListBean>rxObserableSchedulerHelper()).subscribe(new BaseObserver<SectionListBean>(zhihuCallback) {
                    @Override
                    public void onNext(SectionListBean value) {
                        zhihuCallback.setShow(value, request);
                    }
                });
                break;
            case SECTIONChILDLIST:
                Log.e("ZhiHuModuld", "123");
                zhihuCallback.setshowProgressBar();
                ApiManager.getMyServers().getSectionChildList(id).compose(RxUtils.<SectionChildListBean>rxObserableSchedulerHelper()).subscribe(new BaseObserver<SectionChildListBean>(zhihuCallback) {
                    @Override
                    public void onNext(SectionChildListBean value) {
                        Log.e("ZhiHuModuld", "456");
                        Log.e("ZhiHuModuld", "value:" + value);
                        zhihuCallback.setShow(value, request);
                    }
                });
                break;

            case HOT:
                zhihuCallback.setshowProgressBar();
                ApiManager.getMyServer().getHotList().compose(RxUtils.<HotListBean>rxObserableSchedulerHelper()).subscribe(new BaseObserver<HotListBean>(zhihuCallback) {
                    @Override
                    public void onNext(HotListBean value) {
                        zhihuCallback.setShow(value, request);
                    }
                });
                break;

        }
    }
}
