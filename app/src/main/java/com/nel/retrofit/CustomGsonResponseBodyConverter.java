package com.nel.retrofit;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.nel.base.BaseResponse;
import com.nel.exception.PlatformApiError;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Description :
 * CreateTime : 2018/4/28 10:08
 *
 * @author ningerlei@danale.com
 * @version <v1.0>
 */

public class CustomGsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {

    private final Gson gson;
    private final TypeAdapter<T> adapter;

    public CustomGsonResponseBodyConverter(Gson gson, TypeAdapter<T> adapter) {
        this.gson = gson;
        this.adapter = adapter;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        BaseResponse baseResponse = gson.fromJson(value.string(), BaseResponse.class);
        try {
            if (baseResponse.isSuccess()) {
                return adapter.fromJson(value.string());
            } else {
                throw new PlatformApiError(baseResponse.getCode());
            }
        } finally {
            value.close();
        }
    }
}
