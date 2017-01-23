package com.example.mvpdemo2.Persenter;

import com.example.mvpdemo2.Model.IMainModel;
import com.example.mvpdemo2.Model.MainModel;
import com.example.mvpdemo2.View.IMainView;

import java.util.List;

/**
 * Created by Administrator on 2016/8/15.
 */
public abstract  class MainPersenter<T>  {
    MainModel mainModel;
    T iMainView;

    public MainPersenter(IMainView iMainView) {
        this.iMainView = (T) iMainView;
        mainModel=new MainModel();
    }
    public void load(){
        mainModel.getData(new IMainModel.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(List<String> list) {
              //  iMainView.showView(list);
            }
        });
    }
}
