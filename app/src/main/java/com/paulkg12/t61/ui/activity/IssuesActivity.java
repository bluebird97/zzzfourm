package com.paulkg12.t61.ui.activity;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.paulkg12.t61.ui.widget.ZoomAbleFloatingActionButton;
import com.thirtydegreesray.dataautoaccess.annotation.AutoAccess;
import com.paulkg12.t61.R;
import com.paulkg12.t61.inject.component.AppComponent;
import com.paulkg12.t61.inject.component.DaggerActivityComponent;
import com.paulkg12.t61.inject.module.ActivityModule;
import com.paulkg12.t61.mvp.model.Issue;
import com.paulkg12.t61.mvp.model.filter.IssuesFilter;
import com.paulkg12.t61.mvp.model.filter.SortDirection;
import com.paulkg12.t61.mvp.presenter.IssuesActPresenter;
import com.paulkg12.t61.ui.activity.base.PagerActivity;
import com.paulkg12.t61.ui.adapter.base.FragmentPagerModel;
import com.paulkg12.t61.ui.fragment.IssuesFragment;
import com.paulkg12.t61.ui.fragment.base.ListFragment;
import com.paulkg12.t61.util.BundleHelper;
import com.paulkg12.t61.util.ViewUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by ThirtyDegreesRay on 2017/9/20 14:42:31
 */

public class IssuesActivity extends PagerActivity<IssuesActPresenter>
        implements ListFragment.ListScrollListener{

    public static void showForRepo(@NonNull Activity activity, @NonNull String userId,
                                   @NonNull String repoName) {
        Intent intent = new Intent(activity, IssuesActivity.class)
                .putExtras(BundleHelper.builder()
                        .put("issuesType", IssuesFilter.Type.Repo)
                        .put("userId", userId)
                        .put("repoName", repoName).build());
        activity.startActivity(intent);
    }

    private final static int ADD_ISSUE_REQUEST_CODE = 100;

    @AutoAccess String userId;
    @AutoAccess String repoName;
    @AutoAccess IssuesFilter.Type issuesType;
    @BindView(R.id.add_issue_bn)
    ZoomAbleFloatingActionButton addBn;

    private ArrayList<IssuesListListener> listeners;

    @Override
    protected void initActivity() {
        super.initActivity();
        setEndDrawerEnable(true);
    }
    //tt 迟早要弄明白你 dagger;; 你应该深入理解了 0326
    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerActivityComponent.builder()
                .appComponent(appComponent)//tt who is using me? appcomponet
                .activityModule(new ActivityModule(getActivity()))
                .build()
                .inject(this);
    }

    @Nullable
    @Override
    protected int getContentView() {
        return R.layout.activity_view_pager_with_drawer;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        updateEndDrawerContent(R.menu.drawer_menu_issues);
        setToolbarScrollAble(true);
        //setToolbarBackEnable();
        if (IssuesFilter.Type.Repo.equals(issuesType)) {
            setToolbarTitle(" ");


        } else {
            setToolbarTitle(getString(R.string.issues));
        }
        addBn.setVisibility(IssuesFilter.Type.Repo.equals(issuesType) ? View.VISIBLE : View.GONE);

        if (IssuesFilter.Type.User.equals(issuesType)) {
            // tt never happen for tt
            //pagerAdapter.setPagerList(FragmentPagerModel
             //       .createUserIssuesPagerList(getActivity(), getFragments()));
        } else {
            List<FragmentPagerModel> fragmentPagerModels = FragmentPagerModel
                    .createRepoIssuesPagerList(getActivity(), userId, repoName, getFragments());
            pagerAdapter.setPagerList(fragmentPagerModels);
            navViewEnd.getMenu().findItem(R.id.nav_type_chooser).setVisible(false);
            ((ListFragment)fragmentPagerModels.get(0).getFragment()).setListScrollListener(this);
        }
        listeners = new ArrayList<>();
        for (FragmentPagerModel pagerModel : pagerAdapter.getPagerList()) {
            listeners.add((IssuesListListener) pagerModel.getFragment());
        }
        tabLayout.setVisibility(View.VISIBLE);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setAdapter(pagerAdapter);
        showFirstPager();
    }
    @Override
    protected void setToolbarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
            getSupportActionBar().setBackgroundDrawable(getDrawable(R.drawable.atshaotai2));
        }
        if(toolbarLayout != null){
            toolbarLayout.setTitle(title);
        }
    }
    @Override
    protected boolean isEndDrawerMultiSelect() {
        return true;
    }

    @Override
    protected int getEndDrawerToggleMenuItemId() {
        return R.id.nav_sort;
    }

    @Override
    protected void onNavItemSelected(@NonNull MenuItem item, boolean isStartDrawer) {
        listeners.get(0).onIssuesFilterChanged(getIssuesFilter(true));
        listeners.get(1).onIssuesFilterChanged(getIssuesFilter(false));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_sort, menu);
        return true;
    }

    @OnClick(R.id.add_issue_bn)
    public void onAddIssueClick() {
        EditIssueActivity.showForAdd(getActivity(), userId, repoName, ADD_ISSUE_REQUEST_CODE);
    }

    private IssuesFilter getIssuesFilter(boolean open) {
        IssuesFilter issuesFilter = new IssuesFilter(issuesType, open ? Issue.IssueState.open
                : Issue.IssueState.closed);
        if (IssuesFilter.Type.User.equals(issuesType)) {
            MenuItem selectedUserFilterMenu = ViewUtils.getSelectedMenu(
                    navViewEnd.getMenu().findItem(R.id.nav_type_chooser));
            if (selectedUserFilterMenu != null) {
                IssuesFilter.UserIssuesFilterType userFilterType =
                        getUserIssuesFilterType(selectedUserFilterMenu.getItemId());
                issuesFilter.setUserIssuesFilterType(userFilterType);
            }
        }
        MenuItem sortMenu = ViewUtils.getSelectedMenu(navViewEnd.getMenu().findItem(R.id.nav_sort));
        IssuesFilter.SortType sortType = IssuesFilter.SortType.Created;
        SortDirection sortDirection = SortDirection.Desc;
        if (sortMenu != null) {
            switch (sortMenu.getItemId()) {
                case R.id.nav_recently_created:
                    sortType = IssuesFilter.SortType.Created;
                    sortDirection = SortDirection.Desc;
                    break;
                case R.id.nav_previously_created:
                    sortType = IssuesFilter.SortType.Created;
                    sortDirection = SortDirection.Asc;
                    break;
                case R.id.nav_recently_updated:
                    sortType = IssuesFilter.SortType.Updated;
                    sortDirection = SortDirection.Desc;
                    break;
                case R.id.nav_least_recently_updated:
                    sortType = IssuesFilter.SortType.Updated;
                    sortDirection = SortDirection.Asc;
                    break;
                case R.id.nav_most_comments:
                    sortType = IssuesFilter.SortType.Comments;
                    sortDirection = SortDirection.Desc;
                    break;
                case R.id.nav_fewest_comments:
                    sortType = IssuesFilter.SortType.Comments;
                    sortDirection = SortDirection.Asc;
                    break;
            }
        }
        issuesFilter.setSortType(sortType);
        issuesFilter.setSortDirection(sortDirection);
        return issuesFilter;
    }

    private IssuesFilter.UserIssuesFilterType getUserIssuesFilterType(int itemId) {
        switch (itemId) {
            case R.id.nav_all:
                return IssuesFilter.UserIssuesFilterType.All;
            case R.id.nav_created:
                return IssuesFilter.UserIssuesFilterType.Created;
            case R.id.nav_assigned:
                return IssuesFilter.UserIssuesFilterType.Assigned;
            case R.id.nav_mentioned:
                return IssuesFilter.UserIssuesFilterType.Mentioned;
            default:
                return IssuesFilter.UserIssuesFilterType.All;
        }
    }

    @Override
    public void onScrollUp() {
        //showInfoToast("scroll up");
        addBn.zoomIn();
    }

    @Override
    public void onScrollDown() {
        addBn.zoomOut();
    }

    public interface IssuesListListener {
        void onIssuesFilterChanged(@NonNull IssuesFilter issuesFilter);

        void onCreateIssue(@NonNull Issue issue);
    }

    @Override
    public void onPageSelected(int position) {
        super.onPageSelected(position);
        if(IssuesFilter.Type.Repo.equals(issuesType)){
            if(position == 0){
                addBn.zoomOut();
            } else {
                addBn.zoomIn();
            }
        }
    }

    @Override
    public int getPagerSize() {
        return 2;
    }

    @Override
    protected int getFragmentPosition(Fragment fragment) {
        if (fragment instanceof IssuesFragment) {
            IssuesFilter issuesFilter = fragment.getArguments().getParcelable("issuesFilter");
            if (issuesFilter == null) {
                return -1;
            } else {
                return Issue.IssueState.open.equals(issuesFilter.getIssueState()) ? 0 : 1;
            }
        } else
            return -1;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_OK) return;
        if (requestCode == ADD_ISSUE_REQUEST_CODE) {
            Issue issue = data.getParcelableExtra("issue");
            listeners.get(0).onCreateIssue(issue);
        }
    }
}
