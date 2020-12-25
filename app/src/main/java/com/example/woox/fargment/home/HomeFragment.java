package com.example.woox.fargment.home;

import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.ColumnLayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.mvp.base.BaseFragment;
import com.example.woox.R;
import com.example.woox.adapter.FiveAdapter;
import com.example.woox.adapter.OneAdapter;
import com.example.woox.adapter.ForeAdapter;
import com.example.woox.adapter.ThreeAdapter;
import com.example.woox.adapter.TwoAdapter;
import com.example.woox.adapter.TwoColumnAdapter;
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
    private ArrayList<BanBean.DataBean.BrandListBean> mBrand;
    private ForeAdapter foreAdapter;
    private ArrayList<BanBean.DataBean.ChannelBean> mChanne;
    private TwoColumnAdapter twoColumnAdapter;
    private ThreeAdapter threeAdapter;
    private FiveAdapter fiveAdapter;

    //网格上面文字
    @Override
    protected int setView() {
        return R.layout.home_farg;
    }

    @Override
    protected void initView(View view) {
        big_rec = view.findViewById(R.id.big_rec);
        //ban
        mBan = new ArrayList<>();
        //网格
        mBrand = new ArrayList<>();
        //ban下面那个
        mChanne = new ArrayList<>();

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
        //第二个(一行多个那个)
        twoLiner();
        //第三个品牌一行
        threen();
        //第四个
        mGrild();
        //第五个
        mFive();
        addAdapter();
        presenter.getBan();
    }

    private void mFive() {
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        singleLayoutHelper.setItemCount(1);
        singleLayoutHelper.setAspectRatio(6);
        fiveAdapter = new FiveAdapter(getActivity(), singleLayoutHelper, mBrand);
    }

    private void twoLiner() {
        ColumnLayoutHelper columnLayoutHelper = new ColumnLayoutHelper();
//        columnLayoutHelper.setWeights(new float[]{20,20,20,20,20});
//        columnLayoutHelper.setAspectRatio(2);
        columnLayoutHelper.setMargin(10,10,10,10);
        twoColumnAdapter = new TwoColumnAdapter(getActivity(), columnLayoutHelper, mChanne);
    }

    private void threen() {
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        singleLayoutHelper.setItemCount(1);
        singleLayoutHelper.setAspectRatio(6);
        singleLayoutHelper.setMarginTop(6);
        threeAdapter = new ThreeAdapter(getActivity(),singleLayoutHelper,mChanne);
    }

    private void mGrild() {
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(2);
        gridLayoutHelper.setAutoExpand(true);
        foreAdapter = new ForeAdapter(gridLayoutHelper, getActivity(), mBrand);
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
        adapter.addAdapter(twoColumnAdapter);
        adapter.addAdapter(threeAdapter);
        adapter.addAdapter(foreAdapter);
        adapter.addAdapter(fiveAdapter);
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

            List<BanBean.DataBean.ChannelBean> channel = banBean.getData().getChannel();
            mChanne.addAll(channel);
            twoColumnAdapter.notifyDataSetChanged();

            threeAdapter.notifyDataSetChanged();

            List<BanBean.DataBean.BrandListBean> brandList = banBean.getData().getBrandList();
            mBrand.addAll(brandList);
            foreAdapter.notifyDataSetChanged();

            fiveAdapter.notifyDataSetChanged();



        }
    }
}
