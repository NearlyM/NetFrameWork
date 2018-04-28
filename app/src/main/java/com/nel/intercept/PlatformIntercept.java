package com.nel.intercept;

import java.io.IOException;

import okhttp3.Request;
import okhttp3.Response;

/**
 * Description :
 * CreateTime : 2018/4/28 10:30
 *
 * @author ningerlei@danale.com
 * @version <v1.0>
 */

public class PlatformIntercept implements AbsIntercept {

    @Override
    public Response intercept(Chain chain) throws IOException {
        //TODO 网络异常可以先从本地缓存中检测有历史记录，返回历史，否则返回网络error
        //TODO 对拦截到的request or response做处理
        //TODO 对当前请求的合法性做检测，例如dns是否成功，端口的重试。
        Request request = chain.request();
        Request newRequest = request.newBuilder().header("User-Agent", "Your-App-Name")
                .header("Accept", "application/vnd.yourapi.v1.full+json")
                .method(request.method(), request.body())
                .build();

        return chain.proceed(newRequest);
    }

    @Override
    public boolean executeDns() {
        //TODO dns栈里面如果没有要请求的域名，则去请求dns，且阻塞次操作，待解析结果回来再继续执行
        return true;
    }

    @Override
    public boolean executePortRetry() {
        return true;
    }
}
