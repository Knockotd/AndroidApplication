package com.tistory.simpleisbest.a1001androidapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ToastTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast_test);
        Button toastbtn = (Button)findViewById(R.id.toast);
        toastbtn.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(ToastTest.this,"안녕하세요 토스트입니다.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
