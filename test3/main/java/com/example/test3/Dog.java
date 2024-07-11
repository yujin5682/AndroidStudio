package com.example.test3;

import android.media.Image;
import android.widget.ImageView;

// Animal 붕어빵 틀의 변수상자나 함수상자를 그대로 물려받아서 씀. -> 재정의
public class Dog extends Animal {

    Dog (String name, int age, String mobile) {
        // 나 자신을 가리킬때는 this. , 부모 생성자함수에서 가져올 때는 super.
        super(name, age, mobile);
    }


    // Animal 부모 안에 만들어져 있는 함수상자를 재정의
    void run(ImageView outputImage) {
        // 화면에 있는 이미지뷰의 이미지를 강아지가 뛰어가는 이미지로 바꾼다.
        outputImage.setImageResource(R.drawable.dog_run);
    }

    void standup(ImageView outputImage) {
        outputImage.setImageResource(R.drawable.dog_stand);
    }

    void sitdown(ImageView outputImage) {
        outputImage.setImageResource(R.drawable.dog_sit);
    }


}
