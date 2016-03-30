package com.sola.android.architecture.internal.di.modules;

import android.content.Context;

import com.sola.android.architecture.MainApplication;
import com.sola.android.architecture.data.repository.UserDataRepository;
import com.sola.android.architecture.domain.executor.PostExecutionThread;
import com.sola.android.architecture.domain.executor.ThreadExecutor;
import com.sola.android.architecture.domain.repository.UserRepository;
import com.sola.android.architecture.executor.JobExecutor;
import com.sola.android.architecture.executor.UIThread;
import com.sola.android.architecture.navigator.Navigator;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * author: Sola
 * 2015/10/28
 */
@Module
// Module的作用是针对@Component进行实例的提供和绑定
// 由于此类是针对于Application而写的，所以此类中提供的实例 依附于Application的生命周期而存在
// 通常这里实例化一些全局向的变量
public class ApplicationModule {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    private final MainApplication mApplication;

    // ===========================================================
    // Constructors
    // ===========================================================

    public ApplicationModule(MainApplication mApplication) {
        this.mApplication = mApplication;
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
    @Singleton
    Context provideApplication() {
        return mApplication;
    }

    /**
     * 提供给RxJava使用的Android的主线程
     *
//     * @param thread 主线程实例
     * @return 返回实例
     */
    @Provides
    @Singleton
    PostExecutionThread provideExecutionThread() {
        return new UIThread();
    }


    /**
     * 提供给RxJava使用的线程池
     *

     * @return 实例
     */
    @Provides
    @Singleton
    ThreadExecutor provideThreadExecutor() {
        return new JobExecutor();
    }

    @Provides
    @Singleton
    Navigator provideNavigator() {
        return new Navigator();
    }

    @Provides
    @Singleton
    UserRepository provideUserRepository(UserDataRepository repository) {
        return repository;
    }

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

}
