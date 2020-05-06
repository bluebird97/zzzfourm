package com.paulkg12.t61.mvp.contract;

import com.paulkg12.t61.mvp.contract.base.IBaseContract;
import com.paulkg12.t61.mvp.contract.base.IBaseListContract;
import com.paulkg12.t61.mvp.model.IssueEvent;

import java.util.ArrayList;

public interface IIssueTimelineContract {

    interface View extends IBaseContract.View, IBaseListContract.View {
        void showTimeline(ArrayList<IssueEvent> events);
        void showEditCommentPage(String commentId, String body);
    }

    interface Presenter extends IBaseContract.Presenter<IIssueTimelineContract.View> {
        void loadTimeline(int page, boolean isReload);
        boolean isEditAndDeleteEnable(int position);
        void deleteComment(String commentId);
        void editComment(String commentId, String body);
    }

}
