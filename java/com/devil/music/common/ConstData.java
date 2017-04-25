package com.devil.music.common;

import com.devil.music.R;

/**
 * Created by Devil on 2017/3/7.
 */

public class ConstData {
    public static final String USERNAME_NULL_ERROR = "用户名不能为空";
    public static final String PASSEORD_NULL_ERROR = "密码不能为空";
    public static final String PASSEORD_FORMAT_ERROR = "密码必须包含6位数字和字母";
    public static final String LOGIN_SUCCESS = "登陆成功";
    public static final String IMPORTANT_TREATY = "请阅读相关条约";
    public static final String COUNT_ERROR = "帐号或密码错误";

    public static final String[] musicTypes = new String[]{
            ConstData.LOCALMUSIC,
            ConstData.RECENTMUSILC,
            ConstData.DOWNLOAD,
            ConstData.COLLECTION
    };

    public static final int[] imageids = new int[]{
        R.drawable.music_icon, R.drawable.headphones_icon,
        R.drawable.download_icon,R.drawable.star_fav_icon
    };

    public static final String LOCALMUSIC = "本地音乐";
    public static final String RECENTMUSILC = "最近播放";
    public static final String DOWNLOAD = "下载管理";
    public static final String COLLECTION = "我的收藏";
}
