package com.example.zhao.geeknewss.fragments.gank;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.zhao.geeknewss.R;
import com.example.zhao.geeknewss.base.fragment.BaseFragment;
import com.example.zhao.geeknewss.beans.zhihu.gank.AndroidBean;
import com.example.zhao.geeknewss.presenter.GankPresenter;
import com.example.zhao.geeknewss.view.MyView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ANDROIDFragment extends BaseFragment<MyView, GankPresenter<MyView>> implements MyView {


    @BindView(R.id.id_gank_xy)
    XRecyclerView idGankXy;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    Unbinder unbinder;

    public ANDROIDFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public ANDROIDFragment(String title) {

    }

    @Override
    protected void initData() {

    }

    @Override
    public int createLayoutId() {
        return R.layout.fragment_android;
    }

    @Override
    protected GankPresenter<MyView> createPresenter() {
        return new GankPresenter<>();
    }

    @Override
    public void showScuess(Object o) {
        AndroidBean androidBean = (AndroidBean) o;

    }

    @Override
    public void showError(String error) {
        Log.e("ANDROIDFragment", error);
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void HideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
