package com.example.easymed;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MedicineAdapter extends  RecyclerView.Adapter<MedicineAdapter.MedicineViewHolder> {


    public Context context;
    List<Medicine> medicineList;

    public MedicineAdapter(Context context, List<Medicine> medicineList) {
        this.context = context;
        this.medicineList = medicineList;
    }


        @NonNull
        @Override
        public MedicineViewHolder onCreateViewHolder (@NonNull ViewGroup parent,int viewType){
            LayoutInflater inflater = LayoutInflater.from(context);
            View view = inflater.inflate(R.layout.store_item,null);


            return  new MedicineViewHolder(view);
    }

        @Override
        public void onBindViewHolder (@NonNull MedicineViewHolder medicineViewHolder,int position){

            /*Medicine medicine = medicineList.get(position);
            medicineViewHolder.tvMedcicineName.setText(medicine.getMedicineName());
            medicineViewHolder.tvMediBrandName.setText(medicine.getMedicineBrandName());
            medicineViewHolder.tvMediPower.setText(medicine.getMedicinePower());
            medicineViewHolder.mediImage.setImageDrawable(context.getResources()
                    .getDrawable(medicine.getMediImage(),null));*/

        }

        @Override
        public int getItemCount () {
            return medicineList.size();
    }


        public static class MedicineViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
                     TextView tvMedcicineName;
                   TextView tvMediBrandName;
                    TextView tvMediPower;
                 ImageView mediImage;
                 Button quickViewButton;
                     Button addToCartButton;

            public MedicineViewHolder(View itemView) {
                super(itemView);

                tvMedcicineName = (TextView) itemView.findViewById(R.id.text_name);
                tvMediBrandName = (TextView) itemView.findViewById(R.id.text_brand_name);
                tvMediPower = (TextView) itemView.findViewById(R.id.text_power);
                mediImage = (ImageView) itemView.findViewById(R.id.store_image);

                addToCartButton = (Button) itemView.findViewById(R.id.add_to_cart_btn);
                itemView.setOnClickListener(this);


            }

            @Override
            public void onClick(View v) {

            }
        }
    }