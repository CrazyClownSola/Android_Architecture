package com.sola.android.architecture.internal.di.components;

import android.app.Activity;

import com.sola.android.architecture.domain.interactor.GetUserList;
import com.sola.android.architecture.domain.interactor.UserCase;
import com.sola.android.architecture.internal.di.PerActivity;
import com.sola.android.architecture.internal.di.modules.ActivityModule;
import com.sola.android.architecture.internal.di.modules.DataModule;
import com.sola.android.architecture.mapper.UserModelDataMapper;
import com.sola.android.architecture.ui.ListActivity;

import javax.inject.Named;

import dagger.Component;

/**
 * author: Sola
 * 2015/10/30
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class,
        modules = {ActivityModule.class, DataModule.class})
public interface DataComponent extends ActivityComponent {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    // ===========================================================
    // Methods
    // ===========================================================

    @Named("UserList")
    UserCase getUserCase();

    UserModelDataMapper getModelMapper();
}
