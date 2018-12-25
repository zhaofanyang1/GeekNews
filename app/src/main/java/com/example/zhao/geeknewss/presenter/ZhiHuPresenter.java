package com.example.zhao.geeknewss.presenter;

import com.example.zhao.geeknewss.Request;
import com.example.zhao.geeknewss.base.presenter.IBasepresenter;
import com.example.zhao.geeknewss.beans.zhihu.DailyListBean;
import com.example.zhao.geeknewss.beans.zhihu.HotListBean;
import com.example.zhao.geeknewss.beans.zhihu.SectionListBean;
import com.example.zhao.geeknewss.beans.zhihu.weichat.WeiChatBean;
import com.example.zhao.geeknewss.modle.ZhiHuModuld;
import com.example.zhao.geeknewss.view.MyView;

public class ZhiHuPresenter<V extends MyView> extends IBasepresenter<V> implements ZhiHuModuld.ZhihuCallback {

    private ZhiHuModuld Moduld = new ZhiHuModuld();


    public void getDailyListBean() {
        //v1是弱引用对象
        if (v1 != null) {
            Moduld.getDailyListBean(this);
        }
    }

    public void getData(Request request) {
        if (v1 != null) {
            Moduld.getData(this, request);
        }
    }

    @Override
    public void setShowDailyListBean(Object o) {
        if (v1 != null) {
            DailyListBean dailyListBean = (DailyListBean) o;
            v1.showScuess(dailyListBean);
        }
    }

    @Override
    public void setShow(Object o, final Request request) {
        if (v1 != null) {
            switch (request) {
                case SECTION:
                    SectionListBean sectionListBean = (SectionListBean) o;
                    v1.showScuess(sectionListBean);
                    break;
                case HOT:
                    HotListBean hotListBean = (HotListBean) o;
                    v1.showScuess(hotListBean);
                    break;

            }

        }
    }


    @Override
    public void setError(String error) {
        if (v1 != null) {
            v1.showError(error);
        }
    }

    @Override
    public void setshowProgressBar() {
        if (v1 != null) {
            v1.showProgressBar();
        }
    }

    @Override
    public void sethideProgressBar() {
        if (v1 != null) {
            v1.HideProgressBar();
        }
    }


}
