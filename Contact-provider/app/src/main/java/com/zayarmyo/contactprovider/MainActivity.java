package com.zayarmyo.contactprovider;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView mTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTxt=(TextView)findViewById(R.id.txt1);
    }

    public void loadContacts(View view) {
        String list="";
        Cursor cursor=getContentResolver().query(ContactsContract.Contacts.CONTENT_URI,null,null,null,null);
        while (cursor.moveToNext()){
            String contactID=cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
            String hasPhone=cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER));
            if(hasPhone.equals("1")){
                Cursor phones=getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,ContactsContract.CommonDataKinds.Phone.CONTACT_ID+" = "+contactID,null,null);
                while (phones.moveToNext()){
                    String phoneNumber=phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                    list+=phoneNumber+"\n";
                }
                phones.close();
            }
            Cursor email= getContentResolver().query(ContactsContract.CommonDataKinds.Email.CONTENT_URI, null, ContactsContract.CommonDataKinds.Email.CONTACT_ID + " = " + contactID, null, null);
            while (email.moveToNext()){
                String emailAddress=email.getString(email.getColumnIndex(ContactsContract.CommonDataKinds.Email.DATA));
                list+=emailAddress+"\n\n";

            }
            email.close();
        }
        cursor.close();
        mTxt.setText(list);
    }
}