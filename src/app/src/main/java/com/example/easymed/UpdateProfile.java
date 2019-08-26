package com.example.easymed;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


/**
 * The type Update profile.
 * Users can update their information
 * like name, address, phone number etc.
 */
public class UpdateProfile extends AppCompatActivity {

    /**
     * The Update changes.
     */
    Button updateChanges, /**
     * The Discard changes.
     */
    discardChanges;


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
