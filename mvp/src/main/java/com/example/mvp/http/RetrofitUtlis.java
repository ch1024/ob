package com.example.mvp.http;


import com.example.mvp.http.api.ApiService;
import com.example.mvp.http.api.BaseUrl;
import com.example.mvp.http.api.NetCallBack;
import com.example.mvp.http.contract.ContractUtlis;
import com.example.mvp.http.utils.RxUtils;
import com.google.gson.Gson;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.FlowableTransformer;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class RetrofitUtlis implements ContractUtlis {
    private static RetrofitUtlis instance;
    private ApiService apiService;

    private RetrofitUtlis() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        apiService = retrofit.create(ApiService.class);
    }
    public static RetrofitUtlis getInstance(){
        if (instance==null){
            synchronized (RetrofitUtlis.class){
                if (instance==null){
                    instance=new RetrofitUtlis();
                }
            }
        }
        return instance;
    }

    @Override
    public <T> Disposable get(String url, NetCallBack<T> callBack) {
         Disposable disposable = apiService.get(url)
                .compose(RxUtils.rxScheduler())
                .subscribeWith(new ResourceSubscriber<ResponseBody>() {
                    @Override
                    public void onNext(ResponseBody responseBody) {
                        try {
                            String json = responseBody.string();
                            Gson gson = new Gson();
                            Type[] genericInterfaces = callBack.getClass().getGenericInterfaces();
                            Type[] arguments = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
                            T fromJson = gson.fromJson(json, arguments[0]);
                            callBack.onSuccess(fromJson);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        callBack.onFail(t.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
        return disposable;
    }

    @Override
    public <T> Disposable getIo(String url, NetCallBack<T> callBack) {
        Disposable disposable = apiService.get(url)
                .compose(RxUtils.rxSchedulerIo())
                .subscribeWith(new ResourceSubscriber<ResponseBody>() {
                    @Override
                    public void onNext(ResponseBody responseBody) {
                        try {
                            String json = responseBody.string();
                            Gson gson = new Gson();
                            Type[] genericInterfaces = callBack.getClass().getGenericInterfaces();
                            Type[] arguments = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
                            T fromJson = gson.fromJson(json, arguments[0]);
                            callBack.onSuccess(fromJson);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        callBack.onFail(t.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
        return disposable;
    }

    @Override
    public <T> Disposable post(String url, NetCallBack<T> callBack) {
        Disposable disposable = apiService.get(url)
                .compose(RxUtils.rxScheduler())
                .subscribeWith(new ResourceSubscriber<ResponseBody>() {
                    @Override
                    public void onNext(ResponseBody responseBody) {
                        try {
                            String json = responseBody.string();
                            Gson gson = new Gson();
                            Type[] genericInterfaces = callBack.getClass().getGenericInterfaces();
                            Type[] arguments = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
                            T fromJson = gson.fromJson(json, arguments[0]);
                            callBack.onSuccess(fromJson);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        callBack.onFail(t.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
        return disposable;
    }

    @Override
    public <T> Disposable post(String url, HashMap<String, String> map, NetCallBack<T> callBack) {
        Disposable disposable = apiService.get(url)
                .compose(RxUtils.rxScheduler())
                .subscribeWith(new ResourceSubscriber<ResponseBody>() {
                    @Override
                    public void onNext(ResponseBody responseBody) {
                        try {
                            String json = responseBody.string();
                            Gson gson = new Gson();
                            Type[] genericInterfaces = callBack.getClass().getGenericInterfaces();
                            Type[] arguments = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
                            T fromJson = gson.fromJson(json, arguments[0]);
                            callBack.onSuccess(fromJson);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        callBack.onFail(t.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
        return disposable;
    }
}
