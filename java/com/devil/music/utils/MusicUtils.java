package com.devil.music.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;

import com.devil.music.entity.MusicRecord;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Devil on 2017/4/24.
 */

public class MusicUtils {
    public static List<MusicRecord> getMusicData(Context context){
        List<MusicRecord> musicList = new ArrayList<MusicRecord>();
        ContentResolver contentResolver = context.getContentResolver();
        if(contentResolver != null){
            Cursor cursor = contentResolver.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,null,null,null, MediaStore.Audio.Media.DEFAULT_SORT_ORDER);
            if(null == cursor){
                return null;
            }
            if(cursor.moveToFirst()){
                do{
                    MusicRecord music = new MusicRecord();
                    String title = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE));
                    String album = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM));
                    String singer = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST));
                    if("<unknown>".equals(singer)){
                        singer = "未知歌手";
                    }
                    long size = cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media.DURATION));
                    String url = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));
                    String name = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DISPLAY_NAME));
                    String sbr = name.substring(name.length() - 3,name.length());

                    if("mp3".equals(sbr)){
                        music.setMusicAlbum(album);
                        music.setMusicName(name);
                        music.setMusicSinger(singer);
                        music.setMusicSize(size);
                        music.setMusicTitle(title);
                        music.setMusicUrl(url);
                        musicList.add(music);
                    }
                }while(cursor.moveToNext());
            }
        }
        return musicList;
    }
}
