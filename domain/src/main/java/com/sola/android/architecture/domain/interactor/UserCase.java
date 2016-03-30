package com.sola.android.architecture.domain.interactor;

import com.sola.android.architecture.domain.executor.PostExecutionThread;
import com.sola.android.architecture.domain.executor.ThreadExecutor;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

/**
 * author: Sola
 * 2015/10/30
 */
public abstract class UserCase {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    final ThreadExecutor threadExecutor;
    final PostExecutionThread postExecutionThread;

    private Subscription subscription = Subscriptions.empty();


    // ===========================================================
    // Constructors
    // ===========================================================

    protected UserCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
    }

    // ===========================================================
    // Getter & Setter
    // ===========================================================

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    protected abstract Observable buildUseCaseObservable();

    // ===========================================================
    // Methods
    // ===========================================================

    @SuppressWarnings("unchecked")
    public void execute(Subscriber UseCaseSubscriber) {
//        Observable o ;
//        o.subscribeOn(Schedulers.from(threadExecutor))
//                .subscribe();
//
        this.subscription = this.buildUseCaseObservable()
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.getScheduler())
                .subscribe(UseCaseSubscriber);
    }


    /**
     * Unsubscribes from current {@link rx.Subscription}.
     */
    public void unsubscribe() {
        if (!subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }
    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

}
