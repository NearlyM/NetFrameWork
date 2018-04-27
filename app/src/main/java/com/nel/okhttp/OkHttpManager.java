package com.nel.okhttp;

import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by ningerlei@outlook.com on 18-4-27.
 */

public class OkHttpManager {

    private static final int TIMEOUT_CONNECT = 6000;
    private static final int TIMEOUT_READ = 6000;
    private static final int TIMEOUT_WRITE = 6000;

    private volatile static OkHttpManager instance;

    private OkHttpClient mOkHttpClient;

    private OkHttpManager(){
        mOkHttpClient = new OkHttpClient.Builder()
                .connectTimeout(TIMEOUT_CONNECT, TimeUnit.MILLISECONDS)
                .readTimeout(TIMEOUT_READ, TimeUnit.MILLISECONDS)
                .writeTimeout(TIMEOUT_WRITE, TimeUnit.MILLISECONDS)
                .build();
    }

    public static OkHttpManager getInstance() {
        if (instance == null) {
            synchronized (OkHttpManager.class) {
                if (instance == null) {
                    instance = new OkHttpManager();
                }
            }
        }

        return instance;
    }

    public void asnyRequest() {
        Request request = new Request.Builder().build();
        Call call = mOkHttpClient.newCall(request);
    }
}
