package com.example.zhao.geeknewss.fragments.gank;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zhao.geeknewss.R;
import com.example.zhao.geeknewss.base.fragment.BaseFragment;
import com.example.zhao.geeknewss.base.presenter.IBasepresenter;
import com.example.zhao.geeknewss.view.MyView;

/**
 * A simple {@link Fragment} subclass.
 */
public class FuliFragment extends BaseFragment<MyView, IBasepresenter<MyView>> implements MyView {


    public FuliFragment() {
        // Required empty public constructor
    }

    @Override
    protected void initData() {

    }

    @Override
    public int createLayoutId() {
        return R.layout.fragment_fuli;
    }

    @Override
    protected IBasepresenter<MyView> createPresenter() {
        return null;
    }

    @Override
    public void showScuess(Object o) {

    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void HideProgressBar() {

    }
}
