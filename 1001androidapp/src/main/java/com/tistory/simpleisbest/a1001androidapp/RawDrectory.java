package com.tistory.simpleisbest.a1001androidapp;

import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class RawDrectory extends AppCompatActivity {
    private Button btnvibrate, btnsystemsound, btnusersound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raw_drectory);

        //버튼 찾아오기
        btnvibrate = (Button)findViewById(R.id.btnvibrate);
        btnsystemsound = (Button)findViewById(R.id.btnsystemsound);
        btnusersound = (Button)findViewById(R.id.btnusersound);

        //버튼 클릭 이벤트
        btnvibrate.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                //진동 만들기 - 1초동안 진동
                Vibrator vibrator = (Vibrator)getSystemService(VIBRATOR_SERVICE);
                vibrator.vibrate(3000);
            }
        });
        btnsystemsound.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                Uri systemsound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
                Ringtone ringtone = RingtoneManager.getRingtone(getApplicationContext(),systemsound);
                ringtone.play();
            }
        });
        btnusersound.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                MediaPlayer player = MediaPlayer.create(RawDrectory.this, R.raw.ifihadachicken);
                player.start();
            }
        });
    }
}
