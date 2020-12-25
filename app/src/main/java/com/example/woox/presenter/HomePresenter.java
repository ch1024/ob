package com.example.woox.presenter;

import android.util.Log;

import com.example.mvp.base.BasePresenter;
import com.example.mvp.baseApi.BaseView;
import com.example.mvp.baseApi.IBaseModel;
import com.example.mvp.http.api.NetCallBack;
import com.example.woox.bean.BanBean;
import com.example.woox.constart.Contract;
import com.example.woox.model.HomeModel;

public class HomePresenter<V extends Contract.HomeView> extends BasePresenter<V,Contract.HomeModel> implements Contract.HomePresenter,BaseView {
    @Override
    public void getBan() {
        model.getBan(new NetCallBack<BanBean>() {
            @Override
            public void onSuccess(BanBean banBean) {
                view.onSSon(banBean);
            }

            @Override
            public void onFail(String err) {
                Log.e("ban",err);
            }
        });
    }

    @Override
    public Contract.HomeModel getModel() {
        return new HomeModel();
    }
}
