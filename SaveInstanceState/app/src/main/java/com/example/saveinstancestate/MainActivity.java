package com.example.saveinstancestate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtView;
    int mValue=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState!=null){
            mValue=savedInstanceState.getInt("counter",0);
        }
        setContentView(R.layout.activity_main);
        txtView=(TextView)findViewById(R.id.textView);
        txtView.setText(mValue+"");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        //Save our own state now
        outState.putSerializable("counter",mValue);
    }

    public void trigger(View view) {
        mValue++;
        txtView.setText(mValue+"");
    }
}