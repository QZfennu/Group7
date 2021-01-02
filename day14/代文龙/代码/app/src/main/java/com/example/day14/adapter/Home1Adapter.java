package com.example.day14.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.day14.R;

import java.util.ArrayList;

public class Home1Adapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<Integer> list;

    public Home1Adapter(Context context, ArrayList<Integer> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_home1, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder view = (ViewHolder) holder;
        Integer integer = list.get(position);
        Glide.with(context).load(integer).into(view.iv_home1);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView iv_home1;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv_home1 = (ImageView) rootView.findViewById(R.id.iv_home1);
        }

    }
}
