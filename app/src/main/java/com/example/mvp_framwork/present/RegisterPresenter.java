package com.example.mvp_framwork.present;


import com.example.mvp_framwork.base.BasePresenter;
import com.example.mvp_framwork.bean.BaseObjectBean;
import com.example.mvp_framwork.bean.LoginBean;
import com.example.mvp_framwork.contract.RegisterContract;
import com.example.mvp_framwork.model.RegisterModel;
import com.example.mvp_framwork.net.RxScheduler;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;


public class RegisterPresenter extends BasePresenter<RegisterContract.View> implements RegisterContract.Presenter {

    private RegisterContract.Model model;

    public RegisterPresenter() {
        model = new RegisterModel();
    }

    @Override
    public void register(String username, String password, String repassword) {
        if (!isViewAttached()) {
            return;
        }
        model.register(username,password,repassword)
                .compose(RxScheduler.Obs_io_main())
                .to(mView.bindAutoDispose())
                .subscribe(new Observer<BaseObjectBean<LoginBean>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        mView.showLoading();
                    }

                    @Override
                    public void onNext(@NonNull BaseObjectBean<LoginBean> loginBeanBaseObjectBean) {
                        mView.onSuccess(loginBeanBaseObjectBean);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        mView.onError(e.getMessage());
                        mView.hideLoading();
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
