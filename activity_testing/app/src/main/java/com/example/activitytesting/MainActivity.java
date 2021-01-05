package com.example.activitytesting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        toast("On Create");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        toast("On Resume");
        super.onResume();
    }

    @Override
    protected void onRestart() {
        toast("On Restart");
        super.onRestart();
    }

    @Override
    protected void onStop() {
        toast("On Stop");
        super.onStop();
    }

    @Override
    protected void onStart() {
        toast("On Start");
        super.onStart();
    }

    @Override
    protected void onPause() {
        toast("On Pause");
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        toast("On Destroy");
        super.onDestroy();
    }

    private void toast(String text) {
        Toast.makeText(this,text,Toast.LENGTH_SHORT).show();
        Log.d("LIFE_CYCLE",text);
    }


    public void showSecond(View view) {
        Intent i=new Intent(this,Second.class);
        startActivity(i);
    }

    public void showBrowser(View view) {
        Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
        startActivity(i);
    }
}