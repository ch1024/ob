package com.example.mvp.http.api;

import java.util.HashMap;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.FieldMap;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface ApiService {
    @GET
    Flowable<ResponseBody> get(@Url String url);

    @POST
    Flowable<ResponseBody> post(@Url String url);

    @POST
    Flowable<ResponseBody> post(@Url String url, @FieldMap HashMap<String,String> map);
}
