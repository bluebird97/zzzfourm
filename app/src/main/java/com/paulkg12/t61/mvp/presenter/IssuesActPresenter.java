package com.paulkg12.t61.mvp.presenter;

import com.paulkg12.t61.dao.DaoSession;
import com.paulkg12.t61.mvp.contract.IIssuesActContract;
import com.paulkg12.t61.mvp.presenter.base.BasePresenter;


import javax.inject.Inject;

public class IssuesActPresenter extends BasePresenter<IIssuesActContract.View>
        implements IIssuesActContract.Presenter{

    @Inject
    public IssuesActPresenter(DaoSession daoSession) {
        super(daoSession);
    }

}
