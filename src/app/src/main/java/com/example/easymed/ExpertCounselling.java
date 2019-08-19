package com.example.easymed;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ExpertCounselling extends AppCompatActivity {
    Button book_an_appointment_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expert_counselling);


        book_an_appointment_btn = (Button) findViewById(R.id.baap_btn);


        book_an_appointment_btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {



                Intent intent = new Intent(ExpertCounselling.this,SubmitDetailsForAppointment.class);
                startActivity(intent);
            }
        });
    }
}
