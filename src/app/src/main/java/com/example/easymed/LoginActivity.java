package com.example.easymed;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public  class LoginActivity extends AppCompatActivity {

    private Button loginButton;
    private EditText loginEmail, loginPassword;
    private Button loginSignup;
    private ProgressDialog loadingBar;
    private FirebaseAuth mAuth;

    private static final int RC_SIGN_IN = 1;

    private static final String TAG = "LoginUser";



    public static String loginEmail1, loginPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginSignup = findViewById(R.id.signUpButton);
        loginEmail = findViewById(R.id.email_edit_text);
        loginPassword = findViewById(R.id.password_edit_text);
        loginButton = findViewById(R.id.loginButton);

        //login_forgot_pass=findViewById(R.id.login_forgot_pass);

        loadingBar = new ProgressDialog(this);

        mAuth = FirebaseAuth.getInstance();


        loginEmail1 = loginEmail.getText().toString().trim();
        loginPass = loginPassword.getText().toString().trim();


        loginSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SendUserToSignUpActivity();
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AllowingUserToLogin();
            }
        });

    }
        @Override
        protected void onStart(){
            super.onStart();

            FirebaseUser currentUser = mAuth.getCurrentUser();

            if (currentUser != null) {

                SendUserToHome();
            }
        }

        private void AllowingUserToLogin () {

            String email = loginEmail.getText().toString();
            String password = loginPassword.getText().toString();

            if (TextUtils.isEmpty(email)) {

                Toast.makeText(this, "Please enter your email", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(password)) {

                Toast.makeText(this, "Please enter your password", Toast.LENGTH_SHORT).show();
            } else {

                loadingBar.setTitle("Login");
                loadingBar.setMessage("Please wait until we are logging into your account...");
                loadingBar.setCanceledOnTouchOutside(true);
                loadingBar.show();


                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {

                            SendUserToHome();

                            loadingBar.dismiss();
                        } else {

                            String message = task.getException().getMessage();
                            Toast.makeText(LoginActivity.this, "Error : " + message, Toast.LENGTH_SHORT).show();
                            loadingBar.dismiss();
                        }
                    }
                });
            }
        }


        private void SendUserToHome () {

            Intent i = new Intent(LoginActivity.this, MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
            finish();
        }


        private void SendUserToSignUpActivity () {

            Intent registerIntent = new Intent(LoginActivity.this, SignUpActivity.class);
            startActivity(registerIntent);
        }
    }


