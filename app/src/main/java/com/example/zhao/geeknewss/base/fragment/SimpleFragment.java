package com.example.zhao.geeknewss.base.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.zip.Inflater;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class SimpleFragment extends Fragment {

    public Activity mActivity;
    public Context contex;
    private Unbinder bind;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (Activity) context;
        this.contex = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(createLayoutId(), null);
        bind = ButterKnife.bind(this, view);
        initData();
        return view;
    }

    //懒加载

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

    }

    protected abstract void initData();

    public abstract int createLayoutId();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (bind != null) {
            bind.unbind();
            bind = null;
        }

    }
}
