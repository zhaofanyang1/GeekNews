package com.example.zhao.geeknewss.https.shju;

import com.example.zhao.geeknewss.beans.zhihu.juhe.JuHeBean;
import com.example.zhao.geeknewss.beans.zhihu.juhe.JuHeTop;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface ShuJuServer {

    String JuheUrl = "http://api.shujuzhihui.cn/api/news/";

    //http://api.shujuzhihui.cn/api/news/categories?appKey=60e42866bea54eaca68bbcdcb9bc2729
    @GET
    Observable<JuHeTop> getjuhetop(@Url String url, @QueryMap Map<String, Object> map);

    //http://api.shujuzhihui.cn/api/news/list?appKey=60e42866bea54eaca68bbcdcb9bc2729&category=%E8%A6%81%E9%97%BB
    @GET
    Observable<JuHeBean> getjuheshju(@Url String url, @QueryMap Map<String, Object> map);
}
