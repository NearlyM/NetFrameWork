package com.nel.okhttp.client;

import okhttp3.OkHttpClient;

/**
 * Created by ningerlei@outlook.com on 18-4-27.
 */

public class SafeOkHttpClient implements CustomOkhttpClientInterface {

    @Override
    public OkHttpClient newOkHttpClient() {
        OkHttpClient client = new OkHttpClient.Builder().build();
        return client;
    }
}
