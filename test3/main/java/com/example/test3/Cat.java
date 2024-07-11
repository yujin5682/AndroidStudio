package com.example.test3;

import android.widget.ImageView;

public class Cat extends Animal {

    Cat(String name, int age, String mobile) {
        super(name, age, mobile);
    }

    void run(ImageView outputImage) {
        outputImage.setImageResource(R.drawable.cat_run);
    }

    void standup(ImageView outputImage) {
        outputImage.setImageResource(R.drawable.cat_stand);
    }

    void sitdown(ImageView outputImage) {
        outputImage.setImageResource(R.drawable.cat_sit);
    }
}
