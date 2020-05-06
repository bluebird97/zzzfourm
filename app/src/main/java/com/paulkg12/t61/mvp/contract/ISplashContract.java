package com.paulkg12.t61.mvp.contract;

import com.paulkg12.t61.mvp.contract.base.IBaseContract;

public interface ISplashContract{

    interface View extends IBaseContract.View{
        void showMainPage();
    }

    interface Presenter extends IBaseContract.Presenter<ISplashContract.View>{

        void getUser();

        void saveAccessToken(String accessToken, String scope, int expireIn);

    }

}
