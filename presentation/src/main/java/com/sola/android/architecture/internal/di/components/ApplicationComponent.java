package com.sola.android.architecture.internal.di.components;

import android.app.Activity;
import android.content.Context;

import com.sola.android.architecture.domain.executor.PostExecutionThread;
import com.sola.android.architecture.domain.executor.ThreadExecutor;
import com.sola.android.architecture.domain.repository.UserRepository;
import com.sola.android.architecture.internal.di.modules.ApplicationModule;
import com.sola.android.architecture.ui.BaseActivity;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Provides;

/**
 * author: Sola
 * 2015/10/28
 */
@Singleton //单例
//定义这个接口为基础组件，提供给Dagger去创建响应的组件类
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    // ===========================================================
    // Methods
    // ===========================================================

    /**
     * 提供给组件内部的成员向Application注册自身
     *
     * @param activity 需要向组件注册的 Activity成员实例
     */
    void inject(BaseActivity activity);

    //下面需要定义一些生命周期跟随这个Application走的全局变量get方法

    /**
     * @return 返回Application实例
     */
    Context getContext();

    //当ApplicationComponent的下一层组件需要用到一些实例的时候这边需要给出接口

    /**
     * @return 线程队列的实例
     */
    ThreadExecutor getThreadExecutor();

    /**
     * @return UI主线程的实例
     */
    PostExecutionThread getPostExecutionThread();


    UserRepository userRepository();

}
