package com.shy.four;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.IBinder;
import android.provider.Settings;

public class Service2 extends Service {
    /**
     * 这个通知有点问题
     */

    @Override
    public void onCreate() {
        super.onCreate();
        Notification.Builder builder=new Notification.Builder(this);
        Intent notifyintent=new Intent(this,MainActivity.class);
        PendingIntent pendingIntent=PendingIntent.getActivities(this,0, new Intent[]{notifyintent},0);
        builder.setContentIntent(pendingIntent);
        Bitmap bitmap=BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);

        builder.setLargeIcon(bitmap);
        builder.setContentTitle("通知");
        builder.setContentText("内容");
        builder.setAutoCancel(false);
//        NotificationManager notificationManager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
//        notificationManager.notify(0,builder.build());
        startForeground(1,builder.build());//前台服务
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
