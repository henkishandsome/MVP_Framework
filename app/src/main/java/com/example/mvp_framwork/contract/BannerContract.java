package com.example.mvp_framwork.contract;


import com.example.mvp_framwork.base.BaseView;
import com.example.mvp_framwork.bean.Article;
import com.example.mvp_framwork.bean.BannerBean;
import com.example.mvp_framwork.bean.BaseArrayBean;
import com.example.mvp_framwork.bean.BaseObjectBean;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public interface BannerContract {
    interface Model {
        Observable<BaseArrayBean<BannerBean>> getBanner();
        Observable<BaseObjectBean<Article>> getArticleList(int curPage);
    }

    interface View extends BaseView {
        @Override
        void showLoading();

        @Override
        void hideLoading();

        @Override
        void onError(String errMessage);

        void onSuccess(BaseArrayBean<BannerBean> bean, List<String> tiltelist, List<String> imgpath, List<String> urllist);

        void onGetArticleListSuccess(BaseObjectBean<Article> articleBaseObjectBean, List<Article.DatasBean> articlelist);
    }

    interface Presenter {
        void getBanner();
        void getArticleList(int curPage);
    }
}
