package com.example.test5;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    EditText input1;
    EditText input2;

    TextView output1;

    TextView timeOutput;

    SimpleDateFormat format = new SimpleDateFormat("YYYY-mm-dd HH:mm:ss");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }

    void init(){
        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);

        output1 = findViewById(R.id.output1);
        timeOutput =findViewById(R.id.timeOutput);

        Button calcButton = findViewById(R.id.calcButton);
        calcButton.setOnClickListener(v ->{
            // 기본 입장료 계산하기
            calculateBasic();
        });

        // 시작 버튼
        Button startButton = findViewById(R.id.startButton);
        startButton.setOnClickListener(v->{

            startTime();
        });

    }

    void startTime(){

        new Thread(new Runnable() {
            @Override
            public void run() {

                // 계속 반복하기
                boolean running = true;
                while(running) {

                    // 현재시간 계산해서 화면에 보여주기
                    Date date = new Date();
                    String now = format.format(date);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            timeOutput.setText(now);

                        }
                    });

                    // 1초동안 쉬기
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();
    }

    // 기본 입장료 계산 함수
    void calculateBasic(){

        // 입력상자 2개에서 값을 가져오기
        String adultCountStr = input1.getText().toString();
        String childCountStr = input2.getText().toString();

        // 형변환
        int adultCount = 0;
        int childCount = 0;

        try {
            adultCount = Integer.parseInt(adultCountStr);
            childCount = Integer.parseInt(childCountStr);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 입력상자에서 1인당 요금 값 가져오기
        int adultFee = 20000;
        int childFee = 9900;

        // 기본 입장료 계산하기
        int basicFee = (adultCount * adultFee) + (childCount * childFee);

        // 기본 입장료 화면에 보여주기
        String basicFeeStr = String.valueOf(basicFee);

        //숫자에 콤마 붙여주기7
        String basicFeeFormated = formatComma(basicFeeStr);

        output1.setText(basicFeeFormated);



    }

    String formatComma(String value) {

        String reverseStr = new StringBuilder(value).reverse().toString();
        StringBuilder builder = new StringBuilder();

        for (int i=0; i<reverseStr.length(); i++) {
            char out = reverseStr.charAt(i);
            builder.append(out);

            if((i+1) % 3 == 0 && (i+1) != reverseStr.length()) {
                builder.append(",");
            }

        }
        String basicFeeFormated = builder.reverse().toString();

        return basicFeeFormated;
    }

}