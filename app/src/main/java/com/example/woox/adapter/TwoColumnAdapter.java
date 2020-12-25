package com.example.woox.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.bumptech.glide.Glide;
import com.example.woox.R;
import com.example.woox.bean.BanBean;

import java.util.ArrayList;

public class TwoColumnAdapter extends DelegateAdapter.Adapter {
    private Context context;
    private LayoutHelper layoutHelper;
    private ArrayList<BanBean.DataBean.ChannelBean>  channe;

    public TwoColumnAdapter(Context context, LayoutHelper layoutHelper, ArrayList<BanBean.DataBean.ChannelBean> channe) {
        this.context = context;
        this.layoutHelper = layoutHelper;
        this.channe = channe;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return layoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.column, parent, false);
        return new VhTwoColum(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VhTwoColum vhTwoColum= (VhTwoColum) holder;
        BanBean.DataBean.ChannelBean channelBean = channe.get(position);
        vhTwoColum.name.setText(channelBean.getName());
        Glide.with(context).load(channelBean.getIcon_url()).into(vhTwoColum.img);
    }

    @Override
    public int getItemCount() {
        if (channe.size()>0){
            return channe.size();
        }else {
            return 0;
        }
    }
    class VhTwoColum extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name;
        public VhTwoColum(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.column_img);
            name=itemView.findViewById(R.id.column_name);
        }
    }
}
