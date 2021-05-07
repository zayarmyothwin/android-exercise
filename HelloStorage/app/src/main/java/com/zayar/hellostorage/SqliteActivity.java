package com.zayar.hellostorage;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SqliteActivity extends AppCompatActivity {
    EditText mEditText;
    TextView mTextView;
    Button mButtonUpdate;
    Button mButtonDelete;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
