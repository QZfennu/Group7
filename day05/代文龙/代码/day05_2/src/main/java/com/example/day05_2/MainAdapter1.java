package com.example.day05_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

class MainAdapter1 extends RecyclerView.Adapter {
    private ArrayList<Rv1Bean> list1;
    private Context context;

    public MainAdapter1(ArrayList<Rv1Bean> list1, Context context) {
        this.list1 = list1;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_rv1, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder view = (ViewHolder) holder;
        Rv1Bean rv1Bean = list1.get(position);
        Glide.with(context).load(rv1Bean.getImage()).into(view.iv_rv1);
        view.tv_rv1.setText(rv1Bean.getName());
    }

    @Override
    public int getItemCount() {
        return list1.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView iv_rv1;
        public TextView tv_rv1;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv_rv1 = (ImageView) rootView.findViewById(R.id.iv_rv1);
            this.tv_rv1 = (TextView) rootView.findViewById(R.id.tv_rv1);
        }

    }
}
