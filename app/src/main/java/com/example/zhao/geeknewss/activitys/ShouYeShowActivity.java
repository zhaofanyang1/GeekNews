package com.example.zhao.geeknewss.activitys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.zhao.geeknewss.R;
import com.example.zhao.geeknewss.adapters.shujuadapter.ShouAdapter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShouYeShowActivity extends AppCompatActivity {

    @BindView(R.id.toolbar_id)
    Toolbar toolbarId;
    @BindView(R.id.xy)
    RecyclerView xy;
    @BindView(R.id.sc_gold_manager_switch)
    SwitchCompat scGoldManagerSwitch;
    private Toolbar mToolbarId;
    private RecyclerView mXy;
    private List<String> list = new ArrayList<>();
    private ShouAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.NoTheme);
        setContentView(R.layout.activity_shou_ye_show);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        mToolbarId = findViewById(R.id.toolbar_id);
        setSupportActionBar(mToolbarId);
        mToolbarId.setTitle("首页特别展示");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mXy = findViewById(R.id.xy);
        //初始化EventBus,注册
        EventBus.getDefault().register(this);
        mToolbarId.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void receiveMessage(List<String> json) {
        list.addAll(json);
        mXy.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ShouAdapter(list, this);
        mXy.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
