package com.example.easymed;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class SignUpActivity extends AppCompatActivity {

    Button caButton,alreadyCaButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        caButton = (Button) findViewById(R.id.caButton);
        alreadyCaButton = (Button) findViewById(R.id.alreadyCa_button);

    }
}
