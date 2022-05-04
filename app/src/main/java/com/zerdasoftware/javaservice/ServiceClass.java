package com.zerdasoftware.javaservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class ServiceClass extends Service {

    private static final String TAG = "ServiceClass";
    
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind: ");
        return null;
    }

    @Override
    public void onCreate() {
        String currentThread = Thread.currentThread().getName();
        Log.d(TAG, "onCreate: " + currentThread);
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        String currentThread = Thread.currentThread().getName();
        Log.d(TAG, "onDestroy: " + currentThread);
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String currentThread = Thread.currentThread().getName();
        Log.d(TAG, "onStartCommand: " + currentThread);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return super.onStartCommand(intent, flags, startId);
    }
}
