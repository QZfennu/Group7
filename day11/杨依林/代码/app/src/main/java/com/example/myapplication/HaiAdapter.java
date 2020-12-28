package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class HaiAdapter extends RecyclerView.Adapter<HaiAdapter.ViewHolder> {
    private Context context;
    private List<Integer> list;

    public HaiAdapter(Context context, List<Integer> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public HaiAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_hai, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull HaiAdapter.ViewHolder holder, int position) {
        Integer integer = list.get(position);
        Glide.with(context).load(integer).into(holder.iv_hai);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_hai;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_hai=itemView.findViewById(R.id.iv_hai);
        }
    }
}
