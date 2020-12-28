package com.example.day11_zuoye;

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

class GuoAdapter extends RecyclerView.Adapter {
    private ArrayList<GuoBean> guolist;
    private Context context;

    public GuoAdapter(ArrayList<GuoBean> guolist, Context context) {
        this.guolist = guolist;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_guo, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder view = (ViewHolder) holder;
        GuoBean guoBean = guolist.get(position);
        Glide.with(context).load(guoBean.getImage()).into(view.iv_guo);
        view.tv_guo.setText(guoBean.getAddress());
    }

    @Override
    public int getItemCount() {
        return guolist.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView iv_guo;
        public TextView tv_guo;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv_guo = (ImageView) rootView.findViewById(R.id.iv_guo);
            this.tv_guo = (TextView) rootView.findViewById(R.id.tv_guo);
        }

    }
}
