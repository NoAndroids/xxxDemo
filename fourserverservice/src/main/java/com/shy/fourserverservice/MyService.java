package com.shy.fourserverservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

/**
 * Created by ShangHongyu on 2017/3/10.
 */

public class MyService extends Service {
    public MyService() {
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    MAIDLServerService.Stub mbinder= new MAIDLServerService.Stub() {
        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public int addNum(int a, int b) throws RemoteException {

            return a+b;
        }
    };
}
