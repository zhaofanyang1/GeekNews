package com.example.zhao.geeknewss;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


import com.example.zhao.geeknewss.fragments.gank.GankFragment;
import com.example.zhao.geeknewss.fragments.shujuzhihui.ShuJuZhiHuiFragment;
import com.example.zhao.geeknewss.fragments.shujuzhihui.ZhihuiFragment;
import com.example.zhao.geeknewss.fragments.v2ex.V2EXFragment;
import com.example.zhao.geeknewss.fragments.weichat.WeiCharFragment;
import com.example.zhao.geeknewss.fragments.zhihu.ZhihuMainFragment;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private MenuItem menuItem;
    private MenuItem searchMenuItem;
    public static MaterialSearchView viewSearch;
    private NavigationView viewNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewNavigationView = (NavigationView) findViewById(R.id.nav_view);
        DrawerLayout layoutDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        viewSearch = findViewById(R.id.view_search);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        menuItem = navigationView.getMenu().findItem(R.id.nav_camera);
        menuItem.setCheckable(true);

        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        MenuItem item = menu.findItem(R.id.action_settings);
        if (menuItem.getItemId() == R.id.nav_camera) {
            item.setVisible(true);
        } else {
            item.setVisible(false);
        }

        //关联toolbar的搜索按钮
        viewSearch.setMenuItem(item);
        searchMenuItem = item;
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
            toolbar.setTitle("知乎日报");
            fragmentTransaction.replace(R.id.fl_content, new ZhihuMainFragment()).commit();
        } else if (id == R.id.nav_gallery) {
            toolbar.setTitle("微信精选");
            fragmentTransaction.replace(R.id.fl_content, new WeiCharFragment()).commit();
        } else if (id == R.id.nav_slideshow) {
            toolbar.setTitle("干活集中营");
            fragmentTransaction.replace(R.id.fl_content, new GankFragment()).commit();
        } else if (id == R.id.nav_manage) {
            toolbar.setTitle("数据智汇");
            fragmentTransaction.replace(R.id.fl_content, new ZhihuiFragment()).commit();
        } else if (id == R.id.nav_v2ex) {
            toolbar.setTitle("V2EX");
            fragmentTransaction.replace(R.id.fl_content, new V2EXFragment()).commit();
        } else if (id == R.id.nav_collecting) {
            Toast.makeText(this, "收藏", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_set) {
            Toast.makeText(this, "设置", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_about) {
            Toast.makeText(this, "关于", Toast.LENGTH_SHORT).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
