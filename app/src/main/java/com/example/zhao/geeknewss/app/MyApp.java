package com.example.zhao.geeknewss.app;

import android.app.Application;

import com.example.zhao.geeknewss.https.HttpManager;
import com.example.zhao.geeknewss.https.zhihu.MyServer;
import com.example.zhao.geeknewss.utils.ImplPreferencesHelper;
import com.example.zhao.geeknewss.view.MyView;

public class MyApp extends Application {
    private static MyApp instance;
    private static ImplPreferencesHelper implPreferencesHelper;
    private static MyServer myServer;
    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;

    }

    public static synchronized MyApp getInstance() {
        return instance;
    }

    public static ImplPreferencesHelper getImplPreferencesHelper(){
        if (implPreferencesHelper == null) {
            synchronized (ImplPreferencesHelper.class){
                if (implPreferencesHelper == null) {
                    implPreferencesHelper=new ImplPreferencesHelper();
                }
            }
        }
        return implPreferencesHelper;
    }

    /**
     * 获取知乎网络请求Api
     * @return
     */
    public static MyServer getZhihuServer(){
        if (myServer == null) {
            synchronized (MyView.class){
                if (myServer == null) {
                    myServer = HttpManager.getHttpUtils().getServer(MyServer.HOST, MyServer.class);
                }
            }
        }
        return myServer;
    }
}
