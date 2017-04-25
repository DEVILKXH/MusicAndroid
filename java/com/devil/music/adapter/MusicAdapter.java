package com.devil.music.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.devil.music.entity.MusicRecord;

import java.util.List;

/**
 * Created by Devil on 2017/4/24.
 */

public class MusicAdapter extends BaseAdapter{
    private List<MusicRecord> musicList;
    private Context context;
    public MusicAdapter(Context context,List<MusicRecord> musicList){
        this.context = context;
        this.musicList = musicList;
    }

    public void setListItem(List<MusicRecord> musicList){
        this.musicList = musicList;
    }

    @Override
    public int getCount() {
        return musicList.size();
    }

    @Override
    public Object getItem(int position) {
        return musicList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){

        }
        return null;
    }
}
