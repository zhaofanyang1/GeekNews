package com.example.zhao.geeknewss.fragments.gank;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.zhao.geeknewss.R;
import com.example.zhao.geeknewss.Request;
import com.example.zhao.geeknewss.adapters.gankadapter.FuliAdapter;
import com.example.zhao.geeknewss.base.fragment.BaseFragment;
import com.example.zhao.geeknewss.beans.zhihu.gank.FuLiBean;
import com.example.zhao.geeknewss.presenter.GankPresenter;
import com.example.zhao.geeknewss.view.MyView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class FuliFragment extends BaseFragment<MyView, GankPresenter<MyView>> implements MyView, XRecyclerView.LoadingListener {


    @BindView(R.id.id_gank_fuli)
    XRecyclerView idGankFuli;
    Unbinder unbinder;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    private List<FuLiBean.ResultsBean> list = new ArrayList<>();
    private FuliAdapter adapter;
    private int page = 1;

    public FuliFragment() {
        // Required empty public constructor
    }

    @Override
    protected GankPresenter<MyView> createPresenter() {
        return new GankPresenter<>();
    }

    @Override
    protected void initData() {
        adapter = new FuliAdapter(list, mActivity);
        idGankFuli.setAdapter(adapter);
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        DividerItemDecoration decoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        idGankFuli.addItemDecoration(decoration);
        idGankFuli.setLayoutManager(manager);
        idGankFuli.setLoadingListener(this);
        presenter.getGank(Request.FULIBEAN, page);
    }

    @Override
    public int createLayoutId() {
        return R.layout.fragment_fuli;
    }


    @Override
    public void showScuess(Object o) {
        FuLiBean fuLiBean = (FuLiBean) o;
        list.addAll(fuLiBean.getResults());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showError(String error) {
        Log.e("FuliFragment", error);
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

    @Override
    public void onRefresh() {
        idGankFuli.refreshComplete();
    }

    @Override
    public void onLoadMore() {
        page++;
        presenter.getGank(Request.FULIBEAN, page);
        idGankFuli.loadMoreComplete();

    }


}
