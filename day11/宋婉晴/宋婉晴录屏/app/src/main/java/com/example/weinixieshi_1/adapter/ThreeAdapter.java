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

public class ThreeAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<Integer> list;

    public ThreeAdapter(Context context, ArrayList<Integer> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_three, parent, false);
        return new Three1Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Three1Holder three1Holder = (Three1Holder) holder;
        three1Holder.three_img.setImageResource(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class Three1Holder extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView three_img;

        public Three1Holder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.three_img = (ImageView) rootView.findViewById(R.id.three_img);
        }

    }
}
