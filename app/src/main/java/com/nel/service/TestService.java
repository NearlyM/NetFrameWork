package com.nel.service;

import com.nel.annotation.Host;
import com.nel.base.BaseRequest;
import com.nel.base.BaseResponse;
import com.nel.base.BaseService;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Description :
 * CreateTime : 2018/4/28 9:49
 *
 * @author ningerlei@danale.com
 * @version <v1.0>
 */

@Host("www.baidu.com")
public interface TestService extends BaseService {

    @POST("")
    Observable<BaseResponse> get(@Body BaseRequest request);
}
