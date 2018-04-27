package com.nel.okhttp.client;

import okhttp3.OkHttpClient;

/**
 * Created by ningerlei on 18-4-27.
 */

public class DefaultOkHttpClient implements CustomOkhttpClientInterface {

    @Override
    public OkHttpClient newOkHttpClient() {
        OkHttpClient client = new OkHttpClient.Builder()
                .build();
        return client;
    }
}
