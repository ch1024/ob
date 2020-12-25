package com.example.mvp.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.mvp.baseApi.BaseView;

public abstract class BaseFragment <P extends BasePresenter> extends Fragment implements BaseView  {
    protected P presenter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(setView(), null);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (presenter==null){
            presenter=getPresenter();
            presenter.onAtton(this);
        }
        initView(view);
        initData();
    }

    protected abstract int setView();

    protected abstract void initView(View view);

    protected abstract P getPresenter();

    protected abstract void initData();
}
