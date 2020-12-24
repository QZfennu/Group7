package com.example.day07_zuoye.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.day07_zuoye.R;
import com.example.day07_zuoye.bean.PopularBean;

import java.util.ArrayList;
import java.util.List;

public class HomeFragRvAdapter extends RecyclerView.Adapter {
    public ArrayList<PopularBean.DataDTO> list;
    private Context context;

    public HomeFragRvAdapter(ArrayList<PopularBean.DataDTO> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.popular_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder view = (ViewHolder) holder;
        PopularBean.DataDTO dataDTO = list.get(position);
        Glide.with(context).load(dataDTO.getCover()).into(view.iv_popular_item);
        view.tv_popular_item1.setText(dataDTO.getTitle());
        view.tv_popular_item2.setText(dataDTO.getLocation());
        view.tv_popular_item3.setText(dataDTO.getApplyCutOffTime()+"");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addData(List<PopularBean.DataDTO> data) {
        list.addAll(data);
        notifyDataSetChanged();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView iv_popular_item;
        public TextView tv_popular_item1;
        public TextView tv_popular_item2;
        public TextView tv_popular_item3;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv_popular_item = (ImageView) rootView.findViewById(R.id.iv_popular_item);
            this.tv_popular_item1 = (TextView) rootView.findViewById(R.id.tv_popular_item1);
            this.tv_popular_item2 = (TextView) rootView.findViewById(R.id.tv_popular_item2);
            this.tv_popular_item3 = (TextView) rootView.findViewById(R.id.tv_popular_item3);
        }

    }
}
