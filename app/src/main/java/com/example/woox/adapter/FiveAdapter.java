package com.example.woox.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.example.woox.R;
import com.example.woox.bean.BanBean;

import java.util.ArrayList;

public class FiveAdapter extends DelegateAdapter.Adapter {
    Context context;
    LayoutHelper layoutHelper;
    //上一个集合
    ArrayList<BanBean.DataBean.BrandListBean> mBrand;
    public FiveAdapter(Context context, LayoutHelper layoutHelper, ArrayList<BanBean.DataBean.BrandListBean> mBrand) {
        this.context = context;
        this.layoutHelper = layoutHelper;
        this.mBrand=mBrand;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return layoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.week_text, parent, false);
        return new VhFive(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VhFive vhFive= (VhFive) holder;
        vhFive.tex.setText("周一周四·新品首发");

    }

    @Override
    public int getItemCount() {
        if (mBrand.size()>0){
            return 1;
        }else {
            return 0;
        }
    }
    class VhFive extends RecyclerView.ViewHolder {
        TextView tex;
        public VhFive(@NonNull View itemView) {
            super(itemView);
            tex=itemView.findViewById(R.id.week_tex);
        }
    }
}
