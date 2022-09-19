package com.paulkg12.t61.mvp.contract;

import com.paulkg12.t61.mvp.contract.base.IBaseContract;

public interface IFirstPageContract {
    interface View extends IBaseContract.View {
        void onYueyueStart();
    }

    interface Presenter extends IBaseContract.Presenter<IFirstPageContract.View> {
        void yueyueStart();
    }
}
