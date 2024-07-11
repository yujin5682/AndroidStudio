package com.example.test4;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView output1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }

    void init() {

        output1 = findViewById(R.id.output1);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(v -> {

            makeNumbers();

        });
    }

    void makeNumbers() {

        double no = Math.random();
        double no2 = Math.floor(no * 45);
        int no3 = new Double(no2).intValue();

        Log.d("Main", "만들어진 숫자 : " + no);
        Log.d("Main", "만들어진 숫자 : " + no2);
        Log.d("Main", "만들어진 숫자 : " + no3);

        output1.setText("" + no3);

    }
}