package com.nel.exception;

/**
 * Description :
 * CreateTime : 2018/4/28 10:14
 *
 * @author ningerlei@danale.com
 * @version <v1.0>
 */

public class PlatformApiError extends RuntimeException {

    private int code;

    public PlatformApiError(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
