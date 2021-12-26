package com.longyinstudio.box;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    public Context mContext;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
    }

    public void showShortToast(String msg){
        Toast.makeText(mContext,msg,Toast.LENGTH_SHORT).show();
    }

    public void showLongToast(String lmsg){
        Toast.makeText(mContext,lmsg,Toast.LENGTH_SHORT).show();
    }

    public void toActivity(Class className){
        Intent in = new Intent(mContext,className);
        startActivity(in);
    }
}
