package com.example.rawv.eventure.Fragments;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rawv.eventure.Activity.SightInfoActivity;
import com.example.rawv.eventure.R;

import java.util.List;

/**
 * Created by RawV on 5/29/2016.
 */
public class AdvenRecyclerAdapter extends RecyclerView.Adapter<AdvenRecyclerAdapter.Holder> {
    List<MainObject> mainObjectList;
    Context context;
    private int bookmarked = 1;
    private int animat;

    public AdvenRecyclerAdapter(List<MainObject> mainObjectList, Context context) {
        this.mainObjectList = mainObjectList;
        this.context =context;
    }



    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.card_sight, parent, false);
        // create ViewHolder instance
        Holder holder = new Holder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(final Holder holder, final int position) {
        holder.imageView1.setImageResource(mainObjectList.get(position).img);
        holder.mname.setText(mainObjectList.get(position).name);
        holder.imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SightInfoActivity.class);
                intent.putExtra("NAME_OF_PLACE", mainObjectList.get(position).name);
                intent.putExtra("IMAGE_OF_PLACE", mainObjectList.get(position).img);
                v.getContext().startActivity(intent);

            }
        });
        holder.imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bookmarked % 2 == 1) {
                    animat = R.anim.scale_up;
                } else {
                    animat = R.anim.scale_down;
                }
                Animation bookmarkAnimation = AnimationUtils.loadAnimation(
                        context, animat);
                bookmarked++;
                holder.imageView2.startAnimation(bookmarkAnimation);
            }
        });
        holder.mrating.setText(mainObjectList.get(position).star);
    }


    @Override
    public int getItemCount() {
        return mainObjectList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView imageView1, imageView2;
        TextView mname, mrating;

        public Holder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.cv_sight);
            imageView1 = (ImageView) itemView.findViewById(R.id.img_sight);
            imageView2 = (ImageView) itemView.findViewById(R.id.bookmark);
            mname = (TextView) itemView.findViewById(R.id.txt_name);
            mrating = (TextView) itemView.findViewById(R.id.rating);
        }
    }
}
