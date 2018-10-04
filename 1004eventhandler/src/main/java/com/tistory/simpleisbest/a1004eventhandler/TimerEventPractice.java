package com.tistory.simpleisbest.a1004eventhandler;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class TimerEventPractice extends AppCompatActivity {
    //텍스트 뷰에 출력할 문자열
    String [] ar = {"안드로이드", "드로이드안", "로이드안드", "이드안드로", "드안드로이"};

    //타이머의 인스턴스 변수 설정
    CountDownTimer timer;

    //버튼을 눌렀을 때 호출될 메소드. layout 파일에서 설정. layout의 click에 오류가 사라졌는지 확인.
    public void click(View v){
        /*
        TextView txt = (TextView)findViewById(R.id.text);
        try{
            for(int i=0; i<10; i=i+1){
                txt.setText(ar[i%5]);
                Thread.sleep(1000);
            }
        }catch (Exception e){

        }
        */

        timer.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_event_practice);
        timer = new CountDownTimer(10000,1000) {
            TextView txt = (TextView)findViewById(R.id.text);
            int idx = 0;
            //주기적으로 호출되는 메소드
            @Override
            public void onTick(long millisUntilFinished) {
                txt.setText(ar[idx%5]);
                idx = idx + 1;
            }

            @Override
            public void onFinish() {
            txt.setText("타이머 종료");
            }
        };
    }
}
