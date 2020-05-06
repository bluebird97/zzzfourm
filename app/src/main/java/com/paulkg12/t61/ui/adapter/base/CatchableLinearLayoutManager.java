package com.paulkg12.t61.ui.adapter.base;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;

public class CatchableLinearLayoutManager extends LinearLayoutManager {

        public CatchableLinearLayoutManager(Context context) {
            super(context);
        }

        public CatchableLinearLayoutManager(Context context, int orientation, boolean reverseLayout) {
            super(context, orientation, reverseLayout);
        }

        public CatchableLinearLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
            super(context, attrs, defStyleAttr, defStyleRes);
        }

        @Override
        public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
            /*
             * Error:
             * java.lang.IndexOutOfBoundsException.
             * Inconsistency detected. Invalid view holder adapter positionViewHolder
             * {ab35ef7 position=13 id=-1, oldPos=-1, pLpos:-1 no parent}
             *
             * Solution：
             * This problem is caused by RecyclerView Data modified in different thread.
             * The best way is checking all data access.
             * Or add add catch to avoid this error.
             */
            try {
                super.onLayoutChildren(recycler, state);
            } catch (IndexOutOfBoundsException e){
                Log.d("TTTAG", "onLayoutChildren: meet a IndexOutOfBoundsException in RecyclerView");
            }
        }
}
