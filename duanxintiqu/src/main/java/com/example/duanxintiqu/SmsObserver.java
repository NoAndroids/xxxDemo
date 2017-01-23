package com.example.duanxintiqu;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2016/8/17.
 */
public class SmsObserver extends ContentObserver {
    private  Context mContext;
    private Handler mHandler;



    public SmsObserver(Context context, Handler handler){
       super(handler);
        this.mContext=context;
        this.mHandler=handler;
   }

    @Override
    public void onChange(boolean selfChange, Uri uri) {
        super.onChange(selfChange, uri);
        Log.i("tag", "onChange: "+uri.toString());
        if (uri.equals("content://sms/raw")){
            return;
        }
        String code="";
        Uri inboxUri=Uri.parse("content//sms/inbox");
        //按时间倒序
        Cursor cursor=mContext.getContentResolver().query(inboxUri,null,null,null,"date desc");
        if (cursor!=null){
            if (cursor.moveToFirst()){
                String address=cursor.getString(cursor.getColumnIndex("address"));//地址
                String body=cursor.getString(cursor.getColumnIndex("body"));//内容
                //可以在这里判断是不是服务器发送短信的号码 如果不是就return
                //使用正则
                Pattern pattern=Pattern.compile("(\\d{6})");
                Matcher matcher=pattern.matcher(body);
                if (matcher.find()){
                    code=matcher.group(0);
                    mHandler.obtainMessage(MainActivity.MSG_RECEIVED_CODE,code).sendToTarget();//发送
                }
                Log.i("tag", "onChange: "+code);
                Log.i("tag", "onChange: "+address+"---"+body);
            }
            cursor.close();
        }
    }
}
