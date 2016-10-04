package com.artemmotuzny.testapplicationuran.domain;

import java.util.Date;

/**
 * Created by tema_ on 04.10.2016.
 */

public class FileModel {
    private String fileName;
    private String isFolder;
    private FileType type;
    private Date modDate;
    private boolean isOrange;
    private boolean isBlue;

    public FileModel(String fileName, String isFolder, FileType type, Date modDate, boolean isOrange, boolean isBlue) {
        this.fileName = fileName;
        this.isFolder = isFolder;
        this.type = type;
        this.modDate = modDate;
        this.isOrange = isOrange;
        this.isBlue = isBlue;
    }

    public String isFolder() {
        return isFolder;
    }

    public String getName() {
        return fileName;
    }

    public Date getDate() {
        return modDate;
    }

    public FileType getType() {
        return type;
    }

    public boolean isOrange() {
        return isOrange;
    }

    public boolean isBlue() {
        return isBlue;
    }
}
