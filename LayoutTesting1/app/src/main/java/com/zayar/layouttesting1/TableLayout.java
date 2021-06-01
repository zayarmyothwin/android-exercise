package com.zayar.layouttesting1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TableLayout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_layout);
    }

    public void backtomain(View view) {
        Intent back=new Intent(this,MainActivity.class);
        startActivity(back);
    }
}