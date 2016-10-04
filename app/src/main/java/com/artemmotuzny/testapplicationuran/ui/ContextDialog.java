package com.artemmotuzny.testapplicationuran.ui;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;

import com.artemmotuzny.testapplicationuran.R;
import com.artemmotuzny.testapplicationuran.events.OnDialogClickEvent;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by tema_ on 04.10.2016.
 */

public class ContextDialog extends DialogFragment {
    private Button favorite, link, delete;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);

        // request a window without the title
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_context, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        favorite = (Button)view.findViewById(R.id.dialog_f);
        link = (Button)view.findViewById(R.id.dialog_l);
        delete = (Button)view.findViewById(R.id.dialog_d);

        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String log = null;
                switch (v.getId()){
                    case R.id.dialog_f:
                        log = "favorite";
                        break;
                    case R.id.dialog_l:
                        log = "link";
                        break;
                    case R.id.dialog_d:
                        log = "del";
                        break;
                }
                EventBus.getDefault().post(new OnDialogClickEvent(log));
                dismiss();
            }
        };

        favorite.setOnClickListener(clickListener);
        link.setOnClickListener(clickListener);
        delete.setOnClickListener(clickListener);
    }
}
