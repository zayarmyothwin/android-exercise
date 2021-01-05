package com.example.example1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class IntentFunction extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_function);
    }

    public void loadBrowser(View view) {
        Intent y=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/"));
        startActivity(y);
    }

    public void callPhone(View view) {
        Intent c=new Intent(Intent.ACTION_VIEW,Uri.parse("tel:09450051191"));
        startActivity(c);
    }
}