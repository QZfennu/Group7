package com.example.chuanzhi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NeibuAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<Integer> list;


    public NeibuAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_list_four_image, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        list = new ArrayList<>();
        list.add(R.drawable.one);
        list.add(R.drawable.one);
        list.add(R.drawable.one);
        list.add(R.drawable.one);
        list.add(R.drawable.one);
        ViewHolder view = (ViewHolder) holder;
        view.image_nei_list.setBackgroundResource(list.get(position));
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView image_nei_list;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.image_nei_list = (ImageView) rootView.findViewById(R.id.image_nei_list);
        }

    }
}
