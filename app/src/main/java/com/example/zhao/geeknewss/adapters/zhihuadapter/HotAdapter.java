package com.example.zhao.geeknewss.adapters.zhihuadapter;

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
import com.example.zhao.geeknewss.beans.zhihu.HotListBean;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

public class HotAdapter extends XRecyclerView.Adapter<HotAdapter.HotViewHolder> {
    private List<HotListBean.RecentBean> list;
    private Context context;

    public HotAdapter(List<HotListBean.RecentBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public HotViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HotViewHolder(LayoutInflater.from(context).inflate(R.layout.item_hot, null));
    }

    @Override
    public void onBindViewHolder(@NonNull HotViewHolder holder, int position) {
        holder.title.setText(list.get(position).getTitle());
        Glide.with(context).load(list.get(position).getThumbnail()).into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class HotViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView thumbnail;


        public HotViewHolder(View itemView) {
            super(itemView);
            thumbnail = itemView.findViewById(R.id.iv_hot_item_image);
            title = itemView.findViewById(R.id.tv_hot_item_title);
        }
    }
}
