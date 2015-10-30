package com.sola.android.architecture.data.repository.factory;

import com.sola.android.architecture.data.entity.UserEntity;

import java.util.List;

import rx.Observable;

/**
 * author: Sola
 * 2015/10/30
 */
public interface UserDataStore {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    // ===========================================================
    // Methods
    // ===========================================================

    Observable<List<UserEntity>> userEntities();

}
