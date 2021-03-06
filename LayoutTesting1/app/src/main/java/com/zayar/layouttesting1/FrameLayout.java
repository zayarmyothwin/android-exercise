package com.zayar.layouttesting1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class FrameLayout extends AppCompatActivity {
    ImageView img1,img2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_layout);
        img1=findViewById(R.id.imgAlliance);
        img2=findViewById(R.id.imgHorde);
    }

    public void showAlly(View view) {
        img1.setVisibility(ImageView.VISIBLE);
        img2.setVisibility(ImageView.INVISIBLE);
    }

    public void showHorde(View view) {
        img1.setVisibility(ImageView.INVISIBLE);
        img2.setVisibility(ImageView.VISIBLE);
    }

    public void backtomain(View view) {
        Intent back=new Intent(this,MainActivity.class);
        startActivity(back);
    }
}