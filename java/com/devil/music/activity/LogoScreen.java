package com.devil.music.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.devil.music.R;

public class LogoScreen extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo_screen);
        Handler x = new Handler();
        x.postDelayed(new LogoHandler(),2000);
    }

    class LogoHandler implements Runnable{
        @Override
        public void run() {
            startActivity(new Intent(getApplication(),MainActivity.class));
            LogoScreen.this.finish();
        }
    }
}
