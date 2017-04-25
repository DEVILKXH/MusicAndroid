package com.devil.music.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.devil.music.R;
import com.devil.music.common.ConstData;
import com.devil.music.services.CheckCodeServices;
import com.devil.music.utils.StringUtils;

public class Register extends Activity implements View.OnClickListener {

    private ImageView checkCode;
    private ImageView agree = null;
    private ImageView mback;
    private boolean active = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        checkCode = (ImageView)findViewById(R.id.img_checkcode);
        TextView login = (TextView) findViewById(R.id.login);
        agree = (ImageView) findViewById(R.id.agress_btn);
        Button reg = (Button) findViewById(R.id.register);
        mback = (ImageView)findViewById(R.id.mback);
        checkCode.setImageBitmap(CheckCodeServices.getInstance().createBitmapCode());
        checkCode.setOnClickListener(this);
        login.setOnClickListener(this);
        reg.setOnClickListener(this);
        agree.setOnClickListener(this);
        mback.setOnClickListener(this);
     }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.img_checkcode:
                checkCode.setImageBitmap(CheckCodeServices.getInstance().createBitmapCode());
                break;
            case R.id.login:
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                break;
            case R.id.register:
                if(!active){
                    Toast.makeText(Register.this, ConstData.IMPORTANT_TREATY, Toast.LENGTH_SHORT).show();
                    return ;
                }
                TextView userName = (TextView) findViewById(R.id.username);
                TextView passWord = (TextView) findViewById(R.id.password);
                TextView checkCodes = (TextView) findViewById(R.id.checkcode);
                String username = userName.getText().toString();
                String password = passWord.getText().toString();
                String checkcode = checkCodes.getText().toString();
                if (StringUtils.isNullOrBlank(username)){
                    Toast.makeText(Register.this, ConstData.USERNAME_NULL_ERROR, Toast.LENGTH_SHORT).show();
                    return ;
                }
                if(StringUtils.isNullOrBlank(password)){
                    Toast.makeText(Register.this, ConstData.PASSEORD_NULL_ERROR, Toast.LENGTH_SHORT).show();
                    return ;
                }
                Toast.makeText(Register.this,username,Toast.LENGTH_SHORT).show();
                Toast.makeText(Register.this,password,Toast.LENGTH_SHORT).show();
                break;
            case R.id.agress_btn:
                if(!active){
                    agree.setImageResource(R.drawable.success);
                }else{
                    agree.setImageResource(R.drawable.circle_bg);
                }
                active = !active;
                break;
            case R.id.important:
                break;
            case R.id.mback:
                this.finish();
                break;
            default: ;
        }
    }
}
