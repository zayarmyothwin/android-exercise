package com.example.example1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void toFunIntent(View view) {
        Intent intent=new Intent(this,IntentFunction.class);
        startActivity(intent);
    }

    public void toCustomBrowser(View view) {
        Intent custom=new Intent(this,CustomBrowser.class);
        startActivity(custom);
    }
}