package com.example.dagger2demo.bean;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2016/8/12.
 */
@Module //提供依赖对象的实例
public class MainModule {
    @Provides// 关键字，标明该方法提供依赖对象
    Person providePerson(){
        //提供Person对象
        return  new Person();
    }
}
