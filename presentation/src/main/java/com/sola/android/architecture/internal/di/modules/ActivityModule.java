package com.sola.android.architecture.internal.di.modules;

import android.app.Activity;

import com.sola.android.architecture.internal.di.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * author: Sola
 * 2015/10/28
 */
@Module
public class ActivityModule {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    private final Activity mActivity;

    // ===========================================================
    // Constructors
    // ===========================================================

    public ActivityModule(Activity mActivity) {
        this.mActivity = mActivity;
    }
    // ===========================================================
    // Getter & Setter
    // ===========================================================

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    // ===========================================================
    // Methods
    // ===========================================================

    @Provides
    @PerActivity
    Activity provideActivity() {
        return this.mActivity;
    }

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

}
