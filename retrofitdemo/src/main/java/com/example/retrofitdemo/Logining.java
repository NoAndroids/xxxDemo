package com.example.retrofitdemo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Administrator on 2016/7/22.
 */
public interface Logining {
    @GET("agent/loginAgent/username={username}/password={password}")
    Call<Bean> Logining(@Path("username") String username,@Path("password") String password);
}
