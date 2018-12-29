package com.example.zhao.geeknewss.adapters.weichatadapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.zhao.geeknewss.R;
import com.example.zhao.geeknewss.beans.zhihu.weichat.WeiChatBean;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

public class WeiChatAdapter extends XRecyclerView.Adapter<WeiChatAdapter.ViewHolder> {
    private List<WeiChatBean.NewslistBean> list;
    private Context context;

    public WeiChatAdapter(List<WeiChatBean.NewslistBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_weichat, null));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final WeiChatBean.NewslistBean newslistBean = list.get(position);
        holder.title.setText(newslistBean.getTitle());
        holder.ctime.setText(newslistBean.getCtime());
        holder.description.setText(newslistBean.getDescription());
        Glide.with(context).load(newslistBean.getPicUrl()).into(holder.image);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (OnclickListener != null) {
                    OnclickListener.OnClickListener(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title;
        TextView description;
        TextView ctime;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.iv_weichat_item_image);
            title = itemView.findViewById(R.id.tv_weichat_item_title);
            description = itemView.findViewById(R.id.tv_weichat_item_description);
            ctime = itemView.findViewById(R.id.tv_weichat_item_ctime);
        }
    }

    public OnClickListener OnclickListener;

    public void setOnclickListener(OnClickListener onclickListener) {
        OnclickListener = onclickListener;
    }

    public interface OnClickListener {
        void OnClickListener(int position);
    }
}
