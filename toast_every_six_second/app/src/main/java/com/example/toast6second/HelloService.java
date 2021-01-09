package com.example.toast6second;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class HelloService extends Service {

    boolean running=false;
    private void toast(final String text){
        String TAG="Hello_Service";
        Log.d(TAG,text);
        Handler handler=new Handler(Looper.getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(HelloService.this,text,Toast.LENGTH_SHORT).show();
            }
        });
    }

    public HelloService(){

    }

    @Override
    public void onCreate() {
        super.onCreate();
        toast("Service Created");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        toast("Service Destroyed");
        running=false;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        running=true;
        new Thread(new Runnable() {
            @Override
            public void run() {
                Looper.prepare();
                while (running){
                    toast("Service Running");
                    try {
                        Thread.sleep(3000);

                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        return START_STICKY;
    }
}
