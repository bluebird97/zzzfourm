package com.paulkg12.t61.mvp.contract.base;

public interface IBaseListContract {

    interface View {
        void showLoadError(String errorMsg);

        void setCanLoadMore(boolean canLoadMore);
    }

}
