package com.example.zhao.geeknewss.presenter;

import com.example.zhao.geeknewss.Request;
import com.example.zhao.geeknewss.base.presenter.IBasepresenter;
import com.example.zhao.geeknewss.beans.zhihu.juhe.JuHeBean;
import com.example.zhao.geeknewss.beans.zhihu.juhe.JuHeTop;
import com.example.zhao.geeknewss.modle.JuHeModle;
import com.example.zhao.geeknewss.view.MyView;

import java.util.Map;

public class JuHePresenter<V extends MyView> extends IBasepresenter<V> implements JuHeModle.JuHeCallback {

    JuHeModle juHeModle = new JuHeModle();

    public void getJuheData(Map<String, Object> map, Request request, int page) {
        if (v1 != null) {
            juHeModle.getData(this, map, request, page);
        }
    }

    @Override
    public void setJuhe(Object o, Request request, int page) {
        if (v1 != null) {
            switch (request) {
                case JUHETOP:
                    JuHeTop juHeTop = (JuHeTop) o;
                    v1.showScuess(juHeTop);
                    break;
                case JUHESHUJU:
                    JuHeBean juHeBean = (JuHeBean) o;
                    v1.showScuess(juHeBean);
                    break;
            }
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
}
