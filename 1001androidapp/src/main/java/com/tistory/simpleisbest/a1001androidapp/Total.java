package com.tistory.simpleisbest.a1001androidapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class Total extends AppCompatActivity {
private Button btn1, btn2, btn3, btn4;
private LinearLayout view1, view2, view3, view4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total);
        btn1 = (Button)findViewById(R.id.caculator);
        btn2 = (Button)findViewById(R.id.picture);
        btn3 = (Button)findViewById(R.id.vibrateandsound);
        btn4 = (Button)findViewById(R.id.dialog);
        view1 = (LinearLayout)findViewById(R.id.frame1);
        view2 = (LinearLayout)findViewById(R.id.frame2);
        view3 = (LinearLayout)findViewById(R.id.frame3);
        view4 = (LinearLayout)findViewById(R.id.frame4);

        view1.setVisibility(View.INVISIBLE);
        view2.setVisibility(View.INVISIBLE);
        view3.setVisibility(View.INVISIBLE);
        view4.setVisibility(View.INVISIBLE);

        btn1.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                view1.setVisibility(View.VISIBLE);
                view2.setVisibility(View.INVISIBLE);
                view3.setVisibility(View.INVISIBLE);
                view4.setVisibility(View.INVISIBLE);
            }
        });
        btn2.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                view1.setVisibility(View.INVISIBLE);
                view2.setVisibility(View.VISIBLE);
                view3.setVisibility(View.INVISIBLE);
                view4.setVisibility(View.INVISIBLE);
            }
        });
        btn3.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                view1.setVisibility(View.INVISIBLE);
                view2.setVisibility(View.INVISIBLE);
                view3.setVisibility(View.VISIBLE);
                view4.setVisibility(View.INVISIBLE);
            }
        });
        btn4.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                view1.setVisibility(View.INVISIBLE);
                view2.setVisibility(View.INVISIBLE);
                view3.setVisibility(View.INVISIBLE);
                view4.setVisibility(View.VISIBLE);
            }
        });
    }
}
