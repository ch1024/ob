package com.example.woox.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.bumptech.glide.Glide;
import com.example.woox.R;
import com.example.woox.bean.BanBean;

import java.util.ArrayList;

public class ForeAdapter extends DelegateAdapter.Adapter {
    private LayoutHelper layoutHelper;
    private Context context;
    private ArrayList<BanBean.DataBean.BrandListBean> mBrand;

    public ForeAdapter(LayoutHelper layoutHelper, Context context, ArrayList<BanBean.DataBean.BrandListBean> mBrand) {
        this.layoutHelper = layoutHelper;
        this.context = context;
        this.mBrand = mBrand;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return layoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.grild, parent, false);
        return new VhThree(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VhThree vhThree= (VhThree) holder;
        BanBean.DataBean.BrandListBean bean = mBrand.get(position);
        vhThree.name.setText(bean.getName());
        vhThree.price.setText(bean.getFloor_price()+"元起");
        Glide.with(context).load(bean.getNew_pic_url()).into(vhThree.img);
    }

    @Override
    public int getItemCount() {
        if (mBrand.size()>0){
            return mBrand.size();
        }else {
            return 0;
        }
    }
    class VhThree extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name;
        TextView price;
        public VhThree(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.grild_img_back);
            name=itemView.findViewById(R.id.grild_one_name);
            price=itemView.findViewById(R.id.grild_one_price);
        }
    }
}
