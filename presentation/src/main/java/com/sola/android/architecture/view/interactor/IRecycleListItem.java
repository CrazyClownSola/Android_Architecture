package com.sola.android.architecture.view.interactor;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Description:
 * <p/>
 * author: Sola
 * 2015/9/25
 */
public interface IRecycleListItem {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    // ===========================================================
    // Methods
    // ===========================================================


    /**
     * @param context 　控件组件
     */
    View getView(Context context, ViewGroup parent);

    RecyclerView.ViewHolder getHolder(Context context, ViewGroup parent);

    void refreshView(Context context, RecyclerView.ViewHolder holder);

}
