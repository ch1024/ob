package com.example.woox.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.bumptech.glide.Glide;
import com.example.woox.R;
import com.example.woox.bean.BanBean;

import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;

import java.util.ArrayList;

public class TwoAdapter extends DelegateAdapter.Adapter {
    private LayoutHelper layoutHelper;
    private Context context;
    private ArrayList<BanBean.DataBean.BannerBean> mBan;
    public TwoAdapter(LayoutHelper layoutHelper, Context context,ArrayList<BanBean.DataBean.BannerBean> mBan) {
        this.layoutHelper = layoutHelper;
        this.context = context;
        this.mBan=mBan;
    }
    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return layoutHelper;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.ban, parent, false);
        return new Vhtwo(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Vhtwo vh= (Vhtwo) holder;
        vh.banner.setAdapter(new BannerImageAdapter<BanBean.DataBean.BannerBean>(mBan) {
            @Override
            public void onBindView(BannerImageHolder holder, BanBean.DataBean.BannerBean data, int position, int size) {
                Glide.with(context).load(data.getImage_url()).into(holder.imageView);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (mBan.size()>0){
            return 1;
        }else {
            return 0;
        }
    }
    class Vhtwo extends RecyclerView.ViewHolder{
        Banner banner;
        public Vhtwo(@NonNull View itemView) {
            super(itemView);
            banner=itemView.findViewById(R.id.two_ban);
        }
    }
}
