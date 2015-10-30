package com.sola.android.architecture.data.net;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.OkHttpClient;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * author: Sola
 * 2015/10/30
 */
public class ApiConnection {
    // ===========================================================
    // Constants
    // ===========================================================

    public static final String API_BASE_URL = "http://www.android10.org/";

    // ===========================================================
    // Fields
    // ===========================================================

    private static OkHttpClient httpClient = new OkHttpClient();
    private static Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
            .create();

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                            //添加对于RxJava的适用，致使可以在Api接口当中直接使用Rxjava
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                            //直接使用Gson转换进行对于参数的适配
                    .addConverterFactory(GsonConverterFactory.create(gson));

    // ===========================================================
    // Constructors
    // ===========================================================

    // ===========================================================
    // Getter & Setter
    // ===========================================================

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    // ===========================================================
    // Methods
    // ===========================================================
    public static <S> S createService(Class<S> serviceClass) {
        Retrofit retrofit = builder.client(httpClient).build();
        return retrofit.create(serviceClass);
    }
    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================

}
