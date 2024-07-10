package com.example.homework7;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class Animal {

    String name;
    int age;
    String phone;
    ImageView imageView;

    EditText inputName;
    EditText inputAge;
    EditText inputPhone;

    Animal(String name, int age, String phone){
        this.name = name;
        this.age = age;
        this.phone = phone;
    }

    public void createAnimal(EditText inputName, EditText age, EditText phone) {
        this.name = inputName.getText().toString();
        String ageStr = inputAge.getText().toString();
        this.age = Integer.parseInt(ageStr);
        this.phone = inputPhone.getText().toString();
    }

    void standup(){

    }

    void sitdown(){

    }

    void run(){

    }

}