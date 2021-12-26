package com.longyinstudio.box.tools;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.longyinstudio.box.R;

import java.util.Locale;

public class TextToVoice extends AppCompatActivity {

    private TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tools_text_to_voice);
        final EditText languageed = findViewById(R.id.languageed);//绑定ID
        Button languagebt = findViewById(R.id.languagebt);
        //final String msg = languageed.getText().toString();
        // 实例化TTS语音服务
        tts = new TextToSpeech(this, status -> {
            if (status == TextToSpeech.SUCCESS) {
                int result = tts.setLanguage(Locale.CHINA);
                if (result != TextToSpeech.LANG_COUNTRY_AVAILABLE
                        && result != TextToSpeech.LANG_AVAILABLE){
                    Toast.makeText(TextToVoice.this, "TTS暂时不支持这种语音的朗读！",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        languagebt.setOnClickListener(view -> tts.speak(languageed.getText().toString(),
                TextToSpeech.QUEUE_ADD, null));


    }
}