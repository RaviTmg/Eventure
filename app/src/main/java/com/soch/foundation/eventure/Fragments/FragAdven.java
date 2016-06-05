package com.soch.foundation.eventure.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.soch.foundation.eventure.R;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragAdven extends Fragment {
    RecyclerView recyclerView;
    int[] img = {R.drawable.pagoda_world, R.drawable.devis_fall, R.drawable.sarangkot};
    String[] name = {"Wrold Peace Pagoda", "Devi's Fall", "Sarangkot"};
    String[] star = {"5.0", "4.7", "3.3", "5.0"};

    public List<MainObject> getObjectList() {
        List<MainObject> objectAdvenList = new ArrayList<>();
        for (int i = 0; i < img.length; i++) {
            objectAdvenList.add(new MainObject(name[i], img[i], star[i]));
        }
        return objectAdvenList;
    }

    public FragAdven() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_adven, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.rv_adven);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager grd = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(grd);
        recyclerView.setAdapter(new AdvenRecyclerAdapter(getObjectList(), getActivity().getApplicationContext()));
        return view;
    }

}
