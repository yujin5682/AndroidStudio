package com.example.homework7;

public class Dog extends Animal{

    Dog(String name, int age, String phone) {
        super(name, age, phone);
    }



    public void standup(){
        this.imageView.setImageResource(R.drawable.standupdog);
    }
    public void sitdown(){
        this.imageView.setImageResource(R.drawable.sitdowndog);
    }
    public void run(){
        this.imageView.setImageResource(R.drawable.rundog);
    }

}