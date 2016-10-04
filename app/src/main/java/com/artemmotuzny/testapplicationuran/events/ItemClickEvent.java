package com.artemmotuzny.testapplicationuran.events;

import com.artemmotuzny.testapplicationuran.domain.FileModel;

/**
 * Created by tema_ on 04.10.2016.
 */
public class ItemClickEvent {
    private FileModel fileModel;

    public ItemClickEvent(FileModel fileModel) {
        this.fileModel = fileModel;
    }

    public FileModel getFile() {
        return fileModel;
    }
}
