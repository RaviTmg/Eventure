package com.example.rawv.eventure.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.rawv.eventure.R;

import java.util.ArrayList;
import java.util.List;


public class FragSight extends Fragment {

    private ImageView bookmark;
    private int bookmarked = 1;
    private int animat;

    RecyclerView recyclerView;
    int[] img = {R.drawable.phewa_lake, R.drawable.pagoda_world, R.drawable.devis_fall, R.drawable.sarangkot};
    String[] name = {"Phewa Lake", "World Peace Pagoda","Devi's Fall", "Sarangkot"};
    String[] star = {"5.0","4.7", "3.3", "5.0"};


    public List<MainObject> getObjectList(){
        List<MainObject> objectSightList = new ArrayList<>();
        for (int i = 0; i<img.length; i++) {
            objectSightList.add(new MainObject( name[i], img[i], star[i]));
        }
        return objectSightList;
    }

    public FragSight() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sight, container, false);
/*
        bookmark = (ImageView) view.findViewById(R.id.bookmark);

        bookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bookmarked % 2 == 1) {
                    animat = R.anim.scale_up;
                } else {
                    animat = R.anim.scale_down;
                }
                Animation bookmarkAnimation = AnimationUtils.loadAnimation(
                        getActivity().getApplicationContext(), animat);
                bookmarked++;
                bookmark.startAnimation(bookmarkAnimation);
            }
        });
        */
        recyclerView = (RecyclerView) view.findViewById(R.id.rv_sight);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager grd = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(grd);
        recyclerView.setAdapter(new AdvenRecyclerAdapter( getObjectList(), getActivity().getApplicationContext()));

        return view;

    }

}
