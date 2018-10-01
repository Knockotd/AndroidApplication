package com.tistory.simpleisbest.a1001androidapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class FramLayout extends AppCompatActivity {

    private Button button1, button2, button3;
    private LinearLayout view1, view2, view3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fram_layout);

        //layout에 만든 뷰 찾아오기

        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        view1 =(LinearLayout)findViewById(R.id.view1);
        view2 =(LinearLayout)findViewById(R.id.view2);
        view3 =(LinearLayout)findViewById(R.id.view3);

        //클릭했을 때 처리
        button1.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                view1.setVisibility(View.VISIBLE);
                view2.setVisibility(View.INVISIBLE);
                view3.setVisibility(View.INVISIBLE);
            }
        });
        button2.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                view1.setVisibility(View.INVISIBLE);
                view2.setVisibility(View.VISIBLE);
                view3.setVisibility(View.INVISIBLE);
            }
        });
        button3.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                view1.setVisibility(View.INVISIBLE);
                view2.setVisibility(View.INVISIBLE);
                view3.setVisibility(View.VISIBLE);
            }
        });
    }
}
