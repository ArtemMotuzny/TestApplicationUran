package com.artemmotuzny.testapplicationuran;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.artemmotuzny.testapplicationuran.domain.FileModel;
import com.artemmotuzny.testapplicationuran.domain.FileType;
import com.artemmotuzny.testapplicationuran.events.ItemClickEvent;
import com.artemmotuzny.testapplicationuran.events.OnLongClickEvent;

import org.greenrobot.eventbus.EventBus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by tema_ on 04.10.2016.
 */

public class FileModelAdapter extends RecyclerView.Adapter<FileModelAdapter.ViewHolder> {
    ArrayList<FileModel> list;
    SimpleDateFormat simpleDateFormat;

    public FileModelAdapter(ArrayList<FileModel> list) {
        this.list = list;
        this.simpleDateFormat = new SimpleDateFormat("MMMM dd, yyyy", Locale.ENGLISH);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_list,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final FileModel model = list.get(position);

        holder.name.setText(model.getName());
        holder.date.setText(simpleDateFormat.format(model.getDate()));
        holder.checkIcon(model.getType());
        holder.checkColorLeftView(model.isOrange(),model.isBlue());

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                EventBus.getDefault().post(new OnLongClickEvent());
                return true;
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new ItemClickEvent(model));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView date;
        ImageView image;
        LinearLayout rightView;
        LinearLayout leftView;
        View leftTop;
        View leftBottom;


        public ViewHolder(View itemView) {
            super(itemView);

            name = (TextView)itemView.findViewById(R.id.main_list_item_text);
            date = (TextView)itemView.findViewById(R.id.main_list_item_date);
            image = (ImageView)itemView.findViewById(R.id.main_list_item_icon);
            rightView = (LinearLayout)itemView.findViewById(R.id.main_list_item_right_view);
            leftView = (LinearLayout)itemView.findViewById(R.id.main_list_item_left_view);
            leftTop = itemView.findViewById(R.id.main_list_item_left_top);
            leftBottom = itemView.findViewById(R.id.main_list_item_left_botom);
        }

        public void checkIcon(FileType type){
            int imageRes;
            switch (type){
                case FOLDER:
                    imageRes = R.drawable.ic_folder_open_black_24px;
                    rightView.setVisibility(View.VISIBLE);
                    break;
                case MUSIC:
                    imageRes = R.drawable.ic_music_note_black_24px;
                    break;
                case IMAGE:
                    imageRes = R.drawable.ic_filter_hdr_black_24px;
                    break;
                case VIDEO:
                    imageRes = R.drawable.ic_movie_black_24px;
                    break;

                default:imageRes = R.drawable.ic_insert_drive_file_black_24px;
            }
            image.setImageResource(imageRes);
        }

        public void checkColorLeftView(boolean orange, boolean blue) {
            if (!orange && !blue){
                leftView.setVisibility(View.GONE);
                return;
            }
            leftView.setVisibility(View.VISIBLE);
            int colorTop = 0,colorBottom = 0;

            if(orange && blue){
                colorTop = R.color.orange;
                colorBottom = R.color.blue;
            } else if (!orange && blue) {
                colorTop = R.color.blue;
                colorBottom = R.color.blue;
            }else if(orange && !blue){
                colorTop = R.color.orange;
                colorBottom = R.color.orange;
            }
            leftTop.setBackgroundResource(colorTop);
            leftBottom.setBackgroundResource(colorBottom);
        }
    }
}
