package com.artemmotuzny.testapplicationuran.presenter;

import com.artemmotuzny.testapplicationuran.Constants;
import com.artemmotuzny.testapplicationuran.domain.FileModel;
import com.artemmotuzny.testapplicationuran.events.GetListEvent;
import com.artemmotuzny.testapplicationuran.events.ItemClickEvent;
import com.artemmotuzny.testapplicationuran.events.OnDialogClickEvent;
import com.artemmotuzny.testapplicationuran.events.OnLongClickEvent;
import com.artemmotuzny.testapplicationuran.interactors.GetInteractorImpl;
import com.artemmotuzny.testapplicationuran.ui.MainView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

/**
 * Created by tema_ on 04.10.2016.
 */

public class MainPresenterimpl implements MainPresenter {
    private GetInteractorImpl getInteractor;
    private MainView view;
    private ArrayList<String> prevFolder;
    private String currentFolder;

    public MainPresenterimpl(GetInteractorImpl getInteractor, MainView view) {
        this.getInteractor = getInteractor;
        this.view = view;
        this.currentFolder = Constants.ROOT_FOLDER;
        this.prevFolder = new ArrayList<>();
        prevFolder.add(currentFolder);
        EventBus.getDefault().register(this);
    }

    @Override
    public void getRootFiles() {
        getInteractor.setData(null);
    }

    @Override
    public void back() {
        if(prevFolder.size()==1){
            view.myOnBackPressed();
            return;
        }

        String f = prevFolder.get(prevFolder.size()-1);
        prevFolder.remove(f);
        getFolderFilesByName(f);
    }



    private void getFolderFilesByName(String prevFolder) {
        getInteractor.setDataByPrevFolder(prevFolder);
    }


    private void setCurentFolder(String folderName) {
        prevFolder.add(currentFolder);
        currentFolder = folderName;
    }

    private void getFolderFiles(FileModel f){
        getInteractor.setData(f);
    }

    @Subscribe
    public void onDialogClickEvent(OnDialogClickEvent event){
        view.showLog(event.getLog());
    }

    @Subscribe
    public void onLongClikcEvent(OnLongClickEvent event){
        view.showDialog();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onGetListEvent(GetListEvent event){
        view.setToolbarText(event.getFolderName());
        ArrayList<FileModel> list = event.getList();
        if(!list.isEmpty()){
            view.setAdapter(list);
        }else {
            view.showEmptyFolder();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onItemClickEvent(ItemClickEvent event){
        FileModel fileModel = event.getFile();
        if(fileModel.isFolder().equals(Constants.FILE_FOLDER)){
            setCurentFolder(fileModel.getName());
            getFolderFiles(fileModel);
        }else {
            view.showLog(fileModel.getName());
        }
    }






}
