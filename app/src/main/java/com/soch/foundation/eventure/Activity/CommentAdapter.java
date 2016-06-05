package com.soch.foundation.eventure.Activity;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.soch.foundation.eventure.R;

import java.util.List;

import me.grantland.widget.AutofitTextView;

/**
 * Created by RawV on 6/4/2016.
 */
public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.Holder> {
    List<CommentObject> mainObjectList;
    Context context;
    public CommentAdapter(List<CommentObject> mainObjectList, Context context) {
        this.mainObjectList = mainObjectList;
        this.context =context;
    }
    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.card_comment, parent, false);
        // create ViewHolder instance
        Holder holder = new Holder(v);
        return holder;    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.date.setText(mainObjectList.get(position).date);
        holder.userName.setText(mainObjectList.get(position).userName);
        holder.tip.setText(mainObjectList.get(position).comment);

    }

    @Override
    public int getItemCount() {
        return mainObjectList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView date,  userName;
        AutofitTextView tip;
        public Holder(View itemView) {
            super(itemView);
            userName = (TextView) itemView.findViewById(R.id.user_name);
            tip = (AutofitTextView) itemView.findViewById(R.id.tip_content);
            date = (TextView) itemView.findViewById(R.id.date_submit);
        }
    }
}
