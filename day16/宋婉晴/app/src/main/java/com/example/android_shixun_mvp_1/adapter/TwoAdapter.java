package com.example.android_shixun_mvp_1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.android_shixun_mvp_1.R;
import com.example.android_shixun_mvp_1.bean.ItemBean;


import java.util.ArrayList;

public class TwoAdapter extends RecyclerView.Adapter{
    private Context context;
    private ArrayList<ItemBean.DataBean.DatasBean> itemBean;

    public TwoAdapter(Context context, ArrayList<ItemBean.DataBean.DatasBean> itemBean) {
        this.context = context;
        this.itemBean = itemBean;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View three = LayoutInflater.from(context).inflate(R.layout.layout_three, parent, false);
        return new ThreeHolder(three);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ThreeHolder threeHolder = (ThreeHolder) holder;
        Glide.with(context).load(itemBean.get(position).getEnvelopePic()).into(threeHolder.three_img);
        threeHolder.three_text.setText(itemBean.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return itemBean.size();
    }
    public static
    class ThreeHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView three_img;
        public TextView three_text;

        public ThreeHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.three_img = (ImageView) rootView.findViewById(R.id.three_img);
            this.three_text = (TextView) rootView.findViewById(R.id.three_text);
        }

    }
}
