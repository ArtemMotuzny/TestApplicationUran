package com.artemmotuzny.testapplicationuran.repository;

import com.artemmotuzny.testapplicationuran.domain.FileModel;

import java.util.ArrayList;

/**
 * Created by tema_ on 04.10.2016.
 */

public interface FileRepository {
    ArrayList<FileModel> getFileModelList(String folderName);
}
