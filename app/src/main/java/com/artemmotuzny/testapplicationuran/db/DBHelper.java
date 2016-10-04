package com.artemmotuzny.testapplicationuran.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.artemmotuzny.testapplicationuran.Constants;

/**
 * Created by tema_ on 04.10.2016.
 */

public class DBHelper extends SQLiteOpenHelper{
    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DBConstants.CREATE_TABLE);
        fillingBD(db);
    }

    private void fillingBD(SQLiteDatabase db) {
        ContentValues values = new ContentValues();
        values.put(DBConstants.COLUMN_NAME_FILE,"Folder1");
        values.put(DBConstants.COLUMN_TYPE,Constants.FILE_FOLDER);
        values.put(DBConstants.COLUMN_DATE,"08-02-2014");
        values.put(DBConstants.COLUMN_PARENT_NAME, Constants.ROOT_FOLDER);
        values.put(DBConstants.COLUMN_ORANGE,1);
        values.put(DBConstants.COLUMN_BLUE,0);
        db.insert(DBConstants.TABLE_NAME,null,values);

        values = new ContentValues();
        values.put(DBConstants.COLUMN_NAME_FILE,"Img33");
        values.put(DBConstants.COLUMN_TYPE,Constants.IMAGE);
        values.put(DBConstants.COLUMN_DATE,"09-16-2014");
        values.put(DBConstants.COLUMN_PARENT_NAME, Constants.ROOT_FOLDER);
        values.put(DBConstants.COLUMN_ORANGE,1);
        values.put(DBConstants.COLUMN_BLUE,0);
        db.insert(DBConstants.TABLE_NAME,null,values);

        values = new ContentValues();
        values.put(DBConstants.COLUMN_NAME_FILE,"M32");
        values.put(DBConstants.COLUMN_TYPE,Constants.MUSIC);
        values.put(DBConstants.COLUMN_DATE,"01-04-2014");
        values.put(DBConstants.COLUMN_PARENT_NAME, Constants.ROOT_FOLDER);
        values.put(DBConstants.COLUMN_ORANGE,1);
        values.put(DBConstants.COLUMN_BLUE,1);
        db.insert(DBConstants.TABLE_NAME,null,values);

        values = new ContentValues();
        values.put(DBConstants.COLUMN_NAME_FILE,"fileOne");
        values.put(DBConstants.COLUMN_TYPE,Constants.OTHER);
        values.put(DBConstants.COLUMN_DATE,"12-22-2014");
        values.put(DBConstants.COLUMN_PARENT_NAME, "Folder1");
        values.put(DBConstants.COLUMN_ORANGE,0);
        values.put(DBConstants.COLUMN_BLUE,0);
        db.insert(DBConstants.TABLE_NAME,null,values);

        values = new ContentValues();
        values.put(DBConstants.COLUMN_NAME_FILE,"fileOrne");
        values.put(DBConstants.COLUMN_TYPE,Constants.VIDEO);
        values.put(DBConstants.COLUMN_DATE,"12-22-2014");
        values.put(DBConstants.COLUMN_PARENT_NAME, "Folder1");
        values.put(DBConstants.COLUMN_ORANGE,0);
        values.put(DBConstants.COLUMN_BLUE,0);
        db.insert(DBConstants.TABLE_NAME,null,values);


        values = new ContentValues();
        values.put(DBConstants.COLUMN_NAME_FILE,"f2");
        values.put(DBConstants.COLUMN_TYPE,Constants.FILE_FOLDER);
        values.put(DBConstants.COLUMN_DATE,"12-22-2014");
        values.put(DBConstants.COLUMN_PARENT_NAME, "Folder1");
        values.put(DBConstants.COLUMN_ORANGE,0);
        values.put(DBConstants.COLUMN_BLUE,0);
        db.insert(DBConstants.TABLE_NAME,null,values);


        values = new ContentValues();
        values.put(DBConstants.COLUMN_NAME_FILE,"fileOne");
        values.put(DBConstants.COLUMN_TYPE,Constants.MUSIC);
        values.put(DBConstants.COLUMN_DATE,"12-22-2014");
        values.put(DBConstants.COLUMN_PARENT_NAME, "f2");
        values.put(DBConstants.COLUMN_ORANGE,0);
        values.put(DBConstants.COLUMN_BLUE,0);
        db.insert(DBConstants.TABLE_NAME,null,values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
