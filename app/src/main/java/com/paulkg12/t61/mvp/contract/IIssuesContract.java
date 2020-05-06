package com.paulkg12.t61.mvp.contract;

import com.paulkg12.t61.mvp.contract.base.IBaseContract;
import com.paulkg12.t61.mvp.contract.base.IBaseListContract;
import com.paulkg12.t61.mvp.contract.base.IBasePagerContract;
import com.paulkg12.t61.mvp.model.Issue;
import com.paulkg12.t61.mvp.model.filter.IssuesFilter;

import java.util.ArrayList;

/**
 * Created by ThirtyDegreesRay on 2017/9/20 14:55:29
 */

public interface IIssuesContract {

    interface View extends IBaseContract.View, IBasePagerContract.View, IBaseListContract.View{
        void showIssues(ArrayList<Issue> issues);
    }

    interface Presenter extends IBasePagerContract.Presenter<IIssuesContract.View>{
        void loadIssues(int page, boolean isReload);
        void loadIssues(IssuesFilter issuesFilter, int page, boolean isReload);
    }

}
