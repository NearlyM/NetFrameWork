package com.nel.annotation;

import android.support.annotation.IntDef;

/**
 * Description :
 * CreateTime : 2018/4/28 11:02
 *
 * @author ningerlei@danale.com
 * @version <v1.0>
 */

@IntDef({ClientTypeValue.DEFAULT, ClientTypeValue.UNSAFE_HTTPS, ClientTypeValue.SAFE_HTTPS})
public @interface ClientType {}
