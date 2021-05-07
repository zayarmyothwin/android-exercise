package com.zayar.hellostorage;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class InternalStorageActivity extends AppCompatActivity {
    EditText mEditText;
    TextView mTextView;
    final String FILENAME="myfile.txt";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        mEditText=findViewById(R.id.editTextSource);
        mTextView=findViewById(R.id.textViewOutput);
    }

    public void saveData(View v){
        String string=mEditText.getText().toString();
        FileOutputStream fos;
        try {
            fos=openFileOutput(FILENAME, Context.MODE_PRIVATE);
            fos.write(string.getBytes());
            fos.close();
            Toast.makeText(this,"Internal Stroage saved as "+FILENAME,Toast.LENGTH_SHORT).show();
        }
        catch (FileNotFoundException e){
           e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void getData(View v){
        FileInputStream fin;
        try{
            fin=openFileInput(FILENAME);
            int c;
            String temp="";
            while ((c=fin.read())!=-1){
                temp=temp+Character.toString((char)c);

            }
            mTextView.setText(temp);
            fin.close();
            Toast.makeText(this,"Internal Stroage retrieved from "+FILENAME,Toast.LENGTH_SHORT).show();
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

}
