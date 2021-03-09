package com.example.mvp_framwork.model;


import com.example.mvp_framwork.bean.BaseObjectBean;
import com.example.mvp_framwork.bean.LoginBean;
import com.example.mvp_framwork.contract.RegisterContract;
import com.example.mvp_framwork.net.RetrofitClient;

import io.reactivex.rxjava3.core.Observable;

public class RegisterModel implements RegisterContract.Model {
    @Override
    public Observable<BaseObjectBean<LoginBean>> register(String username, String password, String repassword) {
        return RetrofitClient.getInstance().getApi().register(username,password,repassword);
    }
}
