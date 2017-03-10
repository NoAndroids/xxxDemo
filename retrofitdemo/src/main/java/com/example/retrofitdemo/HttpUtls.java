package com.example.retrofitdemo;

import android.os.IInterface;
import android.util.Log;

import java.util.Observable;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2016/7/22.
 */
public class HttpUtls {
    private static String url = "http://yibao.wicp.net/api/";
    public interface Login{
        @GET("agent/loginAgent")
//        Call<Bean> getLogin(@Query("username")  String username, @Query("password") String password);
        rx.Observable<Bean> rxLogin(@Query("username")  String username, @Query("password") String password);
    }
    public interface Load{
        @GET("organization/load")
//        Call<LoadBean> getLoad();
        rx.Observable<LoadBean>  rxLoad();
    }

    public static  Retrofit getRetrofit() {

        //拦截  用于输出LOG
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.i("tag", "log: ========" + message);
            }
        }).setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .writeTimeout(10, TimeUnit.SECONDS)
                .build();
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(url)
//                .addConverterFactory(GsonConverterFactory.create())
//                .client(okHttpClient)
//                .build();

        Retrofit retrofit;

        retrofit=new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient)
                .build();
//                .addCallAdapterFactory()

        return  retrofit;
    }

}
