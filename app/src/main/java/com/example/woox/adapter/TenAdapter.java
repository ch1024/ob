package com.example.woox.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.example.woox.R;
import com.example.woox.bean.BanBean;

import java.util.ArrayList;

public class TenAdapter extends DelegateAdapter.Adapter{
    private Context context;
    private LayoutHelper layoutHelper;
    private ArrayList<BanBean.DataBean.TopicListBean> topicList;

    public TenAdapter(Context context, LayoutHelper layoutHelper, ArrayList<BanBean.DataBean.TopicListBean> topicList) {
        this.context = context;
        this.layoutHelper = layoutHelper;
        this.topicList = topicList;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return layoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.special, parent, false);
        return new VhSpecial(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VhSpecial vhSpecial= (VhSpecial) holder;
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        vhSpecial.rec.setLayoutManager(layoutManager);
        RecSpecialAdapter adapter = new RecSpecialAdapter(context, topicList);
        vhSpecial.rec.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        if (topicList.size()>0){
            return 1;
        }else {
            return 0;
        }
    }
    class VhSpecial extends RecyclerView.ViewHolder{
        RecyclerView rec;
        public VhSpecial(@NonNull View itemView) {
            super(itemView);
            rec=itemView.findViewById(R.id.special_rec);
        }
    }
}
