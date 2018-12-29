package com.example.zhao.geeknewss.https;

import com.example.zhao.geeknewss.https.gank.GankServer;
import com.example.zhao.geeknewss.https.shju.ShuJuServer;
import com.example.zhao.geeknewss.https.weichat.WeiServer;
import com.example.zhao.geeknewss.https.zhihu.MyServer;

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
     * 获取知乎专栏详情Api接口对象
     *
     * @return
     */
    private static MyServer server;

    public static MyServer getMyServers() {
        if (server == null) {
            synchronized (ApiManager.class) {
                if (server == null) {
                    server = HttpManager.getHttpUtils().getServer(MyServer.HOSTS, MyServer.class);
                }
            }
        }
        return server;
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
            synchronized (GankServer.class) {
                if (gankServer == null) {
                    gankServer = HttpManager.getHttpUtils().getServer(GankServer.URl, GankServer.class);
                }
            }
        }
        return gankServer;
    }

    /**
     * 获取聚合数据Api接口对象
     *
     * @return
     */
    private static ShuJuServer shuJuServer;

    public static ShuJuServer getShuJuServer() {
        if (shuJuServer == null) {
            synchronized (ApiManager.class) {
                if (shuJuServer == null) {
                    shuJuServer = HttpManager.getHttpUtils().getServer(ShuJuServer.JuheUrl, ShuJuServer.class);
                }
            }
        }
        return shuJuServer;
    }
}
