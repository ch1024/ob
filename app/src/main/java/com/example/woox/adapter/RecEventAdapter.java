package com.example.woox.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.woox.R;
import com.example.woox.bean.BanBean;

import java.util.ArrayList;

public class RecEventAdapter extends RecyclerView.Adapter {
    Context context;
    ArrayList<BanBean.DataBean.CategoryListBean.GoodsListBean> listBeans;

    public RecEventAdapter(Context context, ArrayList<BanBean.DataBean.CategoryListBean.GoodsListBean> listBeans) {
        this.context = context;
        this.listBeans = listBeans;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.event_item, parent, false);
        return new VhReEv(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VhReEv vhReEv= (VhReEv) holder;
        BanBean.DataBean.CategoryListBean.GoodsListBean bean = listBeans.get(position);
        vhReEv.name.setText(bean.getName());
        vhReEv.price.setText("￥"+bean.getRetail_price());
        Glide.with(context).load(bean.getList_pic_url()).into(vhReEv.img);
    }

    @Override
    public int getItemCount() {
        if (listBeans.size()>0){
            return listBeans.size();
        }else {
            return 0;
        }
    }
    class VhReEv extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name;
        TextView price;
        public VhReEv(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.event_item_img);
            name=itemView.findViewById(R.id.event_item_name);
            price=itemView.findViewById(R.id.event_item_price);
        }
    }
}
