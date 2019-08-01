package com.example.loginactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText Email;
    private EditText Password;
    private Button Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Email = (EditText)findViewById(R.id.txtEmail);
        Password = (EditText)findViewById(R.id.txtPassword);
        Login = (Button)findViewById(R.id.btnLogin);




    }


//    private  void validate(String userEmail, String userPassword){
//        if ((userEmail == "m.tahmeed195715@gmail.com") && (userPassword == "123456789"))
//            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
//    }
}
