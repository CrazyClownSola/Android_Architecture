package com.sola.android.architecture.test;

import com.sola.android.architecture.domain.executor.ThreadExecutor;
import com.sola.android.architecture.internal.di.PerActivity;

import java.util.Random;

import javax.inject.Inject;

/**
 * author: Sola
 * 2015/10/29
 */
public class MyInjectClass {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    int count;

    final ThreadExecutor threadExecutor;

    // ===========================================================
    // Constructors
    // ===========================================================

    //    @Inject
    public MyInjectClass(ThreadExecutor threadExecutor) {
        count = new Random().nextInt(100);
        this.threadExecutor = threadExecutor;
    }


    // ===========================================================
    // Getter & Setter
    // ===========================================================

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + count;
    }


    // ===========================================================
    // Methods
    // ===========================================================

    public void execute(Runnable r) {
        threadExecutor.execute(r);
    }

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

}
