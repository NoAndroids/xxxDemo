package com.example.duanxintiqu;

import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    public static final int MSG_RECEIVED_CODE=1;
private SmsObserver smsObserver;
    private Handler mHander=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what==MSG_RECEIVED_CODE){
                String code= (String) msg.obj;
                Log.i("tag", "handleMessage: "+code);
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        smsObserver=new SmsObserver(this,mHander);
        Uri uri=Uri.parse("content://sms");
        getContentResolver().registerContentObserver(uri,true,smsObserver);//注册
    }

    @Override
    protected void onPause() {
        super.onPause();
        getContentResolver().unregisterContentObserver(smsObserver);//撤销
    }
}
