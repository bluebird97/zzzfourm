package com.paulkg12.t61.mvp.presenter;

import com.paulkg12.t61.dao.DaoSession;
import com.paulkg12.t61.mvp.contract.IFirstPageContract;
import com.paulkg12.t61.mvp.presenter.base.BasePresenter;

import javax.inject.Inject;

public class FirstPagePresenter extends BasePresenter<IFirstPageContract.View> implements IFirstPageContract.Presenter {


    @Inject
    public FirstPagePresenter(DaoSession daoSession) {
        super(daoSession);
    }

    @Override
    public void yueyueStart() {
        System.out.println("FirstPage Presenter: yueyue start");
    }
}
