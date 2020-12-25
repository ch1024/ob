package com.example.woox.constart;

import com.example.mvp.baseApi.BaseView;
import com.example.mvp.baseApi.IBaseModel;
import com.example.mvp.http.api.NetCallBack;
import com.example.woox.bean.BanBean;

public interface Contract {
    interface HomeView extends BaseView {
        void onSSon(BanBean banBean);
    }
    interface HomePresenter{
        void getBan();
    }
    interface HomeModel extends IBaseModel {
        void getBan(NetCallBack<BanBean> netCallBack);
    }
}
