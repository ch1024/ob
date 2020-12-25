package com.example.mvp.http.contract;



import com.example.mvp.http.api.NetCallBack;

import java.util.HashMap;

import io.reactivex.disposables.Disposable;

public interface ContractUtlis {
    public <T> Disposable get(String url, NetCallBack<T> callBack);
    public <T> Disposable getIo(String url, NetCallBack<T> callBack);
    public <T> Disposable post(String url,NetCallBack<T> callBack);
    public <T> Disposable post(String url, HashMap<String,String> map, NetCallBack<T> callBack);
}
