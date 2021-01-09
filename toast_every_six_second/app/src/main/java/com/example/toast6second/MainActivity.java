package com.example.toast6second;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void start(View view) {
        Intent i=new Intent(this,HelloService.class);
        startService(i);
    }

    public void stop(View view) {
        Intent i=new Intent(this,HelloService.class);
        stopService(i);
    }
}