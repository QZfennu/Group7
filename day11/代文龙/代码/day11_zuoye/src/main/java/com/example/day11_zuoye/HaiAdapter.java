package com.example.day11_zuoye;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

class HaiAdapter extends RecyclerView.Adapter {
    private ArrayList<HaiBean> list;
    private Context context;

    public HaiAdapter(ArrayList<HaiBean> haiBeans, Context context) {
        list = haiBeans;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_hai, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder view = (ViewHolder) holder;
        HaiBean haiBean = list.get(position);
        Glide.with(context).load(haiBean.getImage()).into(view.iv_hai);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView iv_hai;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv_hai = (ImageView) rootView.findViewById(R.id.iv_hai);
        }

    }
}
