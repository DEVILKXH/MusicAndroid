package com.devil.music.services;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.Random;

/**
 * Created by Devil on 2017/3/9.
 */

public class CheckCodeServices {

    private static CheckCodeServices checkCodeServices;
    private  Random random = new Random();
    private StringBuilder builder = new StringBuilder();
    private int margin_left = 0;
    private int margin_top = 0;

    public static CheckCodeServices getInstance(){
        if(checkCodeServices == null){
            checkCodeServices = new CheckCodeServices();
        }
        return checkCodeServices;
    }

    private void randomPadding(){
        margin_top = DEFAULT_PADDING_TOP + random.nextInt(RANGE_PADDING_TOP);
        margin_left += DEFAULT_PADDING_LEFT + random.nextInt(RANGE_PADDING_LEFT);
    }

    private  void drawLine(Canvas canvas,Paint paint){
        int color = randomColor();
        int startX = random.nextInt(DEFAULT_WIDTH);
        int startY = random.nextInt(DEFAULT_HEIGHT);
        int endX = random.nextInt(DEFAULT_WIDTH);
        int endY = random.nextInt(DEFAULT_HEIGHT);
        paint.setStrokeWidth(1);
        paint.setColor(color);
        canvas.drawLine(startX,startY,endX,endY,paint);
    }

    private int randomColor(){
        builder.delete(0,builder.length());
        String hexString;
        for(int i = 0 ;i < 3; i++){
            hexString = Integer.toHexString(random.nextInt(0xFF));
            if(hexString.length() == 1){
                hexString = "0" + hexString;
            }
            builder.append(hexString);
        }
        return Color.parseColor("#" + builder.toString());
    }

    private void randomTextStyle(Paint paint){
        int color = randomColor();
        paint.setColor(color);
        paint.setFakeBoldText(random.nextBoolean());
        float skewx = random.nextInt(11) / 10;
        skewx = random.nextBoolean() ? skewx : -skewx;
        paint.setTextSkewX(skewx);
//        paint.setStrikeThruText(true);
    }

    public  String getCheckCodeNumber(String type,int length){
        String s = null;
        int n = 62;
        if(ALL_CHARACTER.equals(type)){
            s = "1234567890qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
            n = 62;
        }else if(LOWERCASE_CODE.equals(type)){
            n = 26;
            s = "qwertyuiopasdfghjklzxcvbnm";
        }else if(UPERCASE_CODE.equals(type)){
            n = 26;
            s = "QWERTYUIOPASDFGHJKLZXCVBNM";
        }else if(NUMBER_CODE.equals(type)){
            n = 26;
            s = "1234567890";
        }else if(NUMBER_CHARACTER_CODE.equals(type)){
            n = 26;
            s = "1234567890qwertyuiopasdfghjklzxcvbnm";
        }else if(CHARACTER_CODE.equals(type)){
            n = 26;
            s = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
        }else{
            return null;
        }

        char[] checkCode = new char[length];
        for(int i = 0; i < length; i++){
            checkCode[i] = s.charAt(random.nextInt(n));
        }
        return new String(checkCode);
    }

    public  Bitmap createBitmapCode(){
        margin_left = 0;
        margin_top = 0;
        Bitmap bitmap = Bitmap.createBitmap(DEFAULT_WIDTH,DEFAULT_HEIGHT, Bitmap.Config.ARGB_8888);
        Canvas canvns = new Canvas(bitmap);
        String code = getCheckCodeNumber(ALL_CHARACTER,4);
        canvns.drawColor(Color.rgb(DEFAULT_COLOR,DEFAULT_COLOR,DEFAULT_COLOR));
        Paint paint = new Paint();
        paint.setTextSize(DEFAULT_FONT_SIZE);
        for(int i = 0; i <code.length(); i++){
            randomTextStyle(paint);
            randomPadding();
            canvns.drawText(code.charAt(i) + "",margin_left,margin_top,paint);
        }
        for(int i = 0; i < DEFAULT_line_number; i++){
            drawLine(canvns,paint);
        }
        canvns.save(canvns.ALL_SAVE_FLAG);
        canvns.restore();
        return bitmap;
    }

    public static final String LOWERCASE_CODE = "lowercase_code";
    public static final String NUMBER_CODE = "number_code";
    public static final String UPERCASE_CODE = "upercase_code";
    public static final String CHARACTER_CODE = "character_code";
    public static final String NUMBER_CHARACTER_CODE = "number_character_code";
    public static final String ALL_CHARACTER = "all_character";
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 120;
    private static final int DEFAULT_COLOR = 0xDF;
    private static final int DEFAULT_FONT_SIZE = 60;
    private static final int DEFAULT_PADDING_LEFT = 40;
    private static final int RANGE_PADDING_LEFT = 40;
    private static final int DEFAULT_PADDING_TOP = 40;
    private static final int RANGE_PADDING_TOP = 40;
    private static final int DEFAULT_line_number = 3;
}
