package com.nel.okhttp.client;

import okhttp3.OkHttpClient;

/**
 * Created by ningerlei on 18-4-27.
 */

public interface CustomOkhttpClientInterface {
    int TIMEOUT_CONNECT = 6000;
    int TIMEOUT_READ = 6000;
    int TIMEOUT_WRITE = 6000;

    OkHttpClient newOkHttpClient();
}
