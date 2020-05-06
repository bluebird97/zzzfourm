package com.paulkg12.t61.mvp.contract;

import android.support.annotation.NonNull;

import com.paulkg12.t61.mvp.contract.base.IBaseContract;
import com.paulkg12.t61.mvp.model.Issue;
import com.paulkg12.t61.mvp.model.Label;

import java.util.ArrayList;

public interface IEditIssueContract {

    interface View extends IBaseContract.View{
        void showNewIssue(@NonNull Issue issue);
        void onLoadLabelsComplete(ArrayList<Label> labels);
    }

    interface Presenter extends IBaseContract.Presenter<IEditIssueContract.View>{
        void commitIssue(@NonNull String title, @NonNull String comment);
        void loadLabels();
        void clearAllLabelsData();
    }

}