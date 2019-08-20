package com.example.easymed;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class UpdateProfile extends AppCompatActivity {

    Button updateChanges, discardChanges;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        discardChanges = (Button) findViewById(R.id.discard_change_btn);


        discardChanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UpdateProfile.this,ProfileActivity.class);
                startActivity(intent);
            }
        });







    }
}
