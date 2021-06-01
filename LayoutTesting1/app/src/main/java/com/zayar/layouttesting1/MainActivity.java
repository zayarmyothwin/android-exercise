package com.zayar.layouttesting1;

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

    public void ToLinear(View view) {
        Intent intent=new Intent(this,LinearLayout.class);
        startActivity(intent);
    }

    public void ToTable(View view) {
        Intent intent=new Intent(this,TableLayout.class);
        startActivity(intent);
    }

    public void ToFrame(View view) {
        Intent intent=new Intent(this,FrameLayout.class);
        startActivity(intent);
    }

    public void ToGrid(View view) {
        Intent intent=new Intent(this,GridLayout.class);
        startActivity(intent);
    }
}