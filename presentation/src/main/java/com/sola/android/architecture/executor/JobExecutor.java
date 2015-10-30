package com.sola.android.architecture.executor;

import com.sola.android.architecture.domain.executor.ThreadExecutor;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

/**
 * author: Sola
 * 2015/10/28
 */
public class JobExecutor implements ThreadExecutor {

    // ===========================================================
    // Constants
    // ===========================================================

    // 池中保存的线程数，包括空闲线程
    private static final int INITIAL_POOL_SIZE = 3;
    // 线程池允许的最大线程数
    private static final int MAX_POOL_SIZE = 5;
    // 当线程数大于核心时，此为终止前多余的空闲线程等待新任务的最长时间。
    private static final int KEEP_ALIVE_TIME = 10;
    // 参数的时间单位
    private static final TimeUnit KEEP_ALIVE_TIME_UNIT = TimeUnit.SECONDS;

    // ===========================================================
    // Fields
    // ===========================================================

    // 在线程执行前，用于保存任务的队列。
    private final BlockingDeque<Runnable> workQueue;

    // 线程工厂
    private final ThreadFactory threadFactory;

    // 线程池实例
    private final ThreadPoolExecutor threadPoolExecutor;

    // ===========================================================
    // Constructors
    // ===========================================================

    @Inject
    public JobExecutor() {
        workQueue = new LinkedBlockingDeque<>();
        threadFactory = new JobThreadFactory();
        threadPoolExecutor = new ThreadPoolExecutor(
                INITIAL_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, KEEP_ALIVE_TIME_UNIT,
                workQueue,
                threadFactory
        );
    }


    // ===========================================================
    // Getter & Setter
    // ===========================================================

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    @Override
    public void execute(Runnable command) {
        if (command == null)
            throw new IllegalArgumentException("Runnable to execute cannot be null");
        threadPoolExecutor.execute(command);
    }

    // ===========================================================
    // Methods
    // ===========================================================

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

    private class JobThreadFactory implements ThreadFactory {

        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, "Android_");
        }
    }

}
