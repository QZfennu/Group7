package com.example.weinixieshi_1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weinixieshi_1.R;


import java.util.ArrayList;

public class FiveAdapter extends RecyclerView.Adapter {

    private Context context;
    private ArrayList<Integer> list;

    public FiveAdapter(Context context, ArrayList<Integer> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_five, parent, false);
        return new Five1Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Five1Holder five1Holder = (Five1Holder) holder;
        five1Holder.five_img.setImageResource(list.get(1));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class Five1Holder extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView five_img;

        public Five1Holder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.five_img = (ImageView) rootView.findViewById(R.id.five_img);
        }

    }
}
