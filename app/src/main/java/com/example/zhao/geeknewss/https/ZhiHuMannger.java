package com.example.zhao.geeknewss.https;

import com.example.zhao.geeknewss.beans.zhihu.DailyListBean;

import io.reactivex.Observable;

public class ZhiHuMannger {
    private static ZhiHuServer myServer;

    public static ZhiHuServer getMyServer() {
        if (myServer == null) {
            synchronized (ZhiHuMannger.class) {
                if (myServer == null) {
                    myServer = HttpManager.getHttpUtils().getServer(ZhiHuServer.HOST, ZhiHuServer.class);
                }
            }
        }
        return myServer;
    }

    public Observable<DailyListBean> getDailyListBean() {
        return myServer.getDailyList();
    }
}
