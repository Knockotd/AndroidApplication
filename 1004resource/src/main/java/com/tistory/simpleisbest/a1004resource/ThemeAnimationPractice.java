package com.tistory.simpleisbest.a1004resource;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class ThemeAnimationPractice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme_animation_practice);

        final ImageView imageView = (ImageView)findViewById(R.id.imageView);
        //애니메이션 찾아오기
        Animation ani1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.in);

        //애니메이션의 리스너를 설정

        ani1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Animation ani2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);

                ani2.setFillAfter(true);
                imageView.startAnimation(ani2);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        imageView.startAnimation(ani1);
        //imageView.startAnimation(ani2);
        //이렇게 하면 ani2 만 적용이되는 걸 확인가능
    }
}
