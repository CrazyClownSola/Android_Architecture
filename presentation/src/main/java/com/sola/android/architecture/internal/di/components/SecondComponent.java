package com.sola.android.architecture.internal.di.components;

import com.sola.android.architecture.internal.di.PerActivity;
import com.sola.android.architecture.internal.di.modules.ActivityModule;
import com.sola.android.architecture.internal.di.modules.SecondModule;
import com.sola.android.architecture.presenter.UserListPresenter;

import dagger.Component;

/**
 * author: Sola
 * 2015/11/2
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class,
        modules = {ActivityModule.class, SecondModule.class})
public interface SecondComponent extends ActivityComponent {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    // ===========================================================
    // Methods
    // ===========================================================

    UserListPresenter getUserListPresenter();

}
