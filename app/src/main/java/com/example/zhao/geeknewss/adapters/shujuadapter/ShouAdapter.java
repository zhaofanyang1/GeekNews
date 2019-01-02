package com.example.zhao.geeknewss.adapters.shujuadapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.zhao.geeknewss.R;
import com.example.zhao.geeknewss.beans.zhihu.juhe.GoldManagerItemBean;

import java.util.List;

import butterknife.BindView;

public class ShouAdapter extends RecyclerView.Adapter<ShouAdapter.ViewHolder> {
    private List<String> list;
    private Context context;

    public ShouAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_shouyeshow, null));
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
       /* holder.tvType.setText(list.get(position).getIndex());
        holder.scSwitch.setChecked(list.get(position).getIsSelect());*/
        String s = list.get(position);
        holder.tvType.setText(s);
        holder.scSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                list.get(holder.getAdapterPosition());

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvType;
        SwitchCompat scSwitch;

        public ViewHolder(View itemView) {
            super(itemView);
            tvType = itemView.findViewById(R.id.tv_gold_manager_type);
            scSwitch = itemView.findViewById(R.id.sc_gold_manager_switch);
        }
    }
}
