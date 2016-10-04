package com.artemmotuzny.testapplicationuran.db;

/**
 * Created by tema_ on 04.10.2016.
 */

public class DBConstants {
    public static final String NAME_DB = "UranDB";
    public static final int VERSION_DB = 1;

    public static final String TABLE_NAME = "FileModelTable";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME_FILE = "file_name";
    public static final String COLUMN_TYPE = "type";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_PARENT_NAME = "parent_name";
    public static final String COLUMN_ORANGE = "isOrange";
    public static final String COLUMN_BLUE = "isBlue";


    static final String CREATE_TABLE = "create table if not exists " + TABLE_NAME+" ( "
            + COLUMN_ID + " integer primary key autoincrement, "
            + COLUMN_PARENT_NAME + " text, "
            + COLUMN_NAME_FILE + " text, "
            + COLUMN_TYPE + " text, "
            + COLUMN_DATE + " text, "
            + COLUMN_ORANGE+ " int, "
            + COLUMN_BLUE+ " int)";

}
