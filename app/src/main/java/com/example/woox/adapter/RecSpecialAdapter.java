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

public class RecSpecialAdapter extends RecyclerView.Adapter {
    Context context;
    ArrayList<BanBean.DataBean.TopicListBean> listBeans;

    public RecSpecialAdapter(Context context, ArrayList<BanBean.DataBean.TopicListBean> listBeans) {
        this.context = context;
        this.listBeans = listBeans;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.special_item, parent, false);
        return new VhReSp(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VhReSp vhReSp= (VhReSp) holder;
        BanBean.DataBean.TopicListBean topicListBean = listBeans.get(position);
        vhReSp.name.setText(topicListBean.getTitle());
        vhReSp.price.setText("￥"+topicListBean.getPrice_info()+"起");
        vhReSp.jiex.setText(topicListBean.getSubtitle());
        Glide.with(context).load(topicListBean.getItem_pic_url()).into(vhReSp.img);
    }

    @Override
    public int getItemCount() {
        if (listBeans.size()>0){
            return listBeans.size();
        }else {
            return 0;
        }
    }
    class VhReSp extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name;
        TextView price;
        TextView jiex;
        public VhReSp(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.special_item_img);
            name=itemView.findViewById(R.id.special_item_name);
            price=itemView.findViewById(R.id.special_item_price);
            jiex=itemView.findViewById(R.id.special_item_jiex);

        }
    }
}
