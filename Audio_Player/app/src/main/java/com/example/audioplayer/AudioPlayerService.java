package com.example.audioplayer;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class AudioPlayerService extends Service {
    MediaPlayer mediaPlayer;
    final String TAG="PlayerService";
    public AudioPlayerService(){

    }

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer=MediaPlayer.create(this,R.raw.yellowclaw);
        Log.d(TAG,"Service Created");

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mediaPlayer.start();
        Log.d(TAG,"Service Started");
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        mediaPlayer.start();
        mediaPlayer.release();
        super.onDestroy();
    }

    public void pause(){
        mediaPlayer.pause();
        Log.d(TAG,"Player Paused");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    public class MyBinder extends Binder {
        AudioPlayerService getService(){
            return AudioPlayerService.this;
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
