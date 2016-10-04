package com.artemmotuzny.testapplicationuran.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.artemmotuzny.testapplicationuran.domain.FileModel;

import java.util.ArrayList;

/**
 * Created by tema_ on 04.10.2016.
 */

public class DataBase {
    private SQLiteDatabase database;
    private DBHelper helper;

    public DataBase(Context context){
        helper = new DBHelper(context,DBConstants.TABLE_NAME,null,DBConstants.VERSION_DB);
    }

    public Cursor getFileModels(String rootFolder) {
        database = helper.getReadableDatabase();
        String sql = "select * from " + DBConstants.TABLE_NAME +" WHERE " + DBConstants.COLUMN_PARENT_NAME + " = ?";
        Cursor c = database.rawQuery(sql, new String[]{rootFolder});
        if(c!=null){
            return c;
        }
        return null;
    }
}
