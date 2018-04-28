package com.nel.intercept;

import okhttp3.Interceptor;

/**
 * Description :
 * CreateTime : 2018/4/28 10:28
 *
 * @author ningerlei@danale.com
 * @version <v1.0>
 */

public interface AbsIntercept extends Interceptor {

    boolean executeDns();

    boolean executePortRetry();
}
