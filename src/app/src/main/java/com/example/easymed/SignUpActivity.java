package com.example.easymed;


import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


import android.widget.EditText;

import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener{

    Button crButton, alreadyCrButton;
    private EditText userName, userEmail, userPassword, phoneNumber, userAddress, userGender, userAge;

    private ProgressBar progressBar;

    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);



        progressBar = new ProgressBar(this);



        crButton = (Button) findViewById(R.id.caButton);
        alreadyCrButton = (Button) findViewById(R.id.alreadyCa_button);

        userName = (EditText) findViewById(R.id.firstname_input_field);
        userEmail = (EditText) findViewById(R.id.email_input_field);
        userPassword = (EditText) findViewById(R.id.password_input_field);
        phoneNumber = (EditText) findViewById(R.id.phone_input_field);
        userAddress = (EditText) findViewById(R.id.address_input_field);
        userGender = (EditText) findViewById(R.id.gender_input_field);
        userAge = (EditText) findViewById(R.id.age_input_field);

        firebaseAuth = FirebaseAuth.getInstance();

//        findViewById(R.id.caButton).setOnClickListener(this);
//
//        findViewById(R.id.alreadyCa_button).setOnClickListener(this);


        crButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        alreadyCrButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        if(firebaseAuth.getCurrentUser()!=null){

        }
    }

    private void createAccount(){
        final String name = userName.getText().toString().trim();
        final String email = userEmail.getText().toString().trim();
        String password = userPassword.getText().toString().trim();
        final String phone = phoneNumber.getText().toString().trim();
        final String address = userAddress.getText().toString().trim();
        final String gender = userGender.getText().toString().trim();
        final String age = userAge.getText().toString().trim();


        if(name.isEmpty()){
            userName.setError("Name required");
            userName.requestFocus();
            return;
        }


        if(email.isEmpty()){
            userEmail.setError("Email required");
            userEmail.requestFocus();
            return;
        }


        if(password.isEmpty()){
            userPassword.setError("Password required");
            userPassword.requestFocus();
            return;
        }


        if(phone.isEmpty()){
            phoneNumber.setError("Phone number required");
            phoneNumber.requestFocus();
            return;
        }


        if(address.isEmpty()){
            userAddress.setError("Address required");
            userAddress.requestFocus();
            return;
        }


        if(gender.isEmpty()){
            userGender.setError("Gender required");
            userGender.requestFocus();
            return;
        }


        if(age.isEmpty()){
            userAge.setError("Age required");
            userAge.requestFocus();
            return;
        }


        progressBar.setVisibility(View.VISIBLE);

        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {


                        if(task.isSuccessful()){
                            //we will store the additional fields in firebase database
                            User user = new User(
                                    name,
                                    email,
                                    phone,
                                    address,
                                    gender,
                                    age
                            );

                            FirebaseDatabase.getInstance().getReference("Users")
                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                            .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {

                                    progressBar.setVisibility(View.GONE);
                                    if(task.isSuccessful()){
                                        Toast.makeText(SignUpActivity.this, "Successfully Signing Up", Toast.LENGTH_SHORT).show();
                                    }
                                    else
                                    {
                                        Toast.makeText(SignUpActivity.this, "Unsuccessful, Please try again ", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                        }
                        else
                        {
                            Toast.makeText(SignUpActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });





    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.caButton:
                createAccount();
        }

    }
}
