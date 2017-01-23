package com.example.dagger2demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.dagger2demo.bean.MainModule;
import com.example.dagger2demo.bean.Person;

import javax.inject.Inject;

import dagger.internal.DaggerCollections;

public class MainActivity extends AppCompatActivity {
/**
 * dagger2 可以创建依赖对象  不用自己手动创建
 *Dagger2的目的是将程序分为三个部分。
 - 实例化部分：对象的实例化。类似于容器，将类的实例放在容器里。
 - 调用者：需要实例化对象的类。
 - 沟通桥梁：利用Dagger2中的一些API 将两者联系
 * */
@Inject  //标明需要注入的对象
 Person person;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
    }
}
