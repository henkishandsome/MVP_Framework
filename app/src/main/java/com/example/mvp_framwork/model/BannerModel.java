package com.example.mvp_framwork.model;


import com.example.mvp_framwork.bean.Article;
import com.example.mvp_framwork.bean.BannerBean;
import com.example.mvp_framwork.bean.BaseArrayBean;
import com.example.mvp_framwork.bean.BaseObjectBean;
import com.example.mvp_framwork.contract.BannerContract;
import com.example.mvp_framwork.net.RetrofitClient;

import io.reactivex.rxjava3.core.Observable;

public class BannerModel implements BannerContract.Model {
    @Override
    public Observable<BaseArrayBean<BannerBean>> getBanner() {
        return RetrofitClient.getInstance().getApi().getBanner();
    }

    @Override
    public Observable<BaseObjectBean<Article>> getArticleList(int curPage) {
        return RetrofitClient.getInstance().getApi().getArticleList(curPage);
    }
}
