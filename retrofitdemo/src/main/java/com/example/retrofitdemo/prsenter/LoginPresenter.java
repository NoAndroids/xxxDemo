package com.example.retrofitdemo.prsenter;

import com.example.retrofitdemo.Bean;
import com.example.retrofitdemo.model.LoginModel;
import com.example.retrofitdemo.model.OnLoginListener;
import com.example.retrofitdemo.model.imple.LoginModelImple;
import com.example.retrofitdemo.view.LoginView;

/**
 * Created by Administrator on 2016/7/29.
 * 实现 model 和 view
 * 用于  2者直接的通信
 */
public class LoginPresenter {
    LoginModel loginModel;
    LoginView loginView;

    public LoginPresenter( LoginView loginView) {
        this.loginModel = new LoginModelImple();
        this.loginView = loginView;
    }
    public void Login(){
        String username=loginView.getUserName();
        String password=loginView.getPassWord();
        loginModel.login(username, password, new OnLoginListener() {
            @Override
            public void onUserNameError() {

            }

            @Override
            public void onPassWordError() {

            }

            @Override
            public void onSuccess(Bean bean) {
                loginView.moveToNext(bean);
            }

            @Override
            public void onFail() {
               loginView.hint("shibai");
            }
        });
    }


}
