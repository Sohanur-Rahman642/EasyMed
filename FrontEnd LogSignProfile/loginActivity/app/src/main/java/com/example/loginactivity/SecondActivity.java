package com.example.loginactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class SecondActivity extends AppCompatActivity {

    Button i;
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ImageView i = (ImageView) findViewById(R.id.bProfile);

        i.setOnClickListener(new View.OnClickListener() {

            /**
             * Called when a view has been clicked.
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(SecondActivity.this,ProfileActivity.class);
                startActivity(intent);


            }




        });




    }
}
