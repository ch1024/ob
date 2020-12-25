package com.example.mvp.base;

import com.example.mvp.baseApi.IBaseModel;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract   class BaseModel implements IBaseModel {

    CompositeDisposable disposableSet=new CompositeDisposable();
    @Override
    public void addDisposable(Disposable disposable) {
        disposableSet.add(disposable);
    }

    @Override
    public void clear() {
        disposableSet.clear();
    }
}
