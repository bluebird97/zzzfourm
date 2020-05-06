package com.paulkg12.t61.mvp.contract;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.paulkg12.t61.mvp.contract.base.IBaseContract;
import com.paulkg12.t61.mvp.model.Issue;
import com.paulkg12.t61.mvp.model.IssueEvent;

public interface IIssueDetailContract {

    interface View extends IBaseContract.View{
        void showIssue(@NonNull Issue issue);
        void showAddedComment(@NonNull IssueEvent event);
        void showAddCommentPage(@Nullable String text);
    }

    interface Presenter extends IBaseContract.Presenter<IIssueDetailContract.View> {
        void addComment(@NonNull String text);
        void toggleIssueState();
    }

}

