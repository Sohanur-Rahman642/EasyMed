package com.example.easymed;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class FragmentStore extends Fragment {

    MedicineAdapter medicineAdapter;
    List<Medicine> medicineList;
    RecyclerView recyclerView;
    DatabaseReference medicineRef;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.store_fragment, container, false);

        medicineRef = FirebaseDatabase.getInstance().getReference().child("Medicines");

        recyclerView = (RecyclerView) rootView.findViewById(R.id.store_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(20);
        recyclerView.setDrawingCacheEnabled(true);
        recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);




        recyclerView.setItemAnimator(new DefaultItemAnimator());

        DisplayMedicineCards();




        return rootView;
    }


    private void DisplayMedicineCards() {



        FirebaseRecyclerOptions<Medicine> options =
                new FirebaseRecyclerOptions.Builder<Medicine>()
                        .setQuery(medicineRef, Medicine.class)
                        .build();




    }




}
