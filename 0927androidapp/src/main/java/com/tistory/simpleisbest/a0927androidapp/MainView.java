package com.tistory.simpleisbest.a0927androidapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main_view);
        //레이아웃을 생성 - = 컨테이너 - 다른 뷰들을 묶어주기 위한 뷰 그룹
        LinearLayout layout = new LinearLayout(this);

        //뷰를 생성해서 레이아웃에 추가
        Button btn1 = new Button(this);
        btn1.setText("버튼1");
        layout.addView(btn1);

        Button btn2 = new Button(this);
        btn2.setText("버튼2");
        layout.addView(btn2);

        //Activity의 뷰로 코드로 만든 뷰를 설정
        setContentView(layout);
    }
}
