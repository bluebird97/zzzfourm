package com.paulkg12.t61.ui.adapter.base;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.paulkg12.t61.R;
import com.paulkg12.t61.mvp.model.Issue;
import com.paulkg12.t61.mvp.model.Repository;
import com.paulkg12.t61.mvp.model.User;
import com.paulkg12.t61.ui.fragment.IssuesFragment;
import com.paulkg12.t61.ui.fragment.MarkdownEditorFragment;
import com.paulkg12.t61.ui.fragment.MarkdownPreviewFragment;
import com.paulkg12.t61.ui.fragment.base.BaseFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ThirtyDegreesRay on 2017/8/15 21:10:14
 */

public class FragmentPagerModel {

    private String title;
    private BaseFragment fragment;

    public FragmentPagerModel(String title, BaseFragment fragment) {
        this.title = title;
        this.fragment = fragment;
    }

    public String getTitle() {
        return title;
    }

    public BaseFragment getFragment() {
        return fragment;
    }


    public static List<FragmentPagerModel> createRepoIssuesPagerList(@NonNull Context context
            , @NonNull final String userId, @NonNull final String repoName, @NonNull ArrayList<Fragment> fragments) {
        return setPagerFragmentFlag(Arrays.asList(
                new FragmentPagerModel(context.getString(R.string.open),
                        getFragment(fragments, 0, () -> IssuesFragment.createForRepo(Issue.IssueState.open, userId, repoName))),
                new FragmentPagerModel(context.getString(R.string.closed),
                        getFragment(fragments, 1, () -> IssuesFragment.createForRepo(Issue.IssueState.closed, userId, repoName)))
        ));
    }


    public static List<FragmentPagerModel> createMarkdownEditorPagerList(@NonNull Context context
            , final String text, @NonNull ArrayList<Fragment> fragments, final ArrayList<String> mentionUsers) {
        return setPagerFragmentFlag(Arrays.asList(
                new FragmentPagerModel(context.getString(R.string.write),
                        getFragment(fragments, 0, () -> MarkdownEditorFragment.create(text, mentionUsers))),
                new FragmentPagerModel(context.getString(R.string.preview),
                        getFragment(fragments, 1, () -> MarkdownPreviewFragment.create()))
        ));
    }



    private static List<FragmentPagerModel> setPagerFragmentFlag(List<FragmentPagerModel> list) {
        for (FragmentPagerModel model : list) {
            model.getFragment().setPagerFragment(true);
        }
        return list;
    }

    private static BaseFragment getFragment(ArrayList<Fragment> fragments
            , int position, FragmentCreator fragmentCreator){
        Fragment fragment  = fragments.get(position);
        if(fragment == null){
            fragment = fragmentCreator.createFragment();
//            Logger.d("create fragment " + fragment + (Math.random() * 1000 * 1000));
        }else{
//            Logger.d("reuse fragment" + fragment + (Math.random() * 1000 * 1000));
        }
        return (BaseFragment) fragment;
    }

    interface FragmentCreator<F extends Fragment>{
        F createFragment();
    }

}

