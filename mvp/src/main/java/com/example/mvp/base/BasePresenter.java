package com.example.mvp.base;


import com.example.mvp.baseApi.BaseView;
import com.example.mvp.baseApi.IBaseModel;

public abstract class BasePresenter<V extends BaseView,M extends IBaseModel>{
    protected V view;
    protected M model;
    public void onAtton(V view){
        this.view=view;
        model=getModel();
    }
    public abstract M getModel();

    public void detachView(){
        if (view!=null){
            view=null;
            model=null;
        }
    }
}
