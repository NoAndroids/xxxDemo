package com.example.retrofitdemo.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.retrofitdemo.Bean;
import com.example.retrofitdemo.R;
import com.example.retrofitdemo.prsenter.LoginPresenter;

public class MainActivity extends AppCompatActivity implements LoginView {
    private String url = "http://yibao.wicp.net/";
    private Button btn1,btn2;
    private LoginPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2= (Button) findViewById(R.id.btn2);
        presenter=new LoginPresenter(MainActivity.this);
//        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
//            @Override
//            public void log(String message) {
//                Log.i("tag", "log: =============" + message);
//            }
//        });
//        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .addInterceptor(httpLoggingInterceptor)
//                .readTimeout(10, TimeUnit.SECONDS)
//                .build();
//        btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Retrofit retrofit = new Retrofit.Builder()
//                        .baseUrl(url)
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .client(okHttpClient)
//                        .build();

//                Logining logining = retrofit.create(Logining.class);  b   btn2
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.Login();
              //  HttpUtls.Login login = HttpUtls.getRetrofit().create(HttpUtls.Login.class);
//                retrofit2.Call<Bean> call = login.getLogin("17731392092", "111111");
//                call.enqueue(new Callback<Bean>() {
//                    @Override
//                    public void onResponse(retrofit2.Call<Bean> call, Response<Bean> response) {
//                        Log.i("tag", "onResponse: response" + response.toString());
//
//                       // Log.i("tag", "onResponse: response+++++++" + response.body().toString());
//                        Log.i("tag", "onResponse: call" + call.toString());
//                    }
//
//                    @Override
//                    public void onFailure(retrofit2.Call<Bean> call, Throwable t) {
//                        Log.i("tag", "onFailure: Throwable" + t);
//                        Log.i("tag", "onFailure: call" + call);
//                    }
//                });
//                login.rxLogin("17731392092","111111")
//                        .subscribeOn(Schedulers.io())
//                        .observeOn(AndroidSchedulers.mainThread())
//                        .subscribe(new Subscriber<Bean>() {
//                            @Override
//                            public void onCompleted() {
//                                Log.i("tag", "onCompleted:rxLogin---- ");
//                            }
//
//                            @Override
//                            public void onError(Throwable e) {
//                                Log.i("tag", "onError:rxLogin---- "+e);
//                            }
//
//                            @Override
//                            public void onNext(Bean bean) {
//                                Log.i("tag", "onNext:rxLogin---- "+bean.toString());
//                            }
//                        });
            }
        });
//        btn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                HttpUtls.Load load = HttpUtls.getRetrofit().create(HttpUtls.Load.class);
////                retrofit2.Call<LoadBean> callLoad = load.getLoad();
////                callLoad.enqueue(new Callback<LoadBean>() {
////                    @Override
////                    public void onResponse(retrofit2.Call<LoadBean> call, Response<LoadBean> response) {
////                        Log.i("tag", "onResponse: callLoad"+response);
////                        Log.i("tag", "onResponse: callLoad"+call);
////                        Toast.makeText(MainActivity.this,response.body().getMsg(),0).show();
////                    }
////
////                    @Override
////                    public void onFailure(retrofit2.Call<LoadBean> call, Throwable t) {
////                        Log.i("tag", "onFailure: callLoad"+t);
////                        Log.i("tag", "onFailure: callLoad"+call);
////                    }
////                });
//                load.rxLoad()
//                        .subscribeOn(Schedulers.io())
//                        .observeOn(AndroidSchedulers.mainThread())
//                        .subscribe(new Subscriber<LoadBean>() {
//                            @Override
//                            public void onCompleted() {
//                                Log.i("tag", "onCompleted:rxLoad ");
//                            }
//
//                            @Override
//                            public void onError(Throwable e) {
//                                Log.i("tag", "onCompleted:rxLoad "+e);
//                            }
//
//                            @Override
//                            public void onNext(LoadBean loadBean) {
//                                Log.i("tag", "onCompleted:rxLoad "+loadBean.toString());
//                            }
//                        });
//            }
//        });


    }

    @Override
    public void moveToNext(Bean bean) {
        Toast.makeText(this,"登录成功",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hint(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }



    @Override
    public String getUserName() {
        return "13143495139";
    }

    @Override
    public String getPassWord() {
        return "111111";
    }
}

