package com.example.zhao.geeknewss.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.zhao.geeknewss.R;

public class WebViewActivity extends AppCompatActivity {
//使用toolbar需继承AppCompatActivity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
    }
}
