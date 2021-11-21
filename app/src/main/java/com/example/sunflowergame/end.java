package com.example.sunflowergame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class end extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        Button btn_out;
        Button btn_replay;
        TextView result;

        btn_out = findViewById(R.id.btn_out);
        btn_replay = findViewById(R.id.btn_replay);
        result = findViewById(R.id.result);

        Intent intent = getIntent();
        int result_day = intent.getIntExtra("day",0);

        result.setText("게임을 종료합니다."+"\n"+"총 생존 day는 "+result_day+"입니다.");

        btn_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveTaskToBack(true); // 태스크를 백그라운드로 이동
                finishAndRemoveTask(); // 액티비티 종료 + 태스크 리스트에서 지우기
                android.os.Process.killProcess(android.os.Process.myPid()); // 앱 프로세스 종료
            }
        });

        btn_replay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(end.this, MainActivity.class);
                startActivity(intent); // intent 구문 실행
            }
        });

    }
}