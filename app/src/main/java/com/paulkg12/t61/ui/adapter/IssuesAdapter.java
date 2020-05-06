package com.paulkg12.t61.ui.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.paulkg12.t61.R;
import com.paulkg12.t61.common.GlideApp;
import com.paulkg12.t61.mvp.model.Issue;
import com.paulkg12.t61.ui.adapter.base.BaseAdapter;
import com.paulkg12.t61.ui.adapter.base.BaseViewHolder;
import com.paulkg12.t61.ui.fragment.base.BaseFragment;
import com.paulkg12.t61.util.PrefUtils;
import com.paulkg12.t61.util.StringUtils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by ThirtyDegreesRay on 2017/9/20 14:58:40
 */

public class IssuesAdapter extends BaseAdapter<IssuesAdapter.ViewHolder, Issue> {

    private boolean isUserIssues = false;

    @Inject
    public IssuesAdapter(Context context, BaseFragment fragment) {
        super(context, fragment);
    }

    public void setUserIssues(boolean userIssues) {
        isUserIssues = userIssues;
    }

    @Override
    protected int getLayoutId(int viewType) {
        return R.layout.layout_item_issue;
    }

    @Override
    protected ViewHolder getViewHolder(View itemView, int viewType) {
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        Issue model = data.get(position);
        GlideApp.with(fragment)
                .load(model.getUser().getAvatarUrl())
                .onlyRetrieveFromCache(!PrefUtils.isLoadImageEnable())
                .into(holder.userAvatar);
        holder.issueTitle.setText(model.getTitle());
        holder.commentNum.setText(String.valueOf(model.getCommentNum()));
        holder.time.setText(StringUtils.getNewsTimeStr(context, model.getCreatedAt()));
        if(isUserIssues) {
            holder.repoFullName.setText(model.getRepoFullName().concat(" #").concat(String.valueOf(model.getNumber())));
        } else {
            holder.repoFullName.setText(("#").concat(String.valueOf(model.getNumber())));
        }
    }

    class ViewHolder extends BaseViewHolder {

        @BindView(R.id.user_avatar) ImageView userAvatar;
        @BindView(R.id.time) TextView time;
        @BindView(R.id.issue_title) TextView issueTitle;
        @BindView(R.id.comment_num) TextView commentNum;
        @BindView(R.id.repo_full_name) TextView repoFullName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        @OnClick({R.id.user_avatar})
        public void onUserClick(){
            Log.d("TTTAG", "jst onUserClick: ");
        }

    }

}
