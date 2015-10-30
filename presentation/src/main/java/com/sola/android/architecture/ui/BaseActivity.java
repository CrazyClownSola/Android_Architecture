package com.sola.android.architecture.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.sola.android.architecture.MainApplication;
import com.sola.android.architecture.internal.di.components.ApplicationComponent;
import com.sola.android.architecture.internal.di.modules.ActivityModule;
import com.sola.android.architecture.navigator.Navigator;

import javax.inject.Inject;

/**
 * author: Sola
 * 2015/10/28
 */
public abstract class BaseActivity extends AppCompatActivity {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    @Inject
    Navigator navigator;

    // ===========================================================
    // Constructors
    // ===========================================================

    // ===========================================================
    // Getter & Setter
    // ===========================================================

    public ApplicationComponent getApplicationComponent() {
        return ((MainApplication) getApplication()).getApplicationComponent();
    }

    public ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getApplicationComponent().inject(this);
    }

    // ===========================================================
    // Methods
    // ===========================================================

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

}
