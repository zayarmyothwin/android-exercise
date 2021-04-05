package com.zayarmyo.myprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyProvider extends ContentProvider {
    static final String Provider_name="mm.com.zayar.myprovider";
    static final String URL="content://"+Provider_name+"/users";
    @Override
    public boolean onCreate() {
        return false;
    }

    @Nullable
    @Override
    public Cursor query(Uri arg0,String[] arg1,String arg2,String[] arg3,String arg4) {
        String[] columnNames={"id","name"};
        MatrixCursor matrixCursor=new MatrixCursor(columnNames);
        matrixCursor.addRow(new Object[]{1,"Jhon"});
        matrixCursor.addRow(new Object[]{2,"David"});
        return matrixCursor;

    }

    @Nullable
    @Override
    public String getType(@NonNull Uri arg0) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri arg0, @Nullable ContentValues arg1) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri arg0, @Nullable String arg1, @Nullable String[] arg2) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri arg0, @Nullable ContentValues arg1, @Nullable String arg2, @Nullable String[] arg3) {
        return 0;
    }
}
