package com.example.day15.mvp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.day15.R;
import com.example.day15.bean.HomeRemenBean;

import java.util.List;

public class HomeReMenAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<HomeRemenBean.DataDTO> data;

    public HomeReMenAdapter(Context context, List<HomeRemenBean.DataDTO> data) {

        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_fragment_remen, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HomeRemenBean.DataDTO dataDTO = data.get(position);
        ViewHolder view = (ViewHolder) holder;
        Glide.with(context).load(dataDTO.getImageUrl()).into(view.iv_remen);
        view.tv_remen1.setText(dataDTO.getName());
        view.tv_remen2.setText(dataDTO.getAttentionNum()+"人参加");
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView iv_remen;
        public TextView tv_remen1;
        public TextView tv_remen2;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv_remen = (ImageView) rootView.findViewById(R.id.iv_remen);
            this.tv_remen1 = (TextView) rootView.findViewById(R.id.tv_remen1);
            this.tv_remen2 = (TextView) rootView.findViewById(R.id.tv_remen2);
        }

    }
}
