package com.nel.okhttp;

import com.nel.annotation.ClientTypeValue;
import com.nel.annotation.ClientType;
import com.nel.okhttp.client.DefaultOkHttpClient;
import com.nel.okhttp.client.SafeOkHttpClient;

import okhttp3.OkHttpClient;

/**
 * Created by ningerlei@outlook.com on 18-4-27.
 */

public class OkHttpClientFactory {

    private volatile static OkHttpClientFactory instance;

    private OkHttpClient mOkHttpClient;

    private OkHttpClientFactory(@ClientType int type){
        if (type == ClientTypeValue.UNSAFE_HTTPS) {
            mOkHttpClient = new DefaultOkHttpClient().newOkHttpClient();
        } else if (type == ClientTypeValue.SAFE_HTTPS) {
            mOkHttpClient = new SafeOkHttpClient().newOkHttpClient();
        } else {
            mOkHttpClient = new DefaultOkHttpClient().newOkHttpClient();
        }
    }

    public static OkHttpClient create(@ClientType int type) {
        if (instance == null) {
            synchronized (OkHttpClientFactory.class) {
                if (instance == null) {
                    instance = new OkHttpClientFactory(type);
                }
            }
        }

        return instance.mOkHttpClient;
    }
}
