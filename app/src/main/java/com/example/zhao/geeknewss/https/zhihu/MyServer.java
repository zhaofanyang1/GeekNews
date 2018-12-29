package com.example.zhao.geeknewss.https.zhihu;

import com.example.zhao.geeknewss.beans.zhihu.DailyListBean;
import com.example.zhao.geeknewss.beans.zhihu.HotListBean;
import com.example.zhao.geeknewss.beans.zhihu.SectionChildListBean;
import com.example.zhao.geeknewss.beans.zhihu.SectionListBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;


public interface MyServer {
    String HOST = "http://news-at.zhihu.com/api/4/";
    String HOSTS = "https://news-at.zhihu.com/api/4/";

    //http://news-at.zhihu.com/api/4/
    //https://news-at.zhihu.com/api/4/section/34
    //https://news-at.zhihu.com/api/4/section/0
    /**
     * 启动界面图片
     */
//    @GET("start-image/{res}")
//    Observable<WelcomeBean> getWelcomeInfo(@Path("res") String res);

    /**
     * 最新日报DailyListBean
     */
    @GET("news/latest")
    Observable<DailyListBean> getDailyList();

    /**
     * 往期日报DailyBeforeListBean
     */
    @GET("news/before/{date}")
    Observable<String> getDailyBeforeList(@Path("date") String date);

    /**
     * 主题日报ThemeListBean
     */
    @GET("themes")
    Observable<String> getThemeList();

    /**
     * 主题日报详情ThemeChildListBean
     */
    @GET("theme/{id}")
    Observable<String> getThemeChildList(@Path("id") int id);

    /**
     * 专栏日报SectionListBean
     */
    @GET("sections")
    Observable<SectionListBean> getSectionList();

    /**
     * 专栏日报详情SectionChildListBean
     */
    @GET("section/{id}")
    Observable<SectionChildListBean> getSectionChildList(@Path("id") int id);

    /**
     * 热门日报HotListBean
     */
    @GET("news/hot")
    Observable<HotListBean> getHotList();

    /**
     * 日报详情ZhihuDetailBean
     */
    @GET("news/{id}")
    Observable<String> getDetailInfo(@Path("id") int id);

    /**
     * 日报的额外信息DetailExtraBean
     */
    @GET("story-extra/{id}")
    Observable<String> getDetailExtraInfo(@Path("id") int id);

    /**
     * 日报的长评论CommentBean
     */
    @GET("story/{id}/long-comments")
    Observable<String> getLongCommentInfo(@Path("id") int id);

    /**
     * 日报的短评论CommentBean
     */
    @GET("story/{id}/short-comments")
    Observable<String> getShortCommentInfo(@Path("id") int id);

}
