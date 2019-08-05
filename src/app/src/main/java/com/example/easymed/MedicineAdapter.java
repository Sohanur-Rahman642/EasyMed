package com.example.easymed;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MedicineAdapter extends  RecyclerView.Adapter<MedicineAdapter.MedicineViewHolder> {
    {

    }

    @NonNull
    @Override
    public MedicineViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MedicineViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public class MedicineViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView tvMedcicineName;
        private TextView tvMediBrandName;
        private TextView tvMediPower;
        private ImageView mediImage;
        private Button quickViewButton;
        private Button addToCartButton;

        public MedicineViewHolder(View itemView) {
            super(itemView);

            tvMedcicineName = (TextView) itemView.findViewById(R.id.text_name);
            tvMediBrandName = (TextView) itemView.findViewById(R.id.text_brand_name);
            tvMediPower = (TextView) itemView.findViewById(R.id.text_power);
            mediImage = (ImageView) itemView.findViewById(R.id.store_image);
            quickViewButton = (Button) itemView.findViewById(R.id.quick_view_btn);
            addToCartButton = (Button) itemView.findViewById(R.id.add_to_cart_btn);
            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {

        }
    }
}