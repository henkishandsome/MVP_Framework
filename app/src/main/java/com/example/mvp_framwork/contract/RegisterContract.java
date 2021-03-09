package com.example.mvp_framwork.contract;


import com.example.mvp_framwork.base.BaseView;
import com.example.mvp_framwork.bean.BaseObjectBean;
import com.example.mvp_framwork.bean.LoginBean;

import io.reactivex.rxjava3.core.Observable;

public interface RegisterContract {
    interface Model {
        Observable<BaseObjectBean<LoginBean>> register(String username, String password, String repassword);
    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(String errMessage);

        void onSuccess(BaseObjectBean<LoginBean> bean);
    }

    interface Presenter {
        /**
         * 登陆
         *
         * @param username
         * @param password
         */
        void register(String username, String password, String repassword);
    }
}
