package com.example.woox.model;

import com.example.mvp.base.BaseModel;
import com.example.mvp.http.RetrofitUtlis;
import com.example.mvp.http.api.BaseUrl;
import com.example.mvp.http.api.NetCallBack;
import com.example.woox.bean.BanBean;
import com.example.woox.constart.Contract;

import io.reactivex.disposables.Disposable;

public class HomeModel extends BaseModel implements Contract.HomeModel {
    @Override
    public void getBan(NetCallBack<BanBean> netCallBack) {
        Disposable disposable = RetrofitUtlis.getInstance().get(BaseUrl.BAURL, netCallBack);
        addDisposable(disposable);
    }
}
