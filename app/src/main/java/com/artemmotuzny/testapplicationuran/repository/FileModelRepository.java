package com.artemmotuzny.testapplicationuran.repository;

import com.artemmotuzny.testapplicationuran.Constants;
import com.artemmotuzny.testapplicationuran.Mapper;
import com.artemmotuzny.testapplicationuran.db.DataBase;
import com.artemmotuzny.testapplicationuran.domain.FileModel;

import java.text.ParseException;
import java.util.ArrayList;

/**
 * Created by tema_ on 04.10.2016.
 */

public class FileModelRepository implements FileRepository {
    private DataBase dataBase;

    public FileModelRepository(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public ArrayList<FileModel> getFileModelList(String folderName) {
        try {
            return  Mapper.cursorToFileModel(dataBase.getFileModels(folderName));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
