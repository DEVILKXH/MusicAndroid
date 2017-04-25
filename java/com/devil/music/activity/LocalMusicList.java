package com.devil.music.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.devil.music.R;
import com.devil.music.entity.MusicRecord;
import com.devil.music.utils.MusicUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Devil on 2017/4/24.
 */

public class LocalMusicList extends FragmentActivity implements AdapterView.OnItemClickListener{

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.local_music);
        init();
        attachClickListener();
    }

    private void attachClickListener() {

    }

    private void init() {
        listView = (ListView) findViewById(R.id.music_list);
        Context context = LocalMusicList.this;
        List<MusicRecord> musicList = MusicUtils.getMusicData(context);
        List<Map<String,Object>> listMap = new ArrayList<Map<String,Object>>();
        for(MusicRecord music: musicList){
            Map<String,Object> map = music.toMap();
            listMap.add(map);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,listMap,
                R.layout.music_list_layout,
                new String[]{"musicTitle","musicSinger"},
                new int[]{R.id.music_title,R.id.music_singer});
        listView.setAdapter(simpleAdapter);
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
