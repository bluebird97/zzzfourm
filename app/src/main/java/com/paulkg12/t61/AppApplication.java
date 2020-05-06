package com.paulkg12.t61;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Build;
import android.util.Log;

import com.paulkg12.t61.inject.component.AppComponent;
import com.paulkg12.t61.inject.component.DaggerAppComponent;
import com.paulkg12.t61.inject.module.AppModule;
import com.paulkg12.t61.service.NetBroadcastReceiver;
import com.paulkg12.t61.util.NetHelper;

public class AppApplication extends Application {
    private final String TAG = AppApplication.class.getSimpleName();

    private static AppApplication application;
    private AppComponent mAppComponent;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
//        MultiDex.install(this);
    }
    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        //init application
        long startTime = System.currentTimeMillis();
        AppData.INSTANCE.getSystemDefaultLocal();
        //apply language for application context, bugly used it
        //AppUtils.updateAppLanguage(getApplicationContext());
        //initLogger();
        Log.d(TAG, "startTime:" + startTime);
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
        initNetwork();
        //initBugly();
        startTime = System.currentTimeMillis();
        Log.d(TAG, "application ok:" + (System.currentTimeMillis() - startTime));

    }

    private void initNetwork(){
        NetBroadcastReceiver receiver = new NetBroadcastReceiver();
        IntentFilter filter;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        } else {
            filter = new IntentFilter();
            filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        }
        registerReceiver(receiver, filter);

        NetHelper.INSTANCE.init(this);
    }
    public static AppApplication get(){
        return application;
    }

    public AppComponent getAppComponent(){
        return mAppComponent;
    }
}
