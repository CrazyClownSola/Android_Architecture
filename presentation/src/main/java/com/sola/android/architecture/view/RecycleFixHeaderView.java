package com.sola.android.architecture.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sola.android.architecture.R;
import com.sola.module.recycle.fix_container.RecyclerContainerBase;
import com.sola.module.recycle.fix_container.tools.IPullToRefreshUIHandler;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

/**
 * Description:
 * <p>
 * author: Sola
 * 2015/10/19
 */
@EViewGroup(R.layout.layout_progress_bar)
public class RecycleFixHeaderView extends LinearLayout implements IPullToRefreshUIHandler {


    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================
    @ViewById
    ImageView id_image_loading_inner;

    @ViewById
    ImageView id_image_loading;

    @ViewById
    TextView id_text_progress_message;

    AnimatorSet set;

    Animator rotation;

    RotateAnimation mFlipAnimation;

    // ===========================================================
    // Constructors
    // ===========================================================
    public RecycleFixHeaderView(Context context) {
        this(context, null);
    }

    public RecycleFixHeaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mFlipAnimation = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
        mFlipAnimation.setInterpolator(new LinearInterpolator());
        mFlipAnimation.setDuration(1500);
        mFlipAnimation.setFillAfter(true);
        mFlipAnimation.setRepeatCount(Animation.INFINITE);
    }
    // ===========================================================
    // Getter & Setter
    // ===========================================================

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================
    @Override
    public void onUIReset(RecyclerContainerBase frame) {
    }

    @Override
    public void onUIRefreshPrepare(RecyclerContainerBase frame) {
        id_image_loading.setVisibility(View.INVISIBLE);
        id_text_progress_message.setText("下拉即可刷新");
    }

    @Override
    public void onUIRefreshBegin(RecyclerContainerBase frame) {
        id_image_loading.setVisibility(View.VISIBLE);
        id_text_progress_message.setText("正在加载，请稍候");
//        set.start();
        id_image_loading.clearAnimation();
        id_image_loading.startAnimation(mFlipAnimation);
    }

    @Override
    public void onUIRefreshComplete(RecyclerContainerBase frame) {
        id_image_loading.setVisibility(View.INVISIBLE);
        id_text_progress_message.setText("更新完毕");
//        set.cancel();
        id_image_loading.clearAnimation();
    }

    @Override
    public void onUIPositionChange(RecyclerContainerBase frame, boolean isUnderTouch, byte status, int currentPos, int lastPos, int offsetHeight) {

        if (currentPos < offsetHeight && lastPos >= offsetHeight) {
            if (isUnderTouch && status == 2) {
                this.crossRotateLineFromBottomUnderTouch(frame);

            }
        } else if (currentPos > offsetHeight && lastPos <= offsetHeight && isUnderTouch && status == 2) {
            this.crossRotateLineFromTopUnderTouch(frame);
        }
    }

    // ===========================================================
    // Methods
    // ===========================================================
    private void crossRotateLineFromBottomUnderTouch(RecyclerContainerBase frame) {
        id_image_loading.setVisibility(View.INVISIBLE);
        id_text_progress_message.setText("往下拉");
    }

    private void crossRotateLineFromTopUnderTouch(RecyclerContainerBase frame) {
        id_image_loading.setVisibility(View.INVISIBLE);
        id_text_progress_message.setText("松开即可更新");
    }

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

}
