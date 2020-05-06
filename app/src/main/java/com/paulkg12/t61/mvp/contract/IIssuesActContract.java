package com.paulkg12.t61.mvp.contract;

import com.paulkg12.t61.mvp.contract.base.IBaseContract;

public interface IIssuesActContract {

    interface View extends IBaseContract.View{

    }

    interface Presenter extends IBaseContract.Presenter<IIssuesActContract.View>{

    }

}
