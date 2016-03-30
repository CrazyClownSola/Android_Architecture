package com.sola.android.architecture.data.net;

import com.sola.android.architecture.data.entity.UserEntity;

import java.util.List;

import retrofit.http.Field;
import retrofit.http.GET;
import retrofit.http.Headers;
import rx.Observable;

/**
 * author: Sola
 * 2015/10/30
 */
public interface RestApi {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    static final String CONTENT_TYPE_LABEL = "Content-Type";
    static final String CONTENT_TYPE_VALUE_JSON = "application/json; charset=utf-8";

    // ===========================================================
    // Methods
    // ===========================================================
    @Headers("Content-Type : application/json; charset=utf-8")
    @GET("/myapi/users.json")
    Observable<List<UserEntity>> userEntityList();

}
