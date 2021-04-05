package com.zayarmyo.myprovider;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void loadData(View view) {
        final String Provider_name="mm.com.zayar.myprovider";
        final String URL="content://"+Provider_name+"/users";
        Uri friends=Uri.parse(URL);
        Cursor c=getContentResolver().query(friends,null,null,null,"name");
        String result="";
        if(!c.moveToFirst()){
            Toast.makeText(this,result+" no content yet!",Toast.LENGTH_LONG).show();
        }
        else {
            do{
                result=result+"\n"+c.getString(c.getColumnIndex("name"))+" with id "+c.getString(c.getColumnIndex("id"));
            }while (c.moveToNext());
            Toast.makeText(this,result,Toast.LENGTH_LONG).show();
        }
    }
}