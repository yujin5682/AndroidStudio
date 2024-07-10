package com.example.homework7;

public class Cat extends Animal{

    Cat(String name, int age, String phone) {
        super(name, age, phone);
    }

    void standup(){
        imageView.setImageResource(R.drawable.standupcat);
    }

    void sitdown(){
        imageView.setImageResource(R.drawable.sitdowncat);
    }

    void run(){
        imageView.setImageResource(R.drawable.runcat);
    }

}