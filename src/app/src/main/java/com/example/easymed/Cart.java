package com.example.easymed;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Cart extends AppCompatActivity {

    TextView tvCartItem;

    private  String medName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        tvCartItem = (TextView) findViewById(R.id.cart_item_text_name);

        medName = getIntent().getStringExtra("mName");


        getMedicineDetails(medName);


    }

    private void getMedicineDetails(String medName) {

        DatabaseReference medRef = FirebaseDatabase.getInstance()
                .getReference().child("Medicines");

        medRef.child(medName).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                {
                    Medicine medicine = dataSnapshot.getValue(Medicine.class);
                    tvCartItem.setText(medicine.getMedicineName());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
