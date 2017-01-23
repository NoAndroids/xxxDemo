package com.example.dagger2demo;

import com.example.dagger2demo.bean.MainModule;

import dagger.Component;

/**
 * Created by Administrator on 2016/8/12.
 */
@Component(modules = MainModule.class) // 作为桥梁，沟通调用者和依赖对象库
public interface MainComponent {
 void inject(MainActivity activity);
}
