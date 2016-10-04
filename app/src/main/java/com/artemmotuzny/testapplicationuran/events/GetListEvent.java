package com.artemmotuzny.testapplicationuran.events;

import com.artemmotuzny.testapplicationuran.domain.FileModel;

import java.util.ArrayList;

/**
 * Created by tema_ on 04.10.2016.
 */
public class GetListEvent {
    private ArrayList<FileModel> list;
    private String folderName;

    public GetListEvent(ArrayList<FileModel> list, String folderName) {
        this.list = list;
        this.folderName = folderName;
    }

    public ArrayList<FileModel> getList() {
        return list;
    }

    public String getFolderName() {
        return folderName;
    }
}
