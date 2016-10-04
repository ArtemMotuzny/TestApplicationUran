package com.artemmotuzny.testapplicationuran;

import android.database.Cursor;

import com.artemmotuzny.testapplicationuran.db.DBConstants;
import com.artemmotuzny.testapplicationuran.domain.FileModel;
import com.artemmotuzny.testapplicationuran.domain.FileType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import static com.artemmotuzny.testapplicationuran.domain.FileType.FOLDER;
import static com.artemmotuzny.testapplicationuran.domain.FileType.IMAGE;
import static com.artemmotuzny.testapplicationuran.domain.FileType.MUSIC;
import static com.artemmotuzny.testapplicationuran.domain.FileType.OTHER;
import static com.artemmotuzny.testapplicationuran.domain.FileType.VIDEO;

/**
 * Created by tema_ on 04.10.2016.
 */
public class Mapper {
    public static ArrayList<FileModel> cursorToFileModel(Cursor c) throws ParseException {
        ArrayList<FileModel> fileModels = new ArrayList<>();
        if(c.moveToFirst()){
            while (!c.isAfterLast())
            {
                String name = c.getString(c.getColumnIndex(DBConstants.COLUMN_NAME_FILE));
                FileType type = getFileTypeFromString(c.getString(c.getColumnIndex(DBConstants.COLUMN_TYPE)));
                Date d = new SimpleDateFormat("MM-dd-yyyy", Locale.getDefault()).parse(c.getString(c.getColumnIndex(DBConstants.COLUMN_DATE)));
                boolean orange = c.getInt(c.getColumnIndex(DBConstants.COLUMN_ORANGE))==1;
                boolean blue = c.getInt(c.getColumnIndex(DBConstants.COLUMN_BLUE))==1;
                String folder = type==FileType.FOLDER?Constants.FILE_FOLDER:Constants.FILE;
                fileModels.add(new FileModel(name,folder,type,d,orange,blue));
                c.moveToNext();
            }
        }
        return fileModels;
    }

    private static FileType getFileTypeFromString(String string) {
        FileType fileType = null;
        switch (string){
            case Constants.OTHER:
                fileType = OTHER;
                break;
            case Constants.FILE_FOLDER:
                fileType = FOLDER;
                break;
            case Constants.IMAGE:
                fileType = IMAGE;
                break;
            case Constants.VIDEO:
                fileType = VIDEO;
                break;
            case Constants.MUSIC:
                fileType = MUSIC;
                break;
        }
        return fileType;
    }
}
