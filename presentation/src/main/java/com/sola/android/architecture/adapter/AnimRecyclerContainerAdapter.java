package com.sola.android.architecture.adapter;

import android.animation.AnimatorSet;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;


import com.sola.android.architecture.view.interactor.IRecycleAnimatorListItem;

import java.util.List;

/**
 * Description:
 * <p/>
 * author: Sola
 * 2015/10/14
 */
public class AnimRecyclerContainerAdapter<Param extends IRecycleAnimatorListItem>
        extends RecyclerContainerAdapter<Param> {

    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    private boolean isFirstOnly = true;
    private int mLastPosition = -1;

    // ===========================================================
    // Constructors
    // ===========================================================

    public AnimRecyclerContainerAdapter(Context mContext, List<Param> cacheList) {
        super(mContext, cacheList);
    }

    // ===========================================================
    // Getter & Setter
    // ===========================================================

    public void setIsFirstOnly(boolean isFirstOnly) {
        this.isFirstOnly = isFirstOnly;
    }


    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    @Override
    protected void onBindView(Context mContext, RecyclerView.ViewHolder holder, int position) {
        super.onBindView(mContext, holder, position);
        AnimatorSet animSet = cacheList.get(position).getAnimatorSet(holder.itemView);
        if (animSet != null) {
            if (!isFirstOnly || position > mLastPosition) {
                animSet.start();
                mLastPosition = position;
            } else {
                clear(holder.itemView);
            }
        }
    }

    // ===========================================================
    // Methods
    // ===========================================================

    public void clear(View v) {
        v.setAlpha(1);
        v.setScaleY(1);
        v.setScaleX(1);
        v.setTranslationY(0);
        v.setTranslationX(0);
        v.setRotation(0);
        v.setRotationY(0);
        v.setRotationX(0);
        v.setPivotY(v.getMeasuredHeight() / 2);
        v.setPivotX(v.getMeasuredWidth() / 2);
    }
    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

}
