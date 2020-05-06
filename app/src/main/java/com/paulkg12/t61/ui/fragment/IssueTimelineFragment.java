package com.paulkg12.t61.ui.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;

import com.thirtydegreesray.dataautoaccess.annotation.AutoAccess;
import com.paulkg12.t61.R;
import com.paulkg12.t61.inject.component.AppComponent;
import com.paulkg12.t61.inject.component.DaggerFragmentComponent;
import com.paulkg12.t61.inject.module.FragmentModule;
import com.paulkg12.t61.mvp.contract.IIssueTimelineContract;
import com.paulkg12.t61.mvp.model.Issue;
import com.paulkg12.t61.mvp.model.IssueEvent;
import com.paulkg12.t61.mvp.presenter.IssueTimelinePresenter;
import com.paulkg12.t61.ui.activity.IssueDetailActivity;
import com.paulkg12.t61.ui.activity.MarkdownEditorActivity;
import com.paulkg12.t61.ui.activity.ViewerActivity;
import com.paulkg12.t61.ui.adapter.IssueTimelineAdapter;
import com.paulkg12.t61.ui.fragment.base.ListFragment;
//import com.paulkg12.t61.util.AppOpener;
import com.paulkg12.t61.util.BundleHelper;

import java.util.ArrayList;
// 这个界面是 topic #18 这样子的 点击进入 一个 issue 的 最详情
// 页面， 再在这个页面点击，就会进入 issue 的 markdown 界面。

public class IssueTimelineFragment extends ListFragment<IssueTimelinePresenter, IssueTimelineAdapter>
        implements IIssueTimelineContract.View {

    public static IssueTimelineFragment create(@NonNull Issue issue){
        IssueTimelineFragment fragment = new IssueTimelineFragment();
        fragment.setArguments(BundleHelper.builder().put("issue", issue).build());
        return fragment;
    }

    @AutoAccess String editingCommentId;

    @Override
    protected void initFragment(Bundle savedInstanceState) {
        super.initFragment(savedInstanceState);
        setLoadMoreEnable(true);
        setAutoJudgeCanLoadMoreEnable(false);
    }

    @Override
    public void showTimeline(ArrayList<IssueEvent> events) {
        adapter.setData(events);
        postNotifyDataSetChanged();
    }

    @Override
    public void showEditCommentPage(String commentId, String body) {
        MarkdownEditorActivity.show(getActivity(), R.string.comment,
                IssueDetailActivity.EDIT_COMMENT_REQUEST_CODE,
                body);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_list;
    }

    @Override
    protected void setupFragmentComponent(AppComponent appComponent) {
        DaggerFragmentComponent.builder()
                .appComponent(appComponent)
                .fragmentModule(new FragmentModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected void onReLoadData() {
        mPresenter.loadTimeline(1, true);
    }

    @Override
    protected String getEmptyTip() {
        return getString(R.string.no_comments);
    }

    @Override
    protected void onLoadMore(int page) {
        super.onLoadMore(page);
        mPresenter.loadTimeline(page, false);
    }

    @Override
    protected int getHeaderSize() {
        return 1;
    }

    @Override
    public void onItemClick(int position, @NonNull View view) {
        super.onItemClick(position, view);
        if(IssueEvent.Type.commented.equals(adapter.getData().get(position).getType())){
            // 这里 就进入了 view md 的界面
            ViewerActivity.showMdSource(getActivity(), getString(R.string.comment),
                    adapter.getData().get(position).getBodyHtml());
        }
    }

    public void addComment(IssueEvent event){
        mPresenter.getTimeline().add(event);
        postNotifyDataSetChanged();
        recyclerView.smoothScrollToPosition(adapter.getItemCount() - 1);
    }

    @Override
    public boolean onItemLongClick(final int position, @NonNull View view) {
        final IssueEvent issueEvent = adapter.getData().get(position);
        if(!IssueEvent.Type.commented.equals(issueEvent.getType())){
            return true;
        }

        String[] actions ;
        if(mPresenter.isEditAndDeleteEnable(position) && position != 0){
            actions = new String[]{getString(R.string.share), getString(R.string.edit), getString(R.string.delete)};
        } else {
            actions = new String[]{getString(R.string.share)};

        }
        new AlertDialog.Builder(getActivity())
                .setItems(actions, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        switch (which){
                            case 0:
                                Log.d("TTTAG", "onClick: no share for now");
                                //AppOpener.shareText(getActivity(), issueEvent.getHtmlUrl());
                                break;
                            case 1:
                                editingCommentId = issueEvent.getId();
                                showEditCommentPage(editingCommentId, issueEvent.getBody());
                                break;
                            case 2:
                                showDeleteCommentWarning(position, issueEvent.getId());
                                break;
                        }
                    }
                })
                .show();
        return true;
    }

    private void showDeleteCommentWarning(final int position, final String commentId){
        new AlertDialog.Builder(getActivity())
                .setCancelable(true)
                .setTitle(R.string.warning_dialog_tile)
                .setMessage(R.string.delete_comment_warning)
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setPositiveButton(R.string.confirm, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        adapter.getData().remove(position);
                        adapter.notifyItemRemoved(position);
                        mPresenter.deleteComment(commentId);
                    }
                })
                .show();
    }

    public void onEditComment(String body) {
        mPresenter.editComment(editingCommentId, body);
    }

    public void onEditIssue(Issue issue){
        mPresenter.setIssue(issue);
        adapter.getData().get(0).setBody(issue.getBody());
        adapter.getData().get(0).setBodyHtml(issue.getBodyHtml());
        adapter.getData().get(0).setParentIssue(issue);
        adapter.notifyItemChanged(0);
    }

    public ArrayList<String> getIssueUsersExceptMe(){
        return mPresenter.getIssueUsersExceptMe();
    }

}

