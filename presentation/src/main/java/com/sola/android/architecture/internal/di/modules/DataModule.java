package com.sola.android.architecture.internal.di.modules;

import android.app.Activity;

import com.sola.android.architecture.domain.interactor.GetUserList;
import com.sola.android.architecture.domain.interactor.UserCase;
import com.sola.android.architecture.internal.di.PerActivity;
import com.sola.android.architecture.ui.ListActivity;
import com.sola.android.architecture.ui.ListActivity_;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * author: Sola
 * 2015/10/30
 */
@Module
public class DataModule {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    // ===========================================================
    // Constructors
    // ===========================================================

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
    @Named("UserList")
    UserCase provideUserCase(GetUserList userList) {
        return userList;
    }


    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

}
