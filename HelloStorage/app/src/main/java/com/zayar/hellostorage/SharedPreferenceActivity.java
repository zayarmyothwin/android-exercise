package com.zayar.hellostorage;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.FileOutputStream;
import java.io.IOException;

public class SharedPreferenceActivity extends AppCompatActivity {

    EditText mEditText;
    TextView mTextView;
    public final String PREFS_NAME="MyPrefsFile";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        mEditText=findViewById(R.id.editTextSource);
        mTextView=findViewById(R.id.textViewOutput);
    }
    public void saveData(View v){
        SharedPreferences settings=getSharedPreferences(PREFS_NAME,0);
        SharedPreferences.Editor editor=settings.edit();
        String data=mEditText.getText().toString();
        editor.putString("sample",data);
        editor.commit();
        Toast.makeText(this, "Preference saved", Toast.LENGTH_SHORT).show();
        mTextView.setText("");
    }
    public void getData(View v){
        SharedPreferences settings=getSharedPreferences(PREFS_NAME,0);
        String data=settings.getString("sample","No data");
        Toast.makeText(this, "Preference retrieved", Toast.LENGTH_SHORT).show();
        mTextView.setText(data);
    }


}
