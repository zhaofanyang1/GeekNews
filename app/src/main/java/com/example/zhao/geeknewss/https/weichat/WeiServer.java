package com.example.zhao.geeknewss.https.weichat;

import com.example.zhao.geeknewss.beans.zhihu.weichat.WeiChatBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface WeiServer {
    String URL = "http://api.tianapi.com/";
    //wxnew/?key=52b7ec3471ac3bec6846577e79f20e4c&num=10&page=1
    @GET("wxnew")
    Observable<WeiChatBean> getWeiXin(@QueryMap Map<String, Object> map);
}
