package com.tistory.simpleisbest.gituploadtest;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

public class Choice extends AppCompatActivity {
    //선택 여부를 판단하기 위한 배열
    boolean [] mSelect ={false,false,false,false,false, false,false};

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
                            mSelect[which] = isChecked;
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
                                    if(mSelect[i]) {
                                        result = result + player[i] + "/t";
                                    } }
                                //선택한 데이터 문자열을 토스트로 출력
                                Toast.makeText(Choice.this,result,Toast.LENGTH_LONG).show();
                            }


                        })
                        .show();
            }
        });

        Button customdialog = (Button)findViewById(R.id.customedialog);
        customdialog.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //레이아웃 파일의 내용 불러오기
                //Anonymous 클래스에서 사용하기 위해서 final 을 붙음
                //Anonymous 클래스에서는 자신을 포함하는 메소드의 지역변수를 사용할 수 없습니다.
                //final은 가능합니다.
                final LinearLayout login = (LinearLayout)View.inflate(Choice.this,R.layout.login,null);
                new AlertDialog.Builder(Choice.this)
                        .setIcon(android.R.drawable.sym_def_app_icon)
                        .setTitle("로그인")
                        .setView(login)
                        .setNegativeButton("취소",null)
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                               //입력한 값 가져오기 - new로 만든 것은 지역변수가 쓸 수 없다. - 인스턴스 변수로 만들거나 final로 만들어주면된다.
                                //Anonymous 클래스에서 사용하기 위해서 final 을 붙음
                                //Anonymous 클래스에서는 자신을 포함하는 메소드의 지역변수를 사용할 수 없습니다.
                                //final은 가능합니다.
                                EditText id = (EditText)login.findViewById(R.id.id);
                                EditText password = (EditText)login.findViewById(R.id.password);
                                String result = "id : "+ id.getText().toString() + "/ password : " + password.getText().toString();

                                Toast.makeText(Choice.this,
                                        result,
                                        Toast.LENGTH_LONG)
                                        .show();
                            }
                        })
                        .show();
            }
        });

        final Button popupbtn = (Button)findViewById(R.id.popupwindow);
        final LinearLayout popup = (LinearLayout)View.inflate(Choice.this, R.layout.popup,null);
        popupbtn.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                //팝업 윈도우
                final PopupWindow popupWindow = new PopupWindow(popup, 200, 200, true);
                //화면 출력 - 첫번째 매개변수는 기준 뷰
                //두번째와 세번재는 좌표 네번째 포커스 여부

                //출력위치
               popupWindow.showAtLocation(popupbtn, Gravity.NO_GRAVITY,100,100);

                Button close = (Button)popup.findViewById(R.id.close);
                close.setOnClickListener(new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                    }
                });
            }
        });


    }
}
