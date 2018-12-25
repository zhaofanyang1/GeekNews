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
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.zhao.geeknewss.R;
import com.example.zhao.geeknewss.beans.zhihu.SectionListBean;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

public class SectionAdapter extends XRecyclerView.Adapter<SectionAdapter.SectionHolder> {
    private List<SectionListBean.DataBean> list;
    private Context context;

    public SectionAdapter(List<SectionListBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public SectionHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SectionHolder(LayoutInflater.from(context).inflate(R.layout.item_section, null));
    }

    @Override
    public void onBindViewHolder(@NonNull SectionHolder holder, int position) {
        SectionListBean.DataBean dataBean = list.get(position);
        holder.description.setText(dataBean.getDescription());
        holder.name.setText(dataBean.getName());
        RequestOptions override = RequestOptions.bitmapTransform(new RoundedCorners(60)).override(300, 600);
        Glide.with(context).load(dataBean.getThumbnail()).apply(override).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class SectionHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView image;
        TextView description;

        public SectionHolder(View itemView) {
            super(itemView);
            description = itemView.findViewById(R.id.id_sertion_description);
            image = itemView.findViewById(R.id.id_sertion_image);
            name = itemView.findViewById(R.id.id_sertion_name);
        }
    }
}
