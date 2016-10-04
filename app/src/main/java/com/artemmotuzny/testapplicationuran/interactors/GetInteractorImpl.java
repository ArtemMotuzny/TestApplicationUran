package com.artemmotuzny.testapplicationuran.interactors;

import com.artemmotuzny.testapplicationuran.Constants;
import com.artemmotuzny.testapplicationuran.Threads.MyExecutor;
import com.artemmotuzny.testapplicationuran.Threads.ThreadPool;
import com.artemmotuzny.testapplicationuran.domain.FileModel;
import com.artemmotuzny.testapplicationuran.events.GetListEvent;
import com.artemmotuzny.testapplicationuran.repository.FileModelRepository;
import com.artemmotuzny.testapplicationuran.repository.FileRepository;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

/**
 * Created by tema_ on 04.10.2016.
 */

public class GetInteractorImpl implements Interactor {
    private MyExecutor executor;
    private FileRepository repository;
    private String folderName;
    private boolean check = false;

    public GetInteractorImpl(FileModelRepository repository) {
        this.repository = repository;
        this.executor = ThreadPool.getInstance();
    }

    @Override
    public void execute() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                if (check) {
                    ArrayList<FileModel> fileModels = repository.getFileModelList(folderName);
                    EventBus.getDefault().post(new GetListEvent(fileModels,folderName));
                    check = false;
                }
            }
        });
    }


    public void setData(FileModel fileModel) {
        if (fileModel == null) {
            this.folderName = Constants.ROOT_FOLDER;
        } else {
            if (fileModel.isFolder().equals(Constants.FILE_FOLDER)) {
                this.folderName = fileModel.getName();
            }else {
                return;
            }
        }
        this.check = true;
        this.execute();
    }

    //Use when we click back
    public void setDataByPrevFolder(String prevFolder) {
        this.folderName = prevFolder;
        this.check = true;
        this.execute();
    }
}
