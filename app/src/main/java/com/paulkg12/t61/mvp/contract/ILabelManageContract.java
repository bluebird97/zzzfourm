package com.paulkg12.t61.mvp.contract;

import android.support.annotation.NonNull;

import com.paulkg12.t61.mvp.contract.base.IBaseContract;
import com.paulkg12.t61.mvp.contract.base.IBaseListContract;
import com.paulkg12.t61.mvp.model.Label;

import java.util.ArrayList;

public interface ILabelManageContract {

    interface View extends IBaseContract.View, IBaseListContract.View{
        void showLabels(ArrayList<Label> labels);
        void notifyItemInserted(int position);
        void notifyItemRemoved(int position);
        void notifyItemChanged(int position);
    }

    interface Presenter extends IBaseContract.Presenter<ILabelManageContract.View>{
        void loadLabels(boolean isReload);
        void createLabel(@NonNull Label label);
        void deleteLabel(@NonNull Label label);
        void updateLabel(@NonNull Label oriLabel, @NonNull Label newLabel);
    }

}

