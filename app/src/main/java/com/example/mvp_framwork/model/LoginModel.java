package com.example.mvp_framwork.model;


import com.example.mvp_framwork.bean.BaseObjectBean;
import com.example.mvp_framwork.bean.LoginBean;
import com.example.mvp_framwork.contract.LoginContract;
import com.example.mvp_framwork.net.RetrofitClient;

import io.reactivex.rxjava3.core.Observable;

public class LoginModel implements LoginContract.Model {
    @Override
    public Observable<BaseObjectBean<LoginBean>> login(String username, String password) {
        return RetrofitClient.getInstance().getApi().login(username,password);
    }
}
