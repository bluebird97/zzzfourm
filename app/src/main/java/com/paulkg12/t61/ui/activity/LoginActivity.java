package com.paulkg12.t61.ui.activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.paulkg12.t61.AppConfig;
import com.paulkg12.t61.R;
import com.paulkg12.t61.inject.component.AppComponent;
import com.paulkg12.t61.inject.component.DaggerActivityComponent;
import com.paulkg12.t61.inject.module.ActivityModule;
import com.paulkg12.t61.mvp.contract.ILoginContract;
import com.paulkg12.t61.mvp.model.BasicToken;
import com.paulkg12.t61.mvp.presenter.LoginPresenter;
import com.paulkg12.t61.ui.activity.base.BaseActivity;
//import com.paulkg12.t61.util.AppOpener;
import com.paulkg12.t61.util.StringUtils;
import com.paulkg12.t61.util.ViewUtils;
import com.unstoppable.submitbuttonview.SubmitButton;

import butterknife.BindView;
import butterknife.OnClick;
//import es.dmoral.toasty.Toasty;
public class LoginActivity extends BaseActivity<LoginPresenter>
        implements ILoginContract.View {

    private final String TAG = "TTTAG";


    @BindView(R.id.login_bn) SubmitButton loginBn;
    private String userName = AppConfig.USER_NAME;
    private String password = AppConfig.USER_PASS;

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        mPresenter.handleOauth(intent);
        setIntent(null);
    }

    @Override
    public void onGetTokenSuccess(BasicToken basicToken) {
        loginBn.doResult(true);
        mPresenter.getUserInfo(basicToken);
    }

    @Override
    public void onGetTokenError(String errorMsg) {
        loginBn.doResult(false);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loginBn.reset();
                loginBn.setEnabled(true);
            }
        }, 1000);
        showToast(errorMsg);
    }

    @Override
    public void onLoginComplete() {
        delayFinish();
        Log.d("TAGTT", "Go directly to issueAty");
        IssuesActivity.showForRepo(this, "bluebird97", "zzzfourm");
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
        return R.layout.activity_login;
    }

    /**
     * 初始化view
     *
     * @param savedInstanceState
     */

    @Override
   protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        loginBn.setOnResultEndListener(new SubmitButton.OnResultEndListener() {
            @Override
            public void onResultEnd() {

            }
        });
    }

    @OnClick(R.id.login_bn)
    public void onLoginClick(){
        loginBn.setEnabled(false);
        mPresenter.basicLogin(userName, password);
        Log.d(TAG, "onLoginClick: TTT");
    }
}
