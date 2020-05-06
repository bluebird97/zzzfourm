package com.paulkg12.t61.ui.activity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.thirtydegreesray.dataautoaccess.annotation.AutoAccess;
import com.paulkg12.t61.R;
import com.paulkg12.t61.inject.component.AppComponent;
import com.paulkg12.t61.ui.activity.base.PagerActivity;
import com.paulkg12.t61.ui.adapter.base.FragmentPagerModel;
import com.paulkg12.t61.ui.adapter.base.FragmentViewPagerAdapter;
import com.paulkg12.t61.ui.fragment.MarkdownEditorFragment;
import com.paulkg12.t61.ui.fragment.MarkdownPreviewFragment;
import com.paulkg12.t61.util.StringUtils;

import java.util.ArrayList;


public class MarkdownEditorActivity extends PagerActivity implements MarkdownEditorCallback {

    public static void show(@NonNull Activity activity, @StringRes int title, int requestCode) {
        show(activity, title, requestCode, null);
    }

    public static void show(@NonNull Activity activity, @StringRes int title,
                            int requestCode, @Nullable String text) {
        show(activity, title, requestCode, text, null);
    }

    public static void show(@NonNull Activity activity, @StringRes int title,
                            int requestCode, @Nullable String text,
                            @Nullable ArrayList<String> mentionUsers) {
        Intent intent = new Intent(activity, MarkdownEditorActivity.class);
        intent.putExtra("text", text);
        intent.putExtra("title", title);
        intent.putExtra("mentionUsers", mentionUsers);
        activity.startActivityForResult(intent, requestCode);
    }


    @AutoAccess String text;
    @AutoAccess @StringRes int title;
    @AutoAccess ArrayList<String> mentionUsers;
    private MarkdownEditorCallback markdownEditorCallback;
    private boolean isKeyBoardShow = true;

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {

    }

    @Override
    protected void initActivity() {
        super.initActivity();
        pagerAdapter = new FragmentViewPagerAdapter(getSupportFragmentManager());
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        setToolbarBackEnable();
        setToolbarTitle(getString(title));

        pagerAdapter.setPagerList(FragmentPagerModel
                .createMarkdownEditorPagerList(getActivity(), text, getFragments(), mentionUsers));
        tabLayout.setVisibility(View.VISIBLE);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setAdapter(pagerAdapter);

    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        if(fragment instanceof  MarkdownEditorFragment){
            markdownEditorCallback = (MarkdownEditorCallback) fragment;
        }
    }

    @Override
    public int getPagerSize() {
        return 2;
    }

    @Override
    protected int getFragmentPosition(Fragment fragment) {
        if(fragment instanceof MarkdownEditorFragment){
            return 0;
        }else if(fragment instanceof MarkdownPreviewFragment){
            return 1;
        }else
            return -1;
    }

    @Nullable
    @Override
    protected int getContentView() {
        return R.layout.activity_view_pager;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_confirm, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.action_commit){
            commit();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void commit(){
        if(StringUtils.isBlank(getText())){
            Toast.makeText(getActivity(), getString(R.string.comment_null_warning), Toast.LENGTH_SHORT).show();
            return;
        }
        Intent data = new Intent();
        data.putExtra("text", getText());
        setResult(RESULT_OK, data);
        finish();
    }


    @Override
    public String getText() {
        return markdownEditorCallback.getText();
    }

    @Override
    public boolean isTextChanged() {
        return markdownEditorCallback.isTextChanged();
    }

}

