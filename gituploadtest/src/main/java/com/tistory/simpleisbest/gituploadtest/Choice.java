package com.tistory.simpleisbest.gituploadtest;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Choice extends AppCompatActivity {
    //선택 여부를 판단하기 위한 배열
    boolean [] mSelect ={false,false,false,false,false};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);

        Button btn = (Button)findViewById(R.id.multiselect);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(Choice.this)
                        .setTitle("좋아하는 연예인")
                        .setIcon(android.R.drawable.btn_plus)
                        .setMultiChoiceItems(R.array.player,mSelect,null)
                        .setNegativeButton("취소", null)
                        .show();
            }
        });
    }
}
