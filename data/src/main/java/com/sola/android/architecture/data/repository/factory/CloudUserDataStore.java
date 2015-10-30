package com.sola.android.architecture.data.repository.factory;

import com.sola.android.architecture.data.entity.UserEntity;
import com.sola.android.architecture.data.net.ApiConnection;
import com.sola.android.architecture.data.net.RestApi;

import java.util.List;

import rx.Observable;

/**
 * author: Sola
 * 2015/10/30
 */
public class CloudUserDataStore implements UserDataStore {

    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    // ===========================================================
    // Constructors
    // ===========================================================

    // ===========================================================
    // Getter & Setter
    // ===========================================================

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================
    @Override
    public Observable<List<UserEntity>> userEntities() {
        return ApiConnection.createService(RestApi.class).userEntityList();
    }
    // ===========================================================
    // Methods
    // ===========================================================

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

}
