package com.nel.retrofit;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.nel.annotation.ClientTypeValue;
import com.nel.okhttp.OkHttpClientFactory;

import retrofit2.Retrofit;

/**
 * Description :
 * CreateTime : 2018/4/28 9:14
 *
 * @author ningerlei@danale.com
 * @version <v1.0>
 */

public class RetrofitFactory {

    private static volatile RetrofitFactory instance;

    private Retrofit mRetrofit;

    private RetrofitFactory() {
        mRetrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(CustomGsonConverterFactory.create())
                .client(OkHttpClientFactory.create(ClientTypeValue.DEFAULT))
                .build();
    }

    private static RetrofitFactory getInstance() {
        if (instance == null) {
            synchronized (RetrofitFactory.class) {
                if (instance == null) {
                    instance = new RetrofitFactory();
                }
            }
        }
        return instance;
    }

    public static Retrofit create() {
        return getInstance().mRetrofit;
    }
}
