package com.example.audioplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    AudioPlayerService myService;
    private Boolean isBound;
    ImageButton btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(ImageButton)findViewById(R.id.btn1);
        isBound=false;
    }

    public void playAudio(View view) {
        Intent i=new Intent(this,AudioPlayerService.class);
        if(!isBound){
            bindService(i,myConnection, Context.BIND_AUTO_CREATE);
            isBound=true;
            btn.setImageResource(R.drawable.pause);
            startService(i);
        }
        else{
            myService.pause();
            btn.setImageResource(R.drawable.play);
            isBound=false;
            unbindService(myConnection);
        }
    }

    public void stopAudio(View view) {
        Intent i=new Intent(this,AudioPlayerService.class);
        if(isBound){
            isBound=false;
            unbindService(myConnection);
            stopService(i);
        }
        else{
            stopService(i);
            btn.setImageResource(R.drawable.play);
        }
    }

    private ServiceConnection myConnection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myService=((AudioPlayerService.MyBinder)service).getService();
            isBound=true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound=false;
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(isBound){
            //Disconnect from an application service.
            isBound=false;
        }
    }
}