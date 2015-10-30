package com.sola.android.architecture.view.interactor;

import android.animation.AnimatorSet;
import android.view.View;


/**
 * Description:
 * <p/>
 * author: Sola
 * 2015/9/25
 */
public interface IRecycleAnimatorListItem extends IRecycleListItem {
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
     * 获取每一项加载的时候的动画效果
     *
     */
    AnimatorSet getAnimatorSet(View view);

}
