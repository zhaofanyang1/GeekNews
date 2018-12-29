package com.example.zhao.geeknewss.fragments.shujuzhihui;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zhao.geeknewss.R;
import com.example.zhao.geeknewss.Request;
import com.example.zhao.geeknewss.adapters.gankadapter.V_Adapter;
import com.example.zhao.geeknewss.base.fragment.BaseFragment;
import com.example.zhao.geeknewss.beans.zhihu.juhe.JuHeTop;
import com.example.zhao.geeknewss.presenter.JuHePresenter;
import com.example.zhao.geeknewss.view.MyView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class ZhihuiFragment extends BaseFragment<MyView, JuHePresenter<MyView>> implements MyView {


    @BindView(R.id.id_juhe_tab)
    TabLayout idJuheTab;
    @BindView(R.id.id_viewpager)
    ViewPager idViewpager;
    Unbinder unbinder;
    private int page;
    private List<Fragment> fs = new ArrayList<>();
    private V_Adapter adapter;
    private List<String> result;

    @Override
    protected JuHePresenter<MyView> createPresenter() {
        return new JuHePresenter<>();
    }

    @Override
    public void showScuess(Object o) {
        JuHeTop juHeTop = (JuHeTop) o;
        result = juHeTop.getRESULT();
        for (int i = 0; i < result.size(); i++) {
            fs.add(new ShuJuZhiHuiFragment(result.get(i)));
        }
        adapter = new V_Adapter(getChildFragmentManager(), fs, result);
        idViewpager.setAdapter(adapter);
        idJuheTab.setupWithViewPager(idViewpager);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void initData() {
        Map<String, Object> map = new HashMap<>();
        map.put("appKey", "60e42866bea54eaca68bbcdcb9bc2729");
        presenter.getJuheData(map, Request.JUHETOP, page);
    }

    @Override
    public int createLayoutId() {
        return R.layout.fragment_zhihui;
    }


    @Override
    public void showError(String error) {
        Log.e("ZhihuiFragment", error);
    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void HideProgressBar() {

    }

}
