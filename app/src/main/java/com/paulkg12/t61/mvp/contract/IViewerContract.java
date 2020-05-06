package com.paulkg12.t61.mvp.contract;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.paulkg12.t61.mvp.contract.base.IBaseContract;

public interface IViewerContract {

    interface View extends IBaseContract.View{
        void loadImageUrl(@NonNull String url);
        void loadMdText(@NonNull String text, @Nullable String baseUrl);
        void loadCode(@NonNull String text, @Nullable String extension);
        void loadDiffFile(@NonNull String text);
        void loadHtmlSource(@NonNull String htmlSource);
    }

    interface Presenter extends IBaseContract.Presenter<IViewerContract.View>{
        void load(boolean isReload);
    }

}
