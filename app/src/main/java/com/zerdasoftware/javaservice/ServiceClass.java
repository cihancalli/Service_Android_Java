package com.zerdasoftware.javaservice;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
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

        /*
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
         */

        AsyncTaskClass asyncTaskClass = new AsyncTaskClass();
        asyncTaskClass.execute(10000);

        return super.onStartCommand(intent, flags, startId);
    }

    class AsyncTaskClass extends AsyncTask<Integer,Void,Void> {
        private static final String TAG = "AsyncTaskClass";
        @Override
        protected Void doInBackground(Integer... integers) {
            String currentThread = Thread.currentThread().getName();
            Log.d(TAG, "doInBackground: " + currentThread);
            int sleepTime = integers[0];
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPreExecute() {
            String currentThread = Thread.currentThread().getName();
            Log.d(TAG, "onPreExecute: " + currentThread);
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Void unused) {
            String currentThread = Thread.currentThread().getName();
            Log.d(TAG, "onPostExecute: " + currentThread);
            super.onPostExecute(unused);
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            String currentThread = Thread.currentThread().getName();
            Log.d(TAG, "onProgressUpdate: " + currentThread);
            super.onProgressUpdate(values);
        }
    }
}
