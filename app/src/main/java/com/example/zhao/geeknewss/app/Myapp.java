package com.example.zhao.geeknewss.app;

import android.app.Application;

public class Myapp extends Application {
    private static Myapp myapp;

    @Override
    public void onCreate() {
        super.onCreate();
        myapp = this;
    }

    public static Myapp getMyapp() {
        return myapp;
    }
}
