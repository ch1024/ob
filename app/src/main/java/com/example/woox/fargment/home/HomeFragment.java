package com.example.woox.fargment.home;

import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.mvp.base.BaseFragment;
import com.example.woox.R;
import com.example.woox.adapter.OneAdapter;
import com.example.woox.adapter.TwoAdapter;
import com.example.woox.bean.BanBean;
import com.example.woox.constart.Contract;
import com.example.woox.presenter.HomePresenter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends BaseFragment<HomePresenter> implements Contract.HomeView {

    private RecyclerView big_rec;
    private VirtualLayoutManager layoutManager;
    private OneAdapter singleadapter;
    private ArrayList<BanBean.DataBean.BannerBean> mBan;
    private TwoAdapter twoleadapter;

    @Override
    protected int setView() {
        return R.layout.home_farg;
    }

    @Override
    protected void initView(View view) {
        big_rec = view.findViewById(R.id.big_rec);
        //ban
        mBan = new ArrayList<>();
    }

    @Override
    protected HomePresenter getPresenter() {
        return new HomePresenter();
    }

    @Override
    protected void initData() {
        //设置最大布局管理
        layoutManager = new VirtualLayoutManager(getActivity());
        big_rec.setLayoutManager(layoutManager);
        //头部
        singleGet();
        //banner
        mBanner();
        
        addAdapter();
        presenter.getBan();
    }

    private void mBanner() {
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        singleLayoutHelper.setItemCount(1);
        twoleadapter = new TwoAdapter(singleLayoutHelper, getActivity(),mBan);
    }

    private void addAdapter() {
        DelegateAdapter adapter = new DelegateAdapter(layoutManager, true);
        adapter.addAdapter(singleadapter);
        adapter.addAdapter(twoleadapter);

        big_rec.setLayoutManager(layoutManager);
        big_rec.setAdapter(adapter);
    }

    private void singleGet() {
        //通栏布局
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        singleLayoutHelper.setItemCount(1);
        singleadapter = new OneAdapter(singleLayoutHelper, getActivity());
    }

    @Override
    public void onSSon(BanBean banBean) {
        Log.d("111",banBean.toString());
        if (banBean!=null){
            List<BanBean.DataBean.BannerBean> beans = banBean.getData().getBanner();
            mBan.addAll(beans);
            twoleadapter.notifyDataSetChanged();
        }
    }
}
