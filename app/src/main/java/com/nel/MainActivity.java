package com.nel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.nel.base.BaseRequest;
import com.nel.base.BaseResponse;
import com.nel.okhttp.R;
import com.nel.retrofit.RetrofitFactory;
import com.nel.service.TestService;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         RetrofitFactory
                 .create()
                 .create(TestService.class)
                 .get(new BaseRequest() {})
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseResponse baseResponse) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
