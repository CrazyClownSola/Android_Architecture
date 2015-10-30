package com.sola.android.architecture;

import android.app.Application;

import com.sola.android.architecture.internal.di.components.ApplicationComponent;
import com.sola.android.architecture.internal.di.components.DaggerApplicationComponent;
import com.sola.android.architecture.internal.di.modules.ApplicationModule;

/**
 * author: Sola
 * 2015/10/28
 */
public class MainApplication extends Application {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    ApplicationComponent applicationComponent;

    // ===========================================================
    // Constructors
    // ===========================================================

    // ===========================================================
    // Getter & Setter
    // ===========================================================

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    @Override
    public void onCreate() {
        super.onCreate();
        // 构建Application组件，在组件build的时候，会将Module中标注@Provide的参数进行实例绑定和创建
        // 同时提供给所有向ApplicationComponent，inject自己的
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }


    // ===========================================================
    // Methods
    // ===========================================================

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

}
