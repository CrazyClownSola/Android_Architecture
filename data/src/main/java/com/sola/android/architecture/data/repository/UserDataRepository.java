package com.sola.android.architecture.data.repository;

import com.sola.android.architecture.data.entity.mapper.UserEntityDataMapper;
import com.sola.android.architecture.data.net.ApiConnection;
import com.sola.android.architecture.data.net.RestApi;
import com.sola.android.architecture.data.repository.factory.UserDataFactory;
import com.sola.android.architecture.data.repository.factory.UserDataStore;
import com.sola.android.architecture.domain.User;
import com.sola.android.architecture.domain.repository.UserRepository;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

/**
 * author: Sola
 * 2015/10/30
 */

public class UserDataRepository implements UserRepository {

    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    final UserDataFactory mFactory;

    final UserEntityDataMapper dataMapper;


    // ===========================================================
    // Constructors
    // ===========================================================

    @Inject
    public UserDataRepository(UserDataFactory mFactory, UserEntityDataMapper dataMapper) {
        this.mFactory = mFactory;
        this.dataMapper = dataMapper;
    }

    // ===========================================================
    // Getter & Setter
    // ===========================================================

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================
    @Override
    public Observable<List<User>> getUsers() {
//        final UserDataStore dataStore = mFactory.createCloudDataStore();
//        return dataStore.userEntities().map(
//                dataMapper::transform
//        );
        return ApiConnection.createService(RestApi.class).userEntityList().map(
                dataMapper::transform
        );

    }
    // ===========================================================
    // Methods
    // ===========================================================

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

}
