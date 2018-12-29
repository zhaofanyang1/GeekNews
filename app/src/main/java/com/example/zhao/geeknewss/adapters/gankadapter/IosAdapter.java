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
import com.example.zhao.geeknewss.R;
import com.example.zhao.geeknewss.beans.zhihu.gank.AndroidBean;
import com.example.zhao.geeknewss.beans.zhihu.gank.IosBean;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

public class IosAdapter extends XRecyclerView.Adapter<IosAdapter.ViewHolder> {
    private List<IosBean.ResultsBean> list;
    private Context context;

    public IosAdapter(List<IosBean.ResultsBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_android, null));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        IosBean.ResultsBean resultsBean = list.get(position);
        holder.desc.setText(resultsBean.getDesc());
        holder.createdAt.setText(resultsBean.getCreatedAt());
        holder.who.setText(resultsBean.getWho());
        Glide.with(context).load(R.drawable.a).into(holder.images);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView images;
        TextView desc;
        TextView who;
        TextView createdAt;

        public ViewHolder(View itemView) {
            super(itemView);
            images = itemView.findViewById(R.id.iv_android_images);
            desc = itemView.findViewById(R.id.tv_android_item_desc);
            who = itemView.findViewById(R.id.tv_android_item_who);
            createdAt = itemView.findViewById(R.id.tv_android_item_createdAt);
        }
    }
}
