package com.artemmotuzny.testapplicationuran.ui;

import com.artemmotuzny.testapplicationuran.domain.FileModel;

import java.util.ArrayList;

/**
 * Created by tema_ on 04.10.2016.
 */
public interface MainView {
    void setAdapter(ArrayList<FileModel> list);

    void showEmptyFolder();

    void showLog(String name);

    void setToolbarText(String folderName);

    void showDialog();

    void myOnBackPressed();
}
