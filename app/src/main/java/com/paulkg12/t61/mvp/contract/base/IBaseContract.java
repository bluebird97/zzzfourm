package com.paulkg12.t61.mvp.contract.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public interface IBaseContract {
    interface View {
        void showProgressDialog(String content);
        void dismissProgressDialog();
        ProgressDialog getProgressDialog(String content);
        void showInfoToast(String msg);
        void showSuccessToast(String msg);
        void showErrorToast(String message);
        void showWarningToast(String message);
        void showLoading();
        void hideLoading();
        void showLoginPage();
        void showTipDialog(String content);
        void showToast(String message);
        void showConfirmDialog(String msn, String title, String confirmText
                , DialogInterface.OnClickListener confirmListener);

    }
    interface Presenter<V extends IBaseContract.View> {
        void onSaveInstanceState(Bundle outState);

        void onRestoreInstanceState(Bundle outState);

        void attachView(@NonNull V view);

        void detachView();

        /**
         * view initialized, you can init view data
         */
        void onViewInitialized();

        @Nullable Context getContext();
    }
}