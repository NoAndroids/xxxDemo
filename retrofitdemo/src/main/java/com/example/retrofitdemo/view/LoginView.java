package com.example.retrofitdemo.view;

import com.example.retrofitdemo.Bean;

/**
 * Created by Administrator on 2016/7/28.
 * view 层
 * 登录界面  应该实现的功能
 * 1. 登录成功后
 * 2.登录失败后的提示
 * 3.获取用户名 和 密码
 * 4. 。。。
 */
public interface LoginView {
    //登录成功后跳转
    void moveToNext(Bean bean);
    //提示信息
    void hint(String msg);
    //获取用户名
    String getUserName();
    //获取密码
    String getPassWord();
}
