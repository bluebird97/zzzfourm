package com.paulkg12.t61.ui.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.paulkg12.t61.inject.component.AppComponent;
import com.paulkg12.t61.inject.component.DaggerActivityComponent;
import com.paulkg12.t61.inject.module.ActivityModule;
import com.paulkg12.t61.mvp.contract.ISplashContract;
import com.paulkg12.t61.mvp.presenter.SplashPresenter;
import com.paulkg12.t61.ui.activity.base.BaseActivity;

public class SplashActivity extends BaseActivity<SplashPresenter> implements ISplashContract.View {

    private final String TAG = "SplashActivity";

//    private final int REQUEST_ACCESS_TOKEN = 1;

    @Override
    public void showMainPage() {
        delayFinish();
        Uri dataUri = getIntent().getData();
        if (dataUri == null) {
            IssuesActivity.showForRepo(this, "bluebird97", "zzzfourm");
        } else {
            //BrowserFilterActivity.handleBrowserUri(getActivity(), dataUri);
        }
    }

    @Override
    public void showLoginPage() {
        delayFinish();
        startActivity(new Intent(getActivity(), LoginActivity.class));
    }

    /**
     * 依赖注入的入口
     *
     * @param appComponent appComponent
     */
    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerActivityComponent.builder()
                .appComponent(appComponent)
                .activityModule(new ActivityModule(getActivity()))
                .build()
                .inject(this);
    }

    /**
     * 获取ContentView id
     *
     * @return
     */
    @Override
    protected int getContentView() {
        return 0;
    }

    /**
     * 初始化activity
     */
    @Override
    protected void initActivity() {
        super.initActivity();
        mPresenter.getUser();
    }

    /**
     * 初始化view
     *
     * @param savedInstanceState
     */
    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
    }

    /**
     * Dispatch incoming result to the correct fragment.
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @NonNull Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
//            case REQUEST_ACCESS_TOKEN:
//                if(resultCode == RESULT_OK){
//                    showMainPage();
//                }
//                break;
            default:
                break;
        }
    }

}
