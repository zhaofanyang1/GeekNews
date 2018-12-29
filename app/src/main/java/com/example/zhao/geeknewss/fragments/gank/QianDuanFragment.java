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
import com.example.zhao.geeknewss.adapters.gankadapter.QianduanAdapter;
import com.example.zhao.geeknewss.base.fragment.BaseFragment;
import com.example.zhao.geeknewss.beans.zhihu.gank.QianDuanBean;
import com.example.zhao.geeknewss.presenter.GankPresenter;
import com.example.zhao.geeknewss.view.MyView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class QianDuanFragment extends BaseFragment<MyView, GankPresenter<MyView>> implements MyView, XRecyclerView.LoadingListener {
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
    private int page = 1;
    private QianduanAdapter qianduanAdapter;
    private List<QianDuanBean.ResultsBean> list3 = new ArrayList<>();

    @Override
    protected GankPresenter<MyView> createPresenter() {
        return new GankPresenter<>();
    }

    @Override
    protected void initData() {
        qianduanAdapter = new QianduanAdapter(list3, mActivity);
        idGankXy.setAdapter(qianduanAdapter);
        idGankXy.setLayoutManager(new LinearLayoutManager(mActivity));
        idGankXy.setLoadingListener(this);

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            load();
        }
    }

    /*
     *
     * TODO需要就加载
     * */
    public void load() {
        presenter.getGank(Request.QIANDUANBEAN, page);
    }

    @Override
    public int createLayoutId() {
        return R.layout.fragment_qianduan;
    }

    @Override
    public void showScuess(Object o) {
        QianDuanBean qianDuanBean = (QianDuanBean) o;
        list3.addAll(qianDuanBean.getResults());
        qianduanAdapter.notifyDataSetChanged();

    }

    @Override
    public void showError(String error) {
        Log.e("QianDuanFragment", error);
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
        idGankXy.refreshComplete();
    }

    @Override
    public void onLoadMore() {
        page++;
        presenter.getGank(Request.ANDROIDBEAN, page);
        idGankXy.loadMoreComplete();
    }
}
