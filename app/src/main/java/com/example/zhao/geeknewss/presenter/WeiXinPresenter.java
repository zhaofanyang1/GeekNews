package com.example.zhao.geeknewss.presenter;

import com.example.zhao.geeknewss.Request;
import com.example.zhao.geeknewss.base.presenter.IBasepresenter;
import com.example.zhao.geeknewss.beans.zhihu.weichat.WeiChatBean;
import com.example.zhao.geeknewss.modle.WeixinModule;
import com.example.zhao.geeknewss.view.MyView;

public class WeiXinPresenter<V extends MyView> extends IBasepresenter<V> implements WeixinModule.WeixinCallback {

    WeixinModule weixinModule = new WeixinModule();

    public void getWeiChatBean(Request request, int page) {
        //v1是弱引用对象
        if (v1 != null) {
            weixinModule.getData(this, request, page);
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

    @Override
    public void setError(String error) {
        if (v1 != null) {
            v1.showError(error);
        }
    }

    @Override
    public void setShowWeiChatBean(Object o, Request request) {
        switch (request) {
            case WEICHAT:
                WeiChatBean weiChatBean = (WeiChatBean) o;
                v1.showScuess(weiChatBean);
                break;
        }
    }
}
