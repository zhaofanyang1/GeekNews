package com.example.zhao.geeknewss.adapters.shujuadapter;

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
import com.example.zhao.geeknewss.beans.zhihu.juhe.JuHeBean;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

public class ShujuAdapter extends XRecyclerView.Adapter<ShujuAdapter.ViewHolder> {
    private List<JuHeBean.RESULTBean.NewsListBean> list;
    private Context context;

    public ShujuAdapter(List<JuHeBean.RESULTBean.NewsListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_shuju, null));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        JuHeBean.RESULTBean.NewsListBean listBean = list.get(position);
        holder.title.setText(listBean.getTitle());
        holder.source.setText(listBean.getSource());
        if (listBean.getNewsImg().contains("https")) {
            Glide.with(context).load(listBean.getNewsImg()).into(holder.images);
        } else {
            Glide.with(context).load("https:" + listBean.getNewsImg()).into(holder.images);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView images;
        TextView title;
        TextView source;

        public ViewHolder(View itemView) {
            super(itemView);
            images = itemView.findViewById(R.id.id_shju_image);
            title = itemView.findViewById(R.id.id_shju_title);
            source = itemView.findViewById(R.id.id_shju_source);
        }
    }
}
