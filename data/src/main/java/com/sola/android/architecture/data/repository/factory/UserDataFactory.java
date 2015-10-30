package com.sola.android.architecture.data.repository.factory;

import com.sola.android.architecture.data.net.ApiConnection;
import com.sola.android.architecture.data.net.RestApi;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * author: Sola
 * 2015/10/30
 */
@Singleton
public class UserDataFactory {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================


    // ===========================================================
    // Constructors
    // ===========================================================

    @Inject
    public UserDataFactory() {
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

    public UserDataStore createCloudDataStore() {
        return new CloudUserDataStore();
    }

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

}
