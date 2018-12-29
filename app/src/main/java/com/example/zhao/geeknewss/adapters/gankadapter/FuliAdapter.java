package com.example.zhao.geeknewss.adapters.gankadapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.zhao.geeknewss.R;
import com.example.zhao.geeknewss.beans.zhihu.gank.AndroidBean;
import com.example.zhao.geeknewss.beans.zhihu.gank.FuLiBean;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

public class FuliAdapter extends XRecyclerView.Adapter<FuliAdapter.ViewHolder> {
    private List<FuLiBean.ResultsBean> list;
    private Context context;

    public FuliAdapter(List<FuLiBean.ResultsBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public FuliAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FuliAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_fuli, null));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FuLiBean.ResultsBean resultsBean = list.get(position);
        Glide.with(context).load(resultsBean.getUrl()).into(holder.images);
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView images;

        public ViewHolder(View itemView) {
            super(itemView);
            images = itemView.findViewById(R.id.iv_fuli_image);
        }
    }
}

