package com.zayar.hellostorage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SqliteActivity extends AppCompatActivity {
    EditText mEditText;
    TextView mTextView;
    Button mButtonUpdate;
    Button mButtonDelete;
    DataOpenHelper mdb;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        mEditText=findViewById(R.id.editTextSource);
        mTextView=findViewById(R.id.textViewOutput);
        mdb=new DataOpenHelper(SqliteActivity.this);
        mButtonUpdate=findViewById(R.id.button3);
        mButtonUpdate.setVisibility(View.VISIBLE);
        mButtonDelete=findViewById(R.id.button4);
        mButtonDelete.setVisibility(View.VISIBLE);

        mButtonUpdate.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT));
        mButtonDelete.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT));

    }

    public void saveData(View v){
        mdb.addValue(mEditText.getText().toString());
        mTextView.setText(mdb.getValue());
        Toast.makeText(this,"SQLite data inserted in table [data] with column[value] in database[mydb]",Toast.LENGTH_SHORT);

    }

    public void getData(View v){
        mTextView.setText(mdb.getValue());
        Toast.makeText(this,"SQLite data list retrieved all from table [data] with column[value] in database[mydb]",Toast.LENGTH_SHORT);
    }

    public void setData(View v){
        mdb.setValue(mEditText.getText().toString());
        mTextView.setText(mdb.getValue());
        Toast.makeText(this,"SQLite data updated in table [data] with column[value] in database[mydb]",Toast.LENGTH_SHORT);
    }

    public void deleteData(View v){
        mdb.deleteValue(mEditText.getText().toString());
        mTextView.setText(mdb.getValue());
        Toast.makeText(this,"SQLite data deleted in table [data] where[data]='"+mEditText.getText().toString()+"'in database[mydb]",Toast.LENGTH_SHORT);
    }


    public class DataOpenHelper extends SQLiteOpenHelper{
        private static final String DATABASE_NAME="mydb";
        private static final int DATABASE_VERSION=2;
        private static final String DATA_TABLE_NAME="data";
        private static final String DATA_TABLE_CREATE="CREATE TABLE "+DATA_TABLE_NAME+" ("+"id INTEGER PRIMARY KEY AUTOINCREMENT,value TEXT);";

        DataOpenHelper(Context context){
            super(context,DATABASE_NAME,null,DATABASE_VERSION);

        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DATA_TABLE_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
            db.execSQL("DROP TABLE IF EXISTS "+DATA_TABLE_NAME);
            onCreate(db);
        }

        void addValue(String text){
            SQLiteDatabase db=this.getWritableDatabase();
            ContentValues values=new ContentValues();
            values.put("value",text);
            //Inserting Row
            db.insert(DATA_TABLE_NAME,null,values);
            //2nd argument is String containing nullColumnHack
            db.close(); //Closing database connection
        }
        public String getValue(){
            SQLiteDatabase db=this.getReadableDatabase();
            String ret="";
            Cursor cursor=db.query(DATA_TABLE_NAME,new String[]{"value"},null,null,null,null,null,null);
            if(cursor.moveToFirst()){
                do{
                    ret+=cursor.getString(0)+"\n";

                }while (cursor.moveToNext());
            }
            return ret;
        }
        public void setValue(String text){
            SQLiteDatabase db=this.getWritableDatabase();
            ContentValues values=new ContentValues();
            values.put("value",text);
            db.update(DATA_TABLE_NAME,values,"id=?",new String[]{"1"});
            db.close();
        }

        public void deleteValue(String text){
            SQLiteDatabase db=this.getWritableDatabase();
            db.delete(DATA_TABLE_NAME,"value=?",new String[]{text});
            db.close();
        }
    }
}
