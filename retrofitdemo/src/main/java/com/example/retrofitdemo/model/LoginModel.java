package com.example.retrofitdemo.model;

import com.example.retrofitdemo.prsenter.LoginPresenter;

/**
 * Created by Administrator on 2016/7/28.
 * 登录接口
 */
public interface LoginModel {
    //void login(String username,String password,OnLoginListener onLoginListener);
     void login(String username,String password,OnLoginListener onLoginListener);

}
