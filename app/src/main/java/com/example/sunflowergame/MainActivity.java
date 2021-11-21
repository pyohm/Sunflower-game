package com.example.sunflowergame;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    int deg = 0; //온도
    int weather_num = 0; //날씨 난수
    int sunny = 0; //맑음
    int cloudy = 0; //흐림
    int heart = 3; //생명력
    int day = 0;
    boolean i = true;

    TextView text_weather;
    TextView text_deg;
    Button btn_test;
    Button btn_move_if_not;
    Button btn_move_if_good;
    ImageView image_view;
    ImageView Change_image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {//앱에선 여기가 보여짐
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text_weather = findViewById(R.id.text_weather);
        text_deg = findViewById(R.id.text_deg);
        btn_test = findViewById(R.id.btn_test);

        btn_move_if_good = findViewById(R.id.btn_move_if_good);
        image_view = findViewById(R.id.image_view);



        btn_test.setOnClickListener(new View.OnClickListener() { //"과연 다음날 기온과 날씨는??" 버튼 눌렀을때
            @Override
            public void onClick(View v) {
                Random random = new Random();
                deg = random.nextInt(13) +15;
                weather_num = random.nextInt(2);
                btn_move_if_good.setEnabled(true);
                btn_test.setEnabled(false);

                if (weather_num == 0) {
                    sunny +=1;
                    cloudy = 0;
                }
                else if(weather_num == 1) {
                    cloudy +=1;
                    sunny = 0;
                }
                day += 1;

                text_deg.setText("기온: "+Integer.toString(deg)+"도 입니다."+"(적정 온도: 18도 ~ 25도)");
                text_weather.setText("날씨: "+"맑음 개수"+Integer.toString(sunny)+","+"흐림 개수"+Integer.toString(cloudy)+"\n"+
                        "day: "+Integer.toString(day)+"일차 입니다."+"\n"+"생명력: "+Integer.toString(heart));

                if(deg<18 || deg > 25) {//적정온도 아닐때
                    btn_move_if_good.setText("적정온도가 아닙니다. (다음으로 진행)");
                    image_view.setImageResource(R.drawable.sad);
                    i = false;
                }
                else {//적정온도 일때
                    btn_move_if_good.setText("적정온도가 맞습니다. (다음으로 진행)");
                    image_view.setImageResource(R.drawable.happy);
                    i = true;
                }

            }
        });

        btn_move_if_good.setOnClickListener(new View.OnClickListener() { // 진행버튼 누르면
            @Override
            public void onClick(View v) {

                if(cloudy >= 4) { // 흐림 4일때 게임 패배 조건
                    Intent intent = new Intent(MainActivity.this, end.class);
                    intent.putExtra("day",day);
                    startActivity(intent); // intent 구문 실행
                }

                image_view.setImageResource(R.drawable.normal);

                btn_test.setEnabled(true);
                btn_move_if_good.setEnabled(false);


            }
        });



    }

}
