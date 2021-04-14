package com.zayar.hellostorage;

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

    public void loadSharedPreference(View view) {
        Intent intent=new Intent(this,SharedPreferenceActivity.class);
        startActivity(intent);
    }

    public void loadInternalStorage(View view) {
    }

    public void loadExternalStorage(View view) {
    }

    public void loadSqlite(View view) {
    }

    public void loadHttp(View view) {
    }
}