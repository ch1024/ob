package com.example.woox.fargment.home;

import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.ColumnLayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.mvp.base.BaseFragment;
import com.example.woox.R;
import com.example.woox.adapter.EightAdapter;
import com.example.woox.adapter.EventAdapter;
import com.example.woox.adapter.FiveAdapter;
import com.example.woox.adapter.OneAdapter;
import com.example.woox.adapter.ForeAdapter;
import com.example.woox.adapter.SixAdapter;
import com.example.woox.adapter.TenAdapter;
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
    private SixAdapter sixAdapter;
    private ArrayList<BanBean.DataBean.NewGoodsListBean> mGoods;
    private ThreeAdapter servenAdapter;
    private ArrayList<BanBean.DataBean.HotGoodsListBean> mHot;
    private EightAdapter eightAdapter;
    private ThreeAdapter nineAdapter;
    private ArrayList<BanBean.DataBean.TopicListBean> mTopic;
    private TenAdapter tenAdapter;
    private ThreeAdapter evenAdapter;
    private ArrayList<BanBean.DataBean.CategoryListBean> mCateg;
    private EventAdapter eventAdapter;

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
        //新品首发
        mGoods = new ArrayList<>();
        //人气推荐
        mHot = new ArrayList<>();
        //专题精选
        mTopic = new ArrayList<>();
        //家具复用
        mCateg = new ArrayList<>();
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
        //第六个
        mSix();
        //第七个复用
        mServen();
        //第八个
        mEight();
        //第九个
        mNine();
        //第十个，滑动
        mTen();
        //第十一个，居家标题
//        mEven();
        //第十二个，居家要复用，要嵌套，外加标题
        mEvenJu();
        addAdapter();
        presenter.getBan();
    }

    private void mEvenJu() {        //用线性helper
        LinearLayoutHelper layoutHer = new LinearLayoutHelper();

        eventAdapter = new EventAdapter(getActivity(), layoutHer, mCateg);
    }

    private void mEven() {
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        singleLayoutHelper.setItemCount(1);
        singleLayoutHelper.setAspectRatio(6);
        singleLayoutHelper.setMarginTop(6);
        String name="居家";
        evenAdapter = new ThreeAdapter(getActivity(), singleLayoutHelper, mChanne, name);
    }

    private void mTen() {   //里面需一个组件rec,然后横向滑动，互相不影响
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        singleLayoutHelper.setItemCount(1);
        tenAdapter = new TenAdapter(getActivity(), singleLayoutHelper, mTopic);
    }

    private void mNine() {
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        singleLayoutHelper.setItemCount(1);
        singleLayoutHelper.setAspectRatio(6);
        singleLayoutHelper.setMarginTop(6);
        String name="专题精选";
        nineAdapter = new ThreeAdapter(getActivity(), singleLayoutHelper, mChanne, name);
    }

    private void mEight() {
        LinearLayoutHelper layoutHelper = new LinearLayoutHelper();
        layoutHelper.setItemCount(3);
        eightAdapter = new EightAdapter(getActivity(), layoutHelper, mHot);
    }

    private void mServen() {        //人气推荐
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        singleLayoutHelper.setItemCount(1);
        singleLayoutHelper.setAspectRatio(6);
        singleLayoutHelper.setMarginTop(4);
        //修改，复用单一适配器
        String name="人气推荐";
        servenAdapter = new ThreeAdapter(getActivity(), singleLayoutHelper, mChanne, name);
    }

    private void mSix() {
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(2);
        gridLayoutHelper.setAutoExpand(true);
        gridLayoutHelper.setVGap(10);
        gridLayoutHelper.setHGap(10);
        gridLayoutHelper.setAspectRatio(2);
        sixAdapter = new SixAdapter(getActivity(), gridLayoutHelper, mGoods);
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
        String name="品牌制造商直供";
        threeAdapter = new ThreeAdapter(getActivity(),singleLayoutHelper,mChanne,name);
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
        adapter.addAdapter(sixAdapter);
        adapter.addAdapter(servenAdapter);
        adapter.addAdapter(eightAdapter);
        adapter.addAdapter(nineAdapter);
        adapter.addAdapter(tenAdapter);
//        adapter.addAdapter(evenAdapter);      //复用了，注释掉
        adapter.addAdapter(eventAdapter);
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

            List<BanBean.DataBean.NewGoodsListBean> newGoodsList = banBean.getData().getNewGoodsList();
            mGoods.addAll(newGoodsList);
            sixAdapter.notifyDataSetChanged();

            servenAdapter.notifyDataSetChanged();

            if (mGoods.size()>0){
                List<BanBean.DataBean.HotGoodsListBean> hotGoodsList = banBean.getData().getHotGoodsList();
                mHot.addAll(hotGoodsList);
                eightAdapter.notifyDataSetChanged();
            }
            nineAdapter.notifyDataSetChanged();

            List<BanBean.DataBean.TopicListBean> topicList = banBean.getData().getTopicList();
            mTopic.addAll(topicList);
            tenAdapter.notifyDataSetChanged();

//            evenAdapter.notifyDataSetChanged();
            List<BanBean.DataBean.CategoryListBean> categoryList = banBean.getData().getCategoryList();
            mCateg.addAll(categoryList);
            eventAdapter.notifyDataSetChanged();

        }
    }
}
