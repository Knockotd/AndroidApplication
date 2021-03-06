package com.tistory.simpleisbest.androidapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class a0928Text extends AppCompatActivity {
    private EditText editText;
    private TextView textView;
    private EditText nextEdit;

    //키보드 관리 객체를 저장할 변수 선언
    InputMethodManager imm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a0928_text);
        //xml 에 디자인 한 뷰 찾아오기
        editText = (EditText)findViewById(R.id.sampleedit);
        textView = (TextView)findViewById(R.id.sampleview);
        nextEdit = (EditText)findViewById(R.id.nextedit);



        //조작
        textView.setText("xml에 디자인 뷰 조작하기");
        textView.setTextSize(20);



        //콘솔에 출력 - 하단의 logcat에서 확인 가능
        Log.e("태그","내용");


        //키보드 관리 객체 가져오기
        imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
        //EditText에 포커스 설정
        imm.showSoftInput(editText, 0);

        Button show = (Button)findViewById(R.id.show);
        show.setOnClickListener(new View.OnClickListener(){
            public void onClick(View V){
                imm.showSoftInput(editText, 0);
            }
        });

        Button hide = (Button)findViewById(R.id.hide);
        hide.setOnClickListener(new View.OnClickListener(){
            public void onClick(View V){
                imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
            }
        });

        Button next = (Button)findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener(){
            public void onClick(View V){
                nextEdit.requestFocus();
                imm.showSoftInput(nextEdit, 0);
            }
        });
    }
}
