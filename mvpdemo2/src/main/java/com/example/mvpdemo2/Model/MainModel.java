package com.example.mvpdemo2.Model;

import com.example.mvpdemo2.View.IMainView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/15.
 */
public class MainModel implements IMainModel {
    @Override
    public void getData(OnLoadCompleteListener onLoadCompleteListener) {
        List<String> list=new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add("test"+i);
        }
        onLoadCompleteListener.onLoadComplete(list);
    }
}
