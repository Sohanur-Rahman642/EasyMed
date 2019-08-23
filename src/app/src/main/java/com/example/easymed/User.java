package com.example.easymed;

public class User {
    public String name, email, phone, address, gender, age;


    public User(){

    }
    public User(String name, String email, String phone, String address, String gender, String age) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.gender = gender;
        this.age = age;
    }
}
