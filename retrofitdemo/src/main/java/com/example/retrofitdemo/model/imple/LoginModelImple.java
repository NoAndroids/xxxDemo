package com.example.retrofitdemo.model.imple;

import com.example.retrofitdemo.Bean;
import com.example.retrofitdemo.HttpUtls;
import com.example.retrofitdemo.LoadBean;
import com.example.retrofitdemo.model.LoginModel;
import com.example.retrofitdemo.model.OnLoginListener;
import com.example.retrofitdemo.prsenter.LoginPresenter;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.exceptions.OnErrorThrowable;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/7/28.
 * 进行数据的加载或者保存
 */
public class LoginModelImple implements LoginModel{
    //修改需求  登录成功后获取 地区
    @Override
    public void login(String username, String password, final OnLoginListener onLoginListener) {
        final HttpUtls.Login login = HttpUtls.getRetrofit().create(HttpUtls.Login.class);
        final HttpUtls.Load load = HttpUtls.getRetrofit().create(HttpUtls.Load.class);
                login.rxLogin(username,password)
                      .flatMap(new Func1<Bean, Observable<LoadBean>>() {
                          @Override
                          public Observable<LoadBean> call(Bean bean) {
                              return load.rxLoad();
                          }
                      })
                        .doOnNext(new Action1<LoadBean>() {
                            @Override
                            public void call(LoadBean loadBean) {

                            }
                        })
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Subscriber<LoadBean>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onNext(LoadBean loadBean) {
                                onLoginListener.onFail();
                            }
                        });
//                        .subscribe(new Subscriber<Bean>() {
//                            @Override
//                            public void onStart() {
//
//                            }
//                            @Override
//                            public void onCompleted() {
//                            }
//                            @Override
//                            public void onError(Throwable e) {
//                                    onLoginListener.onFail();
//                            }
//
//                            @Override
//                            public void onNext(Bean bean) {
//                                   onLoginListener.onSuccess(bean);
//
//                            }
//                        });

    }
}
