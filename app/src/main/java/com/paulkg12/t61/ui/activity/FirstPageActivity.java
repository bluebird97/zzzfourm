package com.paulkg12.t61.ui.activity;

import com.paulkg12.t61.R;
import com.paulkg12.t61.inject.component.AppComponent;
import com.paulkg12.t61.inject.component.DaggerActivityComponent;
import com.paulkg12.t61.inject.module.ActivityModule;
import com.paulkg12.t61.mvp.contract.IFirstPageContract;
import com.paulkg12.t61.mvp.presenter.FirstPagePresenter;
import com.paulkg12.t61.ui.activity.base.BaseActivity;

public class FirstPageActivity extends BaseActivity<FirstPagePresenter>
        implements IFirstPageContract.View {

    @Override
    public void onYueyueStart() {
        System.out.println("FirstPage: Activity: yueyue start");
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerActivityComponent.builder()
                .appComponent(appComponent)
                .activityModule(new ActivityModule(getActivity()))
                .build()
                .inject(this);
    }


    @Override
    protected int getContentView() {
        return R.layout.activity_first_page;
    }
}
