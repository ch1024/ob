package com.example.mvp.baseApi;

import io.reactivex.disposables.Disposable;

public interface IBaseModel {
    void addDisposable(Disposable disposable);
    void clear();
}
