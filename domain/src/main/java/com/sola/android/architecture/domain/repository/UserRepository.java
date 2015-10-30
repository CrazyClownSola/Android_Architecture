package com.sola.android.architecture.domain.repository;

import com.sola.android.architecture.domain.User;

import java.util.List;

import rx.Observable;

/**
 * 过渡接口，在ApplicationComponent中存在的实例
 * author: Sola
 * 2015/10/30
 */
public interface UserRepository {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    // ===========================================================
    // Methods
    // ===========================================================

    Observable<List<User>> getUsers();

}
