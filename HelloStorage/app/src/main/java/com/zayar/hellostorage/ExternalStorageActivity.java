package com.zayar.hellostorage;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ExternalStorageActivity extends AppCompatActivity {
    EditText mEditText;
    TextView mTextView;
    String TAG="FW_OUTPUT";
    String mDir="";
    String mFileName="";
    private int requestCode;
    private int grantResults[];



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        mEditText=findViewById(R.id.editTextSource);
        mTextView=findViewById(R.id.textViewOutput);
        mDir= Environment.getExternalStorageDirectory().getAbsolutePath()+"/Android/data/"+getPackageName();
        mFileName=mDir+"myfile.txt";
        Log.d(TAG,mDir);
        File dir=new File(mDir);
        if(!dir.exists())
            dir.mkdir();

    }


    public void saveData(View v){
        String data=mEditText.getText().toString();
        FileOutputStream fos;
        try {
            File myFile=new File(mFileName);
            myFile.createNewFile();
            FileOutputStream fOut=new FileOutputStream(myFile);
            OutputStreamWriter myOutWriter=new OutputStreamWriter(fOut);
            myOutWriter.append(data);
            myOutWriter.close();
            fOut.close();
            Toast.makeText(this,"External Storage saved as "+mFileName,Toast.LENGTH_SHORT).show();
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void getData(View v){
        String line="";
        String aBuffer="";
        try{
            File myFile=new File(mFileName);
            FileInputStream fIn=new FileInputStream(myFile);
            BufferedReader myReader=new BufferedReader(new InputStreamReader(fIn));
            while ((line=myReader.readLine())!=null){
                aBuffer+=line+"\n";

            }
            myReader.close();
            mTextView.setText(aBuffer);
            Toast.makeText(this,"External Storage retrieved from "+mFileName,Toast.LENGTH_SHORT).show();
        }

        catch (IOException e){
            e.printStackTrace();
        }
    }




}
