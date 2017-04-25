package com.devil.music.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Devil on 2017/4/24.
 */

public class MusicRecord {
    private String musicTitle;
    private String musicSinger;
    private String musicAlbum;
    private String musicUrl;
    private long musicSize;
    private String musicName;

    public String getMusicTitle() {
        return musicTitle;
    }

    public void setMusicTitle(String musicTitle) {
        this.musicTitle = musicTitle;
    }

    public String getMusicSinger() {
        return musicSinger;
    }

    public void setMusicSinger(String musicSinger) {
        this.musicSinger = musicSinger;
    }

    public String getMusicAlbum() {
        return musicAlbum;
    }

    public void setMusicAlbum(String musicAlbum) {
        this.musicAlbum = musicAlbum;
    }

    public String getMusicUrl() {
        return musicUrl;
    }

    public void setMusicUrl(String musicUrl) {
        this.musicUrl = musicUrl;
    }

    public long getMusicSize() {
        return musicSize;
    }

    public void setMusicSize(long musicSize) {
        this.musicSize = musicSize;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public Map<String,Object> toMap(){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("musicTitle",musicTitle);
        map.put("musicSinger",musicSinger);
        map.put("musicAlbum",musicAlbum);
        map.put("musicUrl",musicUrl);
        map.put("musicSize",musicSize);
        map.put("musicName",musicName);
        return map;
    }
}
