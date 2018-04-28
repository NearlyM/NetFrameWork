package com.nel.okhttp.client;

import com.nel.intercept.PlatformIntercept;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by ningerlei@outlook.com on 18-4-27.
 */

public class SafeOkHttpClient implements CustomOkhttpClientInterface {

    @Override
    public OkHttpClient newOkHttpClient() {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(TIMEOUT_CONNECT, TimeUnit.MILLISECONDS)
                .readTimeout(TIMEOUT_READ, TimeUnit.MILLISECONDS)
                .writeTimeout(TIMEOUT_WRITE, TimeUnit.MILLISECONDS)
                .addInterceptor(new PlatformIntercept())
                .build();
        return client;
    }
}
