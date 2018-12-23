package com.example.zhao.geeknewss.modle;

import com.example.zhao.geeknewss.base.modle.HttpFinishCallback;
import com.example.zhao.geeknewss.beans.zhihu.DailyListBean;
import com.example.zhao.geeknewss.https.BaseObserver;
import com.example.zhao.geeknewss.https.ZhiHuMannger;
import com.example.zhao.geeknewss.utils.RxUtils;

public class ZhiHuModuld {
    public interface ZhihuCallback extends HttpFinishCallback {
        void setDailyListBean(DailyListBean dailyListBean);
    }

    public void getDailyListBean(final ZhihuCallback zhihuCallback) {
        ZhiHuMannger.getMyServer().getDailyList()
                .compose(RxUtils
                        .<DailyListBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<DailyListBean>(zhihuCallback) {
                    @Override
                    public void onNext(DailyListBean value) {
                        zhihuCallback.setDailyListBean(value);
                    }
                });
    }
}
