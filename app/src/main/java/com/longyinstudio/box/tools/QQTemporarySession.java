package com.longyinstudio.box.tools;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.longyinstudio.box.R;

public class QQTemporarySession extends AppCompatActivity {

    private EditText qqliaotianed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tools_qq_temporary_session);



        qqliaotianed= findViewById(R.id.qqliaotianed);//绑定ID
        Button qqliaotianbt = findViewById(R.id.qqliaotianbt);
        qqliaotianbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a=qqliaotianed.getText().toString();//获取输入框内容
                //String url11 = "mqqwpa://im/chat?chat_type=wpa&uin="+a+"&version=1";
                //startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url11)));
                Intent intent = new Intent();
                intent.setData(Uri.parse("mqqwpa://im/chat?chat_type=wpa&uin="+a));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                try {
                    startActivity(intent);
                } catch (Exception e) {//
                    Toast.makeText(QQTemporarySession.this,"未安装手Q或安装的版本不支持",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}