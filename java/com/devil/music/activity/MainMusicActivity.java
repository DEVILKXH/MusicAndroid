package com.devil.music.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.devil.music.R;
import com.devil.music.common.Const;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MainMusicActivity extends FragmentActivity implements View.OnClickListener {
    private ImageView msettingBtn = null;
    private ImageView msearch = null;
    private ImageView msearchBtn = null;
    private ImageView mback = null;
    private TextView msearchText = null;
    private DrawerLayout mdrawerLayout = null;
    private LinearLayout searchLayout = null;
    private ListView listView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main_music);
        init();
        attachClickListener();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.msearch:
                if(searchLayout.getVisibility() == View.GONE){
                    searchLayout.setVisibility(View.VISIBLE);
                }else{
                    searchLayout.setVisibility(View.GONE);
                }
                break;
            case R.id.msetting:
                mdrawerLayout.openDrawer(Gravity.LEFT);
                break;
            case R.id.msearchBack:
                if(searchLayout.getVisibility() == View.GONE){
                    searchLayout.setVisibility(View.VISIBLE);
                }else{
                    searchLayout.setVisibility(View.GONE);
                }
                break;
            default:
                ;
        }
    }

    public void init(){
        mdrawerLayout = (DrawerLayout) findViewById(R.id.mdrawerLayout);
        mdrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
        mback = (ImageView) findViewById(R.id.msearchBack);
        msettingBtn = (ImageView) findViewById(R.id.msetting);
        msearch = (ImageView) findViewById(R.id.msearch);
        msearchBtn = (ImageView) findViewById(R.id.msearchBtn);
        msearchText = (TextView) findViewById(R.id.msearchText);
        searchLayout = (LinearLayout) findViewById(R.id.searchLayout);
        listView = (ListView) findViewById(R.id.music_list_type);
        List<Map<String,Object>> listItemTypes = new ArrayList<Map<String, Object>>();
        for(int i = 0 ; i < Const.musicTypes.length; i++){
            Map<String,Object> itemTypes = new HashMap<String,Object>();
            itemTypes.put("music_icon",Const.imageids[i]);
            itemTypes.put("music_text",Const.musicTypes[i]);
            listItemTypes.add(itemTypes);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,listItemTypes,
                R.layout.muslic_list_layout,
                new String[]{"music_icon","music_text"},
                new int[]{R.id.music_icon,R.id.music_text});
        listView.setAdapter(simpleAdapter);
    }

    public void attachClickListener() {
        msettingBtn.setOnClickListener(this);
        msearch.setOnClickListener(this);
        mback.setOnClickListener(this);
        msearchBtn.setOnClickListener(this);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.print(Const.musicTypes[position]);
            }
        });
    }

    @Override
    public void onBackPressed(){
        boolean flag = false;
        if(searchLayout != null){
            if(searchLayout.getVisibility() == View.VISIBLE){
                searchLayout.setVisibility(View.GONE);
                flag = true;
            }
        }
        if(mdrawerLayout != null){
            if(mdrawerLayout.isDrawerOpen(Gravity.LEFT)){
                mdrawerLayout.closeDrawer(Gravity.LEFT);
                flag = true;
            }
        }
        if(!flag){
            super.onBackPressed();
        }
    }
}