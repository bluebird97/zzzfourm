package com.paulkg12.t61.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.thirtydegreesray.dataautoaccess.annotation.AutoAccess;
import com.paulkg12.t61.R;
import com.paulkg12.t61.mvp.contract.base.IBaseContract;
import com.paulkg12.t61.ui.activity.base.SingleFragmentActivity;
import com.paulkg12.t61.ui.fragment.ViewerFragment;
import com.paulkg12.t61.util.BundleHelper;
import com.paulkg12.t61.util.StringUtils;

/**
 * Created by ThirtyDegreesRay on 2017/8/19 15:05:44
 */

public class ViewerActivity extends SingleFragmentActivity<IBaseContract.Presenter, ViewerFragment> {

    public enum ViewerType{
        RepoFile, MarkDown, DiffFile, Image, HtmlSource
    }

    public static void showHtmlSource(@NonNull Context context, @NonNull String title,
                                      @NonNull String htmlSource){
        Intent intent = new Intent(context, ViewerActivity.class);
        intent.putExtras(BundleHelper.builder().put("viewerType", ViewerType.HtmlSource)
                .put("title", title).put("source", htmlSource).build());
        context.startActivity(intent);
    }

    public static void showMdSource(@NonNull Context context, @NonNull String title,
                                    @NonNull String mdSource){
        Intent intent = new Intent(context, ViewerActivity.class);
        intent.putExtras(BundleHelper.builder().put("viewerType", ViewerType.MarkDown)
                .put("title", title).put("source", mdSource).build());
        context.startActivity(intent);
    }

    public static void showImage(@NonNull Context context, @NonNull String imageUrl){
        String title = imageUrl.substring(imageUrl.lastIndexOf("/") + 1);
        showImage(context, title, imageUrl);
    }

    public static void showImage(@NonNull Context context, @NonNull String title,
                                 @NonNull String imageUrl){
        Intent intent = new Intent(context, ViewerActivity.class);
        intent.putExtras(BundleHelper.builder().put("viewerType", ViewerType.Image)
                .put("title", title).put("imageUrl", imageUrl).build());
        context.startActivity(intent);
    }

    @AutoAccess ViewerType viewerType;

    @AutoAccess String repoName;

    @AutoAccess String title;
    @AutoAccess String source;

    @AutoAccess String imageUrl;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if(imageUrl != null)
            getMenuInflater().inflate(R.menu.menu_viewer, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        setToolbarTitle(this.title);
    }

    @Override
    protected ViewerFragment createFragment() {
        ViewerFragment fragment = null;
        if (ViewerType.MarkDown.equals(viewerType)){
            fragment = ViewerFragment.createForMd(title, source);
        }
        return fragment;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home)
            return super.onOptionsItemSelected(item);
        if(item.getItemId() == R.id.action_fullscreen){
            intoFullScreen();
            return true;
        }
        String htmlUrl = null;
        if(imageUrl != null) htmlUrl = imageUrl;
        if(!StringUtils.isBlank(htmlUrl)){
            switch (item.getItemId()) {
                case R.id.action_open_in_browser:
                    Toast.makeText(this, "you del me!1", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_share:
                    Toast.makeText(this, "you del me!2", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_copy_url:
                    Toast.makeText(this, "you del me!3", Toast.LENGTH_SHORT).show();
                    return true;
            }
        }

        return super.onOptionsItemSelected(item);
    }
}

