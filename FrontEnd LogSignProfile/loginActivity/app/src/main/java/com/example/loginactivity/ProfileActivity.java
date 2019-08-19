package com.example.loginactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProfileActivity extends AppCompatActivity {

    Button g;
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);



        g=(Button)findViewById(R.id.bBack1);
        g.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent =new Intent(ProfileActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });


    }
}
