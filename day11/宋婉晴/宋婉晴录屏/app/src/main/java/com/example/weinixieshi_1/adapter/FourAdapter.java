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

public class FourAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<Integer> list;

    public FourAdapter(Context context, ArrayList<Integer> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_four, parent, false);
        return new Four1Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Four1Holder four1Holder = (Four1Holder) holder;
        four1Holder.four_img.setImageResource(list.get(0));
    }

    @Override
    public int getItemCount() {

        return list.size();
    }

    public static
    class Four1Holder extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView four_img;

        public Four1Holder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.four_img = (ImageView) rootView.findViewById(R.id.four_img);
        }

    }
}
