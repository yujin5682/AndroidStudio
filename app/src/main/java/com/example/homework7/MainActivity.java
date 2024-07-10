package com.example.homework7;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText inputName;
    EditText inputAge;
    EditText inputPhone;
    ImageView imageView;

    Animal dog;
    Animal cat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputName = findViewById(R.id.inputName);
        inputAge = findViewById(R.id.inputAge);
        inputPhone = findViewById(R.id.inputPhone);
        imageView = findViewById(R.id.imageView);

        //강아지 객체 생성
        dog = new Dog("", 0, "");
        cat = new Cat("", 0, "");

        Button createDogButton = findViewById(R.id.createDogButton);
        createDogButton.setOnClickListener(view -> {
            Dog.createAnimal(inputName, inputAge, inputPhone);
            imageView.setImageResource(R.drawable.standupdog);
        });

        Button createCatButton = findViewById(R.id.createCatButton);
        createCatButton.setOnClickListener(view -> {

            Cat.createAnimal(inputName, inputAge, inputPhone);
            imageView.setImageResource(R.drawable.standupcat);
        });

        Button standupButton = findViewById(R.id.standupButton);
        standupButton.setOnClickListener(view -> {


        });


    }
}