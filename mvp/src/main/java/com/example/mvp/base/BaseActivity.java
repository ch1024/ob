package com.example.mvp.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mvp.baseApi.BaseView;


public abstract class BaseActivity <P extends BasePresenter>  extends AppCompatActivity implements BaseView {
    protected P presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setViewId());
        if (presenter==null){
            presenter=getPresenter();
            presenter.onAtton(this);
        }
        initView();
        initData();
    }
    protected abstract int setViewId();
    protected abstract void initView();
    protected abstract P getPresenter();
    protected abstract void initData();
}
