package com.devil.music.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.devil.music.R;
import com.devil.music.common.Const;
import com.devil.music.fragment.MainFragment;
import com.devil.music.utils.StringUtils;


public class MainActivity extends Activity implements View.OnClickListener{

    private CheckThread thread;

    class CheckThread extends  Thread{
        public Handler myHandler;
        public void run() {
            Looper.prepare();
            myHandler = new Handler(){
                @Override
                public void handleMessage(Message msg) {
                    if(msg.what == 0x123){
                        Bundle bundle = msg.getData();
                        String username =bundle.getString("username");
                        String password = bundle.getString("password");

                        if (StringUtils.isNullOrBlank(username)){
                            Toast.makeText(MainActivity.this, Const.USERNAME_NULL_ERROR, Toast.LENGTH_SHORT).show();
                            return ;
                        }
                        if(StringUtils.isNullOrBlank(password)){
                            Toast.makeText(MainActivity.this, Const.PASSEORD_NULL_ERROR, Toast.LENGTH_SHORT).show();
                            return ;
                        }
                        if("admin".equals(username) && "admin".equals(password)){
                            Toast.makeText(MainActivity.this,Const.LOGIN_SUCCESS,Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this,MainMusicActivity.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(MainActivity.this,Const.COUNT_ERROR,Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            };
            Looper.loop();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button loginBtn = (Button) findViewById(R.id.login);
        TextView reg = (TextView)findViewById(R.id.register);
        loginBtn.setOnClickListener(this);
        reg.setOnClickListener(this);
        thread = new CheckThread();
        thread.start();
    }

    @Override
    public void onClick(View v) {
        TextView userNameView = (TextView) findViewById(R.id.username);
        TextView passWordView = (TextView) findViewById(R.id.password);
        String username = userNameView.getText().toString();
        String password = passWordView.getText().toString();
        switch (v.getId()){
            case R.id.login:
                Message msg = new Message();
                msg.what = 0x123;
                Bundle bundle = new Bundle();
                bundle.putString("username",username);
                bundle.putString("password",password);
                msg.setData(bundle);
                thread.myHandler.sendMessage(msg);
                break;
            case R.id.register:
                Intent intent = new Intent(this,Register.class);
                startActivity(intent);
                break;
            default: break;
        }
    }

}
