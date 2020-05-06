package com.paulkg12.t61.ui.activity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.view.View;

import com.thirtydegreesray.dataautoaccess.annotation.AutoAccess;
import com.paulkg12.t61.R;
import com.paulkg12.t61.mvp.contract.base.IBaseContract;
import com.paulkg12.t61.ui.activity.base.SingleFragmentActivity;
import com.paulkg12.t61.ui.fragment.LabelManageFragment;
import com.paulkg12.t61.util.BundleHelper;

import butterknife.BindView;
import butterknife.OnClick;
public class LabelManageActivity extends SingleFragmentActivity<IBaseContract.Presenter, LabelManageFragment> {

    public static void show(@NonNull Activity activity, @NonNull String owner, @NonNull String repo){
        Intent intent = new Intent(activity, LabelManageActivity.class);
        intent.putExtras(BundleHelper.builder().put("owner", owner).put("repo", repo).build());
        activity.startActivity(intent);
    }

    @AutoAccess String owner;
    @AutoAccess String repo;
    @BindView(R.id.float_action_bn) FloatingActionButton floatingActionButton;


    @Override
    protected LabelManageFragment createFragment() {
        return LabelManageFragment.create(owner, repo);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        setToolbarTitle(getString(R.string.labels), owner + "/" + repo);
        floatingActionButton.setVisibility(View.VISIBLE);
        setToolbarScrollAble(true);
    }

    @OnClick(R.id.float_action_bn) public void onCreateLabelClick(){
        getFragment().onCreateLabelClick();
    }

}
