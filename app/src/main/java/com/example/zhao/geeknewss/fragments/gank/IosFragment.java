package com.example.zhao.geeknewss.fragments.gank;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.zhao.geeknewss.R;
import com.example.zhao.geeknewss.Request;
import com.example.zhao.geeknewss.adapters.gankadapter.IosAdapter;
import com.example.zhao.geeknewss.base.fragment.BaseFragment;
import com.example.zhao.geeknewss.beans.zhihu.gank.IosBean;
import com.example.zhao.geeknewss.presenter.GankPresenter;
import com.example.zhao.geeknewss.view.MyView;
import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class IosFragment extends BaseFragment<MyView, GankPresenter<MyView>> implements MyView, XRecyclerView.LoadingListener {

    @BindView(R.id.iv_tech_blur)
    ImageView ivTechBlur;
    @BindView(R.id.tv_tech_copyright)
    TextView tvTechCopyright;
    @BindView(R.id.tech_appbar)
    AppBarLayout techAppbar;
    @BindView(R.id.idGankXy)
    XRecyclerView idGankXy;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefresh;
    Unbinder unbinder;
    private List<IosBean.ResultsBean> list = new ArrayList<>();
    private IosAdapter iosAdapter;
    private int page = 1;

    @Override
    protected GankPresenter<MyView> createPresenter() {
        return new GankPresenter<>();
    }

    @Override
    protected void initData() {
        iosAdapter = new IosAdapter(list, mActivity);
        idGankXy.setAdapter(iosAdapter);
        idGankXy.setLayoutManager(new LinearLayoutManager(mActivity));
        idGankXy.setLoadingListener(this);
        presenter.getGank(Request.IOSBEAN, page);
    }
    @Override
    public int createLayoutId() {
        return R.layout.fragment_ios;
    }

    @Override
    public void showScuess(Object o) {
        IosBean iosBean = (IosBean) o;
        if (iosBean.getResults() != null) {
            list.addAll(iosBean.getResults());
        }
        iosAdapter.notifyDataSetChanged();
    }

    @Override
    public void showError(String error) {
        Log.e("IosFragment", error);
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
    public void onRefresh() {
        idGankXy.refreshComplete();
    }

    @Override
    public void onLoadMore() {
        page++;
        presenter.getGank(Request.ANDROIDBEAN, page);
        idGankXy.loadMoreComplete();
    }
}
