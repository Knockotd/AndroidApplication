package com.tistory.simpleisbest.androidapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;

public class a0928Image extends AppCompatActivity {
    //스레드를 anonymous class 를 이용해서 만들것인데 anonymous class는 지역변수를 사용할 수 없습니다. / 자주 쓰기 때문에 이 부분은 기억해두어야 한다.
    ImageView imageView;
    Bitmap bitmap;
    String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a0928_image);
        imageView = (ImageView)findViewById(R.id.login);
        //리소스에 포함된 이미지 가져오기
        //imageView.setImageResource(R.drawable.fish1);

        //웹의 이미지 출력하기 - 인터넷 권한을 부여하고(해당 모듈의 manifests-AndroidManifest.xml 에 부여)
        //주의해야할 것은 안드로이드는 인터넷 사용 시 스레드를 이용해야만 실행이 된다는 것이다.
        url = "https://icon-icons.com/icons2/1183/PNG/512/1490133458-social-icons08_82209.png";

        //이미지를 다운로드 받기 위한 스레드 생성
        Thread th = new Thread(){
            public void run(){
                try{
                    //웹이서 데이터를 가져올 수 있는 스트림을 생성
                    InputStream is = new URL(url).openStream();
                    //스트림의 데이터를 이미지로 변경. bitmap 패키지는 이미지 파일만 읽을 수 있
                    bitmap = BitmapFactory.decodeStream(is);
                }catch (Exception e){
                    Log.e("에러", e.getMessage());
                }
            }
        };
        //스레드 시작
        th.start();

        //스레드의 수행이 종료되면 이미지를 설정
        try{
            //스레드의 수행이 종료될 때까지 대기
            th.join();
            imageView.setImageBitmap(bitmap);
        }catch (Exception e){
            Log.e("에러", e.getMessage());
        }
    }
}
