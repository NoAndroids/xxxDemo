package com.shy.four;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * //                            _ooOoo_
 * //                           o8888888o
 * //                           88" . "88
 * //                           (| -_- |)
 * //                            O\ = /O
 * //                        ____/`---'\____
 * //                      .   ' \\| |// `.
 * //                       / \\||| : |||// \
 * //                     / _||||| -:- |||||- \
 * //                       | | \\\ - /// | |
 * //                     | \_| ''\---/'' | |
 * //                      \ .-\__ `-` ___/-. /
 * //                   ___`. .' /--.--\ `. . __
 * //                ."" '< `.___\_<|>_/___.' >'"".
 * //               | | : `- \`.;`\ _ /`;.`/ - ` : | |
 * //                 \ \ `-. \_ __\ /__ _/ .-` / /
 * //         ======`-.____`-.___\_____/___.-`____.-'======
 * //                            `=---='
 * //
 * //         .............................................
 * //                  佛祖镇楼                  BUG辟易
 * //          佛曰:
 * //                  写字楼里写字间，写字间里程序员；
 * //                  程序人员写程序，又拿程序换酒钱。
 * //                  酒醒只在网上坐，酒醉还来网下眠；
 * //                  酒醉酒醒日复日，网上网下年复年。
 * //                  但愿老死电脑间，不愿鞠躬老板前；
 * //                  奔驰宝马贵者趣，公交自行程序员。
 * //                  别人笑我忒疯癫，我笑自己命太贱；
 * //                  不见满街漂亮妹，哪个归得程序员？
 * Created by ShangHongYu on 2017/3/9.
 */

public class Service1 extends Service{
    /**
     * 在manifest中注册
     */
    private String TAG="tag";
    private Mybinder mybinder=new Mybinder();
    /**
     * startService(intent); 先onCreate()----onStartCommand()
     * onCreate()方法只走一次  在没有停止服务前
     * bindService(intent) 先onCreate()---onBind ---activity中onServiceConnected
     * 只会走一次 在没有停止服务前
     *
     * service 运行在 主线程中  所以说不可以在service  执行太耗时操作会出现anr 如果要进行耗时操作
     * 需要在service 中启动一个thread
     */
    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "onCreate: ");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e(TAG, "onBind: " );
        return mybinder;
    }

    /**
     * btn1 启动service
     *Intent { cmp=com.shy.four/.Service1 }flags0startId2
     * @param intent
     * @param flags
     * @param startId
     * @return
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG, "onStartCommand: "+intent.toString()+"flags"+flags+"startId"+startId);
        return super.onStartCommand(intent, flags, startId);
    }

    /**
     * btn2 停止service
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy: " );
    }

    class Mybinder extends Binder{
        public void onDownLoad(){
            Log.e(TAG, "onDownLoad: 下载一些东西" );
        }
    }
}
