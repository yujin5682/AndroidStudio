package com.example.test3;

import android.os.Bundle;
import android.os.health.SystemHealthManager;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.time.Clock;

//화면
public class MainActivity extends AppCompatActivity {
    
    // 화면이 보이는 동안에는 계속 붕어빵이 유지됨
    EditText input1;
    EditText input2;
    EditText input3;

    ImageView outputImage;
    TextView outputText;

    // 강아지나 고양이를 담아둘 변수상자
    Animal animal;

    LinearLayout container;


    // 화면이 보이기 전에 한 번 실행됨
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);     // activity_main.xml 파일의 화면 모양과 이 파일의 소스 코드가 하나의 화면이 된다는 것을 알려줌

        init();

    }

    // 초기화
    public void init() {
        // 화면에 보이는 것들(자동으로 만들어진 붕어빵) 중에서 필요한 것들을 찾아서 변수상자에 넣어두기
        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);
        input3 = findViewById(R.id.input3);

        outputImage = findViewById(R.id.outputImage);
        outputText = findViewById(R.id.outputText);

        container = findViewById(R.id.container);
        // 버튼을 눌렀을 때 동작시키기

        // 강아지 만들기 버튼
        Button createDogButton = findViewById(R.id.createDogButton);
        createDogButton.setOnClickListener(v -> {

            createDog();

        });

        // 고양이 만들기 버튼
        Button createCatButton = findViewById(R.id.createCatButton);
        createCatButton.setOnClickListener(v -> {

            createCat();

        });
        // 뛰어 버튼
        Button runButton = findViewById(R.id.runButton);
        runButton.setOnClickListener(v -> {
            // 변수상자가 비어있는지 확인하기
            if (animal != null && animal instanceof Dog) {
                animal.run(outputImage);
                outputText.setText("강아지가 뛰어갑니다.");
            } else if(animal != null && animal instanceof Cat) {
                animal.run(outputImage);
                outputText.setText("고양이가 뛰어갑니다.");
            } else {
                //Log.d("Main", "animal 변수상자가 null입니다.");
                outputText.setText("동물을 먼저 만들어주세요.");

            }

        });

        //서있기 버튼
        Button standButton = findViewById(R.id.standButton);
        standButton.setOnClickListener(v -> {

            System.out.println("서있기");
            if (animal != null && animal instanceof Dog) {
                animal.standup(outputImage);
                outputText.setText("강아지가 서있습니다.");
            } else if (animal != null && animal instanceof Cat) {
                animal.standup(outputImage);
                outputText.setText("고양이가 서있습니다.");
            } else {
                outputText.setText("동물을 만들어주세요.");
            }
        });

        Button sitButton = findViewById(R.id.sitButton);
        sitButton.setOnClickListener(v -> {

            if (animal != null && animal instanceof Dog) {
                animal.sitdown(outputImage);
                outputText.setText("강아지가 앉아있습니다.");
            } else if (animal != null && animal instanceof Cat) {
                animal.sitdown(outputImage);
                outputText.setText("고양이가 앉아있습니다.");
            } else {
                outputText.setText("동물을 만들어주세요.");
            }
        });

        // 추가 버튼
        Button addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(v -> {

            ImageView imageView1 = new ImageView(getApplicationContext());
            imageView1.setImageResource(R.drawable.dog_stand);
            container.addView(imageView1);
        });

    }

    void createDog() {
        // 입력상자에서 사용자가 입력한 값을 가져오기
        String name = input1.getText().toString();
        String ageStr = input2.getText().toString();
        String mobile = input3.getText().toString();

        int age = 0;

        try {
             age = Integer.parseInt(ageStr);

            // 강아지를 만들어서 변수상자에 넣기
            animal = new Dog(name, age, mobile);

            // 화면에 결과 보여주기
            outputText.setText("강아지가 만들어졌습니다.");

        } catch(Exception e) {
            e.printStackTrace();

            outputText.setText(e.getMessage());
        }

    }

    void createCat() {

        String name = input1.getText().toString();
        String ageStr = input2.getText().toString();
        String mobile = input3.getText().toString();

        int age = Integer.parseInt(ageStr);

        animal = new Cat(name, age, mobile);

        outputText.setText("고양이가 만들어졌습니다.");
    }
}