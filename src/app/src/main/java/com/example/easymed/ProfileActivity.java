package com.example.easymed;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity {

    Button updateButton, signOut;
    private TextView viewName, viewEmail, viewPhone, viewAddress;

    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(this, LoginActivity.class));;
        }

        FirebaseUser user = firebaseAuth.getCurrentUser();

        viewName = (TextView) findViewById(R.id.pr_user_name);
        viewName.setText("Welcome "+user.getDisplayName());

        viewEmail = (TextView) findViewById(R.id.pr_email_id);
        viewPhone = (TextView) findViewById(R.id.pr_contact_number);
        viewAddress = (TextView) findViewById(R.id.pr_ad_address);


        updateButton = (Button) findViewById(R.id.update_btn);
        signOut = (Button) findViewById(R.id.sign_out_btn);

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this,UpdateProfile.class);
                startActivity(intent);
            }
        });


        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });




    }
}
