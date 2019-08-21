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

import java.util.ArrayList;
import java.util.List;

public class FragmentStore extends Fragment {

    MedicineAdapter medicineAdapter;
    List<Medicine> medicineList;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.store_fragment, container, false);



        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.store_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(20);
        recyclerView.setDrawingCacheEnabled(true);
        recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);

        medicineList = new ArrayList<>();


        medicineList.add(
                new Medicine(
                        "Ace +",
                        "SQUARE",
                        "500 mg",
                        R.drawable.aceplus

                )
        );

        medicineList.add(
                new Medicine(
                        "Ace +",
                        "SQUARE",
                        "500 mg",
                        R.drawable.aceplus

                )
        );
        medicineList.add(
                new Medicine(
                        "Ace +",
                        "SQUARE",
                        "500 mg",
                        R.drawable.aceplus

                )
        );


        medicineList.add(
                new Medicine(
                        "Ace +",
                        "SQUARE",
                        "500 mg",
                        R.drawable.aceplus

                )
        );

        medicineList.add(
                new Medicine(
                        "Ace +",
                        "SQUARE",
                        "500 mg",
                        R.drawable.aceplus

                )
        );

        medicineList.add(
                new Medicine(
                        "Ace +",
                        "SQUARE",
                        "500 mg",
                        R.drawable.aceplus

                )
        );

        MedicineAdapter adapter = new MedicineAdapter(getContext(),medicineList);
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());






        return rootView;
    }
}
