package com.example.sunflowergame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int weather = 0;
    TextView text_id;
    Button btn_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {//앱에선 여기가 보여짐
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text_id = findViewById(R.id.text_id);
        btn_test = findViewById(R.id.btn_test);

        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                weather = random.nextInt(13) +15;
                text_id.setText(Integer.toString(weather)+"도 입니다.");
            }
        });

    }

}
