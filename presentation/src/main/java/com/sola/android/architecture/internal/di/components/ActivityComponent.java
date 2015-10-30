package com.sola.android.architecture.internal.di.components;

import android.app.Activity;

import com.sola.android.architecture.internal.di.PerActivity;
import com.sola.android.architecture.internal.di.modules.ActivityModule;

import dagger.Component;

/**
 * author: Sola
 * 2015/10/28
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class,modules = ActivityModule.class)
public interface ActivityComponent {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    // ===========================================================
    // Methods
    // ===========================================================

    Activity getActivity();

}
