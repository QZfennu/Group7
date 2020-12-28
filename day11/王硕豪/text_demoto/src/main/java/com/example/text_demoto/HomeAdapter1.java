package com.example.text_demoto;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class HomeAdapter1 extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<Bean> list;

    public HomeAdapter1(Context context, ArrayList<Bean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item3_1, parent, false);
        return new ViewHolder1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder1 viewHolder1= (ViewHolder1) holder;
        Glide.with(context).load(list.get(position).getImg()).into(viewHolder1.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder1 extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView img;

        public ViewHolder1(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.img = (ImageView) rootView.findViewById(R.id.img);
        }

    }
}
