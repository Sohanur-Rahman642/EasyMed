package com.example.easymed;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * The type Sign up activity.
 * Here an user can create an account if one doesn't have any
 * To create an account an user must provide name, valid email, phone number, password, address, gender and age
 * Call FirebaseAuth for Authentication
 */
public class SignUpActivity extends AppCompatActivity {

    private EditText registerName, registerEmailid,  registerPhone, registerPass, registerAddress, registerGender, registerAge;
    private Button createButton;
    private FirebaseAuth mAuth;
    private ProgressDialog loadingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        loadingBar = new ProgressDialog(this);

        mAuth =FirebaseAuth.getInstance();

        registerName=findViewById(R.id.firstname_edit_text1);
        registerEmailid=findViewById(R.id.email_edit_text2);
        registerPass=findViewById(R.id.password_edit_text5);
        registerPhone=findViewById(R.id.phone_edit_text2);
        registerAddress=findViewById(R.id.address_edit_text2);
        registerGender=findViewById(R.id.gender_edit_text2);
        registerAge=findViewById(R.id.age_edit_text2);
        createButton=findViewById(R.id.caButton);

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CreateNewAccount();
            }
        });

    }

    /**
     * The type onStart method.
     *Check if there anyone logged in with same email/user
     *
     */

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser currentUser= mAuth.getCurrentUser();

        if(currentUser!=null){

            SendUserToHome();
        }
    }


    /**
     * The type Create New Account method.
     * This is the main method where it takes input from the user
     * Inputs are String type (Datatype)
     * In here, checks user gives inputs for every section or not
     * Shw massages if needed
     */


    private void CreateNewAccount() {

        String email= registerEmailid.getText().toString();
        String password= registerPass.getText().toString();

        String name= registerName.getText().toString();
        String phone= registerPhone.getText().toString();
        String address= registerAddress.getText().toString();
        String gender = registerGender.getText().toString();
        String age = registerAge.getText().toString();


        if(TextUtils.isEmpty(email)){

            Toast.makeText(this, "Please Enter Your Email", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(name)){

            Toast.makeText(this, "Please Enter Your Name", Toast.LENGTH_SHORT).show();
        }
       else if(TextUtils.isEmpty(address)){

            Toast.makeText(this, "Please Enter Your Address", Toast.LENGTH_SHORT).show();
        }

       else if(TextUtils.isEmpty(phone)){

            Toast.makeText(this, "Please Enter Your Phone number", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(password)){

            Toast.makeText(this, "Please Enter Your Password", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(gender)){

            Toast.makeText(this, "Please Enter Your Gender", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(age)){

            Toast.makeText(this, "Please Enter Your Age", Toast.LENGTH_SHORT).show();
        }

        else{

            loadingBar.setTitle("Creating a new account");
            loadingBar.setMessage("Please wait until we are creating new account...");
            loadingBar.show();
            loadingBar.setCanceledOnTouchOutside(true);

            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if(task.isSuccessful()){



                        SendUserToHome();

                        Toast.makeText(SignUpActivity.this, "Account is created successfully! ", Toast.LENGTH_SHORT).show();
                        loadingBar.dismiss();
                    }
                    else {

                        String message = task.getException().getMessage();
                        Toast.makeText(SignUpActivity.this, "Error: " + message, Toast.LENGTH_SHORT).show();
                        loadingBar.dismiss();
                    }
                }
            });
        }

    }


    /**
     * The type Send home method.
     * Here after an successfully creating an account, it send user to the MainActivity/ Home Page
     *
     */

    private void SendUserToHome() {

        Intent intent = new Intent(SignUpActivity.this, MainActivity.class);   //it was MytoursForGuide.class before
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}