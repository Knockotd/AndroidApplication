package com.tistory.simpleisbest.gituploadtest;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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
                        .setMultiChoiceItems(R.array.player, mSelect, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                            }
                        })
                        .setNegativeButton("취소", null)
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //arrays.xml 파일에 만든 문자열 배열 가져오기
                                String [] player = getResources().getStringArray(R.array.player);
                                //선택 여부가 저장되어 있는 배열을 순회하면서
                                //true 일 때 player의 데이터를 문자열에 추가
                                String result = "";
                                for(int i=0; i<mSelect.length; i=i+1){
                                    result = result + player[i] + "/t";
                                }
                                Toast.makeText(Choice.this,result,Toast.LENGTH_LONG).show();
                            }
                            //선택한 데이터 문자열을 토스트로 출력

                        })
                        .show();
            }
        });
    }
}
