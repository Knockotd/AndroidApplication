package com.tistory.simpleisbest.a1004eventhandler;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class EventHandler1 extends AppCompatActivity {

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        String msg1 = "당신은 x : " + x + " y : " + y + "좌표를 클릭하셨습니다.";
        String msg2 = String.format("x:%.1f y:%f 터치",x,y);
        Toast.makeText(this, msg2, Toast.LENGTH_SHORT).show();
        return super.onTouchEvent(event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_handler1);



        //2개의 버튼 찾아오기
        final Button button1 = (Button)findViewById(R.id.button1);
        final Button button2 = (Button)findViewById(R.id.button2);
/*
        //Button의 Click은 View.OnClickListener가 처리할 수 있음
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //이벤트가 발생한 객체의 주소 즉, 여기서는 button1과 v는 같다. 하지만 자료형이 다르다. 다양한 이벤트를 받기 위해서 최상위 클래스인 view로 자료형을 만든 것이다.
                //그래서 두개를 비교하려면 자료형을 바꾸어주어야 한다. 어떤 쪽을 바꾸던 상관은 없다. 하지만 크기가 큰 애를 기준으로 한다 왜냐하면 할 수 있는 일이 많기 때문이다.
                //여기서 크다라는 것은 상위 클래스가 아니고 내용이 더 많은 클래스를 뜻한다.
                //Button이 view를 상속받아 내용을 추가한 것이기 때문에 이 때에는 Button이 크기가 더 크다.

                Toast.makeText(EventHandler1.this, "첫번째 버튼 클릭 함", Toast.LENGTH_LONG).show();
                        //어노니먼스 클래스는 new의 클래스가 상위가 되므로 this를 붙이면 여기서는 OnClickListener가 된다.
                        //그래서 어노니먼스 클래스에서 Toast의 첫번째 매개변수는 그냥 this만 쓸 일이 거의 없다.
            }
        });

        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //이벤트가 발생한 객체의 주소 즉, 여기서는 button1과 v는 같다. 하지만 자료형이 다르다. 다양한 이벤트를 받기 위해서 최상위 클래스인 view로 자료형을 만든 것이다.
                //그래서 두개를 비교하려면 자료형을 바꾸어주어야 한다. 어떤 쪽을 바꾸던 상관은 없다. 하지만 크기가 큰 애를 기준으로 한다 왜냐하면 할 수 있는 일이 많기 때문이다.
                //여기서 크다라는 것은 상위 클래스가 아니고 내용이 더 많은 클래스를 뜻한다.
                //Button이 view를 상속받아 내용을 추가한 것이기 때문에 이 때에는 Button이 크기가 더 크다.

                Toast.makeText(EventHandler1.this, "두번째 버튼 클릭 함", Toast.LENGTH_LONG).show();
                //어노니먼스 클래스는 new의 클래스가 상위가 되므로 this를 붙이면 여기서는 OnClickListener가 된다.
                //그래서 어노니먼스 클래스에서 Toast의 첫번째 매개변수는 그냥 this만 쓸 일이 거의 없다.
            }
        });
*/

        View.OnClickListener eventhandler = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = (Button)v;
                String msg = btn.getText().toString();
                Toast.makeText(EventHandler1.this,msg,Toast.LENGTH_SHORT).show();
            }
        };



        button1.setOnClickListener(eventhandler);
        button2.setOnClickListener(eventhandler);

    }
}
