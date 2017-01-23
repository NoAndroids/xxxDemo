package com.example.mvpdemo2.Model;

import java.util.List;

/**
 * Created by Administrator on 2016/8/15.
 */
public interface IMainModel {
    void  getData(OnLoadCompleteListener onLoadCompleteListener);

        public interface OnLoadCompleteListener{
            void onLoadComplete(List<String> list);
        }
}
