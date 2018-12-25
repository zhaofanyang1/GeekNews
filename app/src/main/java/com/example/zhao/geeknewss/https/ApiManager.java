package com.example.zhao.geeknewss.https;

import com.example.zhao.geeknewss.https.gank.GankServer;
import com.example.zhao.geeknewss.https.weichat.WeiServer;
import com.example.zhao.geeknewss.https.zhihu.MyServer;
import com.example.zhao.geeknewss.modle.GankModle;

public class ApiManager {
    private static MyServer myServer;

    /**
     * 获取知乎Api接口对象
     *
     * @return
     */
    public static MyServer getMyServer() {
        if (myServer == null) {
            synchronized (ApiManager.class) {
                if (myServer == null) {
                    myServer = HttpManager.getHttpUtils().getServer(MyServer.HOST, MyServer.class);
                }
            }
        }
        return myServer;
    }


    /**
     * 获取微信精选Api接口对象
     *
     * @return
     */
    private static WeiServer weiServer;

    public static WeiServer getWeiServer() {
        if (weiServer == null) {
            synchronized (ApiManager.class) {
                if (weiServer == null) {
                    weiServer = HttpManager.getHttpUtils().getServer(WeiServer.URL, WeiServer.class);
                }
            }
        }
        return weiServer;
    }

    /**
     * 获取干活Api接口对象
     *
     * @return
     */
    private static GankServer gankServer;

    public static GankServer getGankServer() {
        if (gankServer == null) {
            synchronized (ApiManager.class) {
                if (gankServer == null) {
                    gankServer = HttpManager.getHttpUtils().getServer(GankServer.URl, GankServer.class);
                }
            }
        }
        return gankServer;
    }
}
