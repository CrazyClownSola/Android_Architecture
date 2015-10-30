package com.sola.android.architecture.domain.interactor;

import com.sola.android.architecture.domain.executor.PostExecutionThread;
import com.sola.android.architecture.domain.executor.ThreadExecutor;
import com.sola.android.architecture.domain.repository.UserRepository;

import javax.inject.Inject;

import rx.Observable;

/**
 * author: Sola
 * 2015/10/30
 */
public class GetUserList extends UserCase {


    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================
    final UserRepository userRepository;

    // ===========================================================
    // Constructors
    // ===========================================================
    @Inject
    protected GetUserList(
            UserRepository repository,
            ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        userRepository = repository;
    }
    // ===========================================================
    // Getter & Setter
    // ===========================================================

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================
    @Override
    protected Observable buildUseCaseObservable() {
        return userRepository.getUsers();
    }
    // ===========================================================
    // Methods
    // ===========================================================

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

}
