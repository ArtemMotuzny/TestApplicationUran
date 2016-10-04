package com.artemmotuzny.testapplicationuran.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.artemmotuzny.testapplicationuran.FileModelAdapter;
import com.artemmotuzny.testapplicationuran.R;
import com.artemmotuzny.testapplicationuran.db.DataBase;
import com.artemmotuzny.testapplicationuran.domain.FileModel;
import com.artemmotuzny.testapplicationuran.interactors.GetInteractorImpl;
import com.artemmotuzny.testapplicationuran.presenter.MainPresenter;
import com.artemmotuzny.testapplicationuran.presenter.MainPresenterimpl;
import com.artemmotuzny.testapplicationuran.repository.FileModelRepository;

import java.util.ArrayList;

/**
 * Created by tema_ on 04.10.2016.
 */

public class MainActivity extends AppCompatActivity implements MainView{

    private MainPresenter presenter;
    private TextView emptyTextView;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setDependencies();
        setContentView(R.layout.activity_main);
        initView();
        presenter.getRootFiles();


    }

    private void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        recyclerView = (RecyclerView)findViewById(R.id.main_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        emptyTextView = (TextView)findViewById(R.id.main_empty);

        setSupportActionBar(toolbar);
    }

    //Typically, this action is done with the Dagger2(DI)
    private void setDependencies() {
        DataBase dataBase = new DataBase(getApplicationContext());
        FileModelRepository fileModelRepository = new FileModelRepository(dataBase);
        GetInteractorImpl getInteractor= new GetInteractorImpl(fileModelRepository);
        presenter = new MainPresenterimpl(getInteractor,this);
    }

    @Override
    public void setAdapter(ArrayList<FileModel> list) {
        if(emptyTextView.getVisibility() == View.VISIBLE){
            emptyTextView.setVisibility(View.GONE);
        }
        FileModelAdapter adapter = new FileModelAdapter(list);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        presenter.back();
    }

    @Override
    public void showEmptyFolder() {
        emptyTextView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showLog(String name) {
        Toast.makeText(this,"LOG - "+name,Toast.LENGTH_LONG).show();
    }

    @Override
    public void setToolbarText(String folderName) {
        getSupportActionBar().setTitle(folderName);
    }

    @Override
    public void showDialog() {
        ContextDialog dialog = new ContextDialog();
        dialog.show(getFragmentManager(),"Dialog");
    }

    @Override
    public void myOnBackPressed() {
        super.onBackPressed();
    }
}
