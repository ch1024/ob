package com.example.woox.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.example.woox.R;

public class OneAdapter extends DelegateAdapter.Adapter {
    private LayoutHelper layoutHelper;
    private Context context;

    public OneAdapter(LayoutHelper layoutHelper, Context context) {
        this.layoutHelper = layoutHelper;
        this.context = context;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return layoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search, parent, false);
        return new Vh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 1;
    }
    class Vh extends RecyclerView.ViewHolder {
        LinearLayout linearLayout;
        TextView search_soutex;
        public Vh(@NonNull View itemView) {
            super(itemView);
            linearLayout=itemView.findViewById(R.id.search_liner);
            search_soutex=itemView.findViewById(R.id.search_soutex);
        }
    }
}
