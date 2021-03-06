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
        Intent intent=new Intent(this,InternalStorageActivity.class);
        startActivity(intent);
    }

    public void loadExternalStorage(View view) {
        Intent intent=new Intent(this,ExternalStorageActivity.class);
        startActivity(intent);
    }

    public void loadSqlite(View view) {
        Intent intent=new Intent(this,SqliteActivity.class);
        startActivity(intent);
    }

    public void loadHttp(View view) {
    }
}