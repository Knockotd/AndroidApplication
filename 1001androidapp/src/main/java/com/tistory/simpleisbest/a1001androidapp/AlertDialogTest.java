package com.tistory.simpleisbest.a1001androidapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AlertDialogTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog_test);

        TextView txt = (TextView)findViewById(R.id.txt);
        try{
            for(int i=0; i<10;i=i+1){
                txt.setText(""+i);
                Thread.sleep(2000);
            }
        }catch (Exception e){

        }

        Button alertdialogbtn = (Button)findViewById(R.id.alertdialog);
        alertdialogbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //메소드 체이닝을 이용한 생성과 출력
                new AlertDialog.Builder(AlertDialogTest.this).setMessage("기본 대화상자").setTitle("대화상자")
                        .setIcon(R.drawable.notification_bell)
                        .setPositiveButton("긍정", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(AlertDialogTest.this,"긍정을 누름",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNeutralButton("중립", null)
                        .setNegativeButton("부정", null)
                        .setCancelable(false)
                        .show();
            }
        });

        Button btnsync = (Button)findViewById(R.id.btnsync);
        btnsync.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                //대화상자 출력
                new AlertDialog.Builder(AlertDialogTest.this)
                        .setMessage("엑티비티 종료")
                        .setTitle("대화상자")
                        .setIcon(R.drawable.notification_bell)
                        .show();
                //토스트 출력
                Toast.makeText(AlertDialogTest.this, "토스트 출력", Toast.LENGTH_LONG).show();

                //엑티비티 종료
                finish();
            }
        });
    }
}
