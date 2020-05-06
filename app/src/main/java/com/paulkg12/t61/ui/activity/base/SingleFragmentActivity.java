package com.paulkg12.t61.ui.activity.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.paulkg12.t61.R;
import com.paulkg12.t61.inject.component.AppComponent;
import com.paulkg12.t61.mvp.contract.base.IBaseContract;
import com.paulkg12.t61.ui.fragment.base.BaseFragment;

public abstract class SingleFragmentActivity<P extends IBaseContract.Presenter, F extends Fragment>
        extends BaseDrawerActivity<P> implements IBaseContract.View{

    private F mFragment;
    private final String FRAGMENT_TAG = "mFragment";

    @Override
    protected int getContentView() {
        return R.layout.activity_single_fragment;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        setToolbarBackEnable();
        Fragment temp = getSupportFragmentManager().findFragmentByTag(FRAGMENT_TAG);
        if(temp == null){
            mFragment = createFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, mFragment, FRAGMENT_TAG)
                    .commit();
            Log.d("TTTAG", "initView: temp fragment is null");
        } else {
            mFragment = (F) temp;
            Log.d("TTTAG", "initView: temp fragment not null");
        }
    }

    protected abstract F createFragment();

    protected F getFragment(){
        return mFragment;
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        Log.d("TTTAG","onAttachFragment");
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {

    }

    @Override
    protected void onToolbarDoubleClick() {
        super.onToolbarDoubleClick();
        if (mFragment instanceof BaseFragment){
            ((BaseFragment)mFragment).scrollToTop();
        }
    }
}
