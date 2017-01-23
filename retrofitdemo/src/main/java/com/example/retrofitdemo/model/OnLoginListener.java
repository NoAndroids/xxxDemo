package com.example.retrofitdemo.model;

import com.example.retrofitdemo.Bean;

/**
 * Created by Administrator on 2016/7/28.
 * 登录的回调
 * 用来描述model后的结果
 */
public interface OnLoginListener {
    //用户名错误
    void onUserNameError();
    //密码错误
    void onPassWordError();

    //成功
    void onSuccess(Bean bean);
    //其他错误
    void onFail();

    //void onData(Bean bean);
}
