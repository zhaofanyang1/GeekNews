package com.example.zhao.geeknewss.https.gank;

import com.example.zhao.geeknewss.beans.zhihu.gank.AndroidBean;
import com.example.zhao.geeknewss.beans.zhihu.gank.FuLiBean;
import com.example.zhao.geeknewss.beans.zhihu.gank.IosBean;
import com.example.zhao.geeknewss.beans.zhihu.gank.QianDuanBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface GankServer {
    //https://gank.io/api/data/Android/10/1
    //https://gank.io/api/data/iOS/10/1
    //https://gank.io/api/data/前端/10/1
    //https://gank.io/api/data/福利/10/1
    String URl = "https://gank.io/api/data/";

    @GET("Android/10/{page}")
    Observable<AndroidBean> getAndroidBean(@Path("page") String page1, @Header("User-Agent") String head);

    @GET("iOS/10/{page}")
    Observable<IosBean> getIosBean(@Path("page") String page2, @Header("User-Agent") String head);

    @GET("前端/10/{page}")
    Observable<QianDuanBean> getQianDuanBean(@Path("page") String page3, @Header("User-Agent") String head);

    @GET("福利/10/{page}")
    Observable<FuLiBean> getFuLiBean(@Path("page") String page4, @Header("User-Agent") String head);

}
