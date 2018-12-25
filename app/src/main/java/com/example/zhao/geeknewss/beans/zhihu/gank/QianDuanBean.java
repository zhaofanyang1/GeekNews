package com.example.zhao.geeknewss.beans.zhihu.gank;

import java.util.List;

public class QianDuanBean {

    /**
     * error : false
     * results : [{"_id":"5beadb859d21223ddba8ca0d","createdAt":"2018-11-13T14:11:17.147Z","desc":"web前端之\u201c神秘\u201d的跨域方式","publishedAt":"2018-11-28T00:00:00.0Z","source":"web","type":"前端","url":"https://mp.weixin.qq.com/s/QyXsknimZVFPXP4fZByenw","used":true,"who":"ttdttt"},{"_id":"5bee63b19d21223ddba8ca12","createdAt":"2018-11-16T06:29:05.865Z","desc":"开源、免费、专业、简单的 React.js 在线教程","publishedAt":"2018-11-28T00:00:00.0Z","source":"chrome","type":"前端","url":"https://github.com/huzidaha/react-naive-book","used":true,"who":"ChengZhen"},{"_id":"5bf570f99d21223dd88989fd","createdAt":"2018-11-21T14:51:37.576Z","desc":"两分钟让你知道，前端开发是用Vue.js还是Angular！","publishedAt":"2018-11-28T00:00:00.0Z","source":"web","type":"前端","url":"https://mp.weixin.qq.com/s/CAXxxB1moq9XJfTNh6Wsiw","used":true,"who":"ttdttt"},{"_id":"5bcec94e9d21220315c66400","createdAt":"2018-10-23T07:10:06.23Z","desc":"整理与收集的一些比较优秀github项目，方便自己阅读，顺便分享出来，大家一起学习","publishedAt":"2018-11-06T00:00:00.0Z","source":"web","type":"前端","url":"https://mp.weixin.qq.com/s/jM29svLc1hpamhgntxgdWg","used":true,"who":"ttdttt"},{"_id":"5bdf1a159d21223d7a1b0aaf","createdAt":"2018-11-04T16:11:01.688Z","desc":"从零开发一款小程序项目\u2014\u2014生活全能通！主要学习小程序的整个开发流程、学习小程序组件和API的使用。本项目仅用于学习专用！","publishedAt":"2018-11-06T00:00:00.0Z","source":"web","type":"前端","url":"https://github.com/ChessLuo/LivingTools","used":true,"who":"ChessLuo"},{"_id":"5be042cc9d21223d7a1b0ab2","createdAt":"2018-11-05T13:17:00.409Z","desc":"前后端分离并非仅仅只是一种开发模式，而是一种架构模式（前后端分离架构）。","publishedAt":"2018-11-06T00:00:00.0Z","source":"web","type":"前端","url":"https://mp.weixin.qq.com/s/7B6yKO0Uw0bhjCtL75kSbA","used":true,"who":"ttdttt"},{"_id":"5be1096d9d21223ddba8c9f3","createdAt":"2018-11-06T03:24:29.486Z","desc":"React开发学起来~~这篇主要是入门搭环境的。","publishedAt":"2018-11-06T00:00:00.0Z","source":"web","type":"前端","url":"https://mp.weixin.qq.com/s/oSAwZccQU7S7Iq-BNm7SmA","used":true,"who":"imononoke"},{"_id":"5b8644699d21225d1572595d","createdAt":"2018-09-11T07:20:14.456Z","desc":"一个移动端炫酷的图表库.","images":["https://ww1.sinaimg.cn/large/0073sXn7ly1fv5nqeqibzg30aa0edwjx","https://ww1.sinaimg.cn/large/0073sXn7ly1fv5nqeyw6fg30aa0edgnb","https://ww1.sinaimg.cn/large/0073sXn7ly1fv5nqffwmog30aa0eddiu","https://ww1.sinaimg.cn/large/0073sXn7ly1fv5nqfqtb8g30aa0edn19"],"publishedAt":"2018-09-11T00:00:00.0Z","source":"chrome","type":"前端","url":"https://github.com/antvis/f2","used":true,"who":"lijinshanmx"},{"_id":"5b90d8a59d212206c4385c1f","createdAt":"2018-09-06T07:35:01.44Z","desc":"造个自己的Vue的UI组件库类似Element","publishedAt":"2018-09-11T00:00:00.0Z","source":"web","type":"前端","url":"https://juejin.im/post/5b87b5d46fb9a01a0a4ec3ee","used":true,"who":"liuyangjike"},{"_id":"5b90ef249d212206c4385c21","createdAt":"2018-09-11T07:18:54.188Z","desc":"一个404页面.","images":["https://ww1.sinaimg.cn/large/0073sXn7ly1fv5nqz2utag30m80goth8","https://ww1.sinaimg.cn/large/0073sXn7ly1fv5nr0fxphg30o80bwqv6"],"publishedAt":"2018-09-11T00:00:00.0Z","source":"web","type":"前端","url":"https://github.com/blairlee227/IlluStatus","used":true,"who":"Blair"}]
     */

    private boolean error;
    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * _id : 5beadb859d21223ddba8ca0d
         * createdAt : 2018-11-13T14:11:17.147Z
         * desc : web前端之“神秘”的跨域方式
         * publishedAt : 2018-11-28T00:00:00.0Z
         * source : web
         * type : 前端
         * url : https://mp.weixin.qq.com/s/QyXsknimZVFPXP4fZByenw
         * used : true
         * who : ttdttt
         * images : ["https://ww1.sinaimg.cn/large/0073sXn7ly1fv5nqeqibzg30aa0edwjx","https://ww1.sinaimg.cn/large/0073sXn7ly1fv5nqeyw6fg30aa0edgnb","https://ww1.sinaimg.cn/large/0073sXn7ly1fv5nqffwmog30aa0eddiu","https://ww1.sinaimg.cn/large/0073sXn7ly1fv5nqfqtb8g30aa0edn19"]
         */

        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
        private String who;
        private List<String> images;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }
}
