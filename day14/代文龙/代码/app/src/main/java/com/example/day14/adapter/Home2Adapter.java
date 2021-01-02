package com.example.day14.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.day14.R;
import com.example.day14.bean.Rv2Bean;

import java.util.ArrayList;

public class Home2Adapter extends RecyclerView.Adapter {
    private ArrayList<Rv2Bean> list;
    private Context context;

    public Home2Adapter(ArrayList<Rv2Bean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_home2, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder view = (ViewHolder) holder;
        Rv2Bean rv2Bean = list.get(position);
        Glide.with(context).load(rv2Bean.getImage1()).into(view.iv_home21);
        view.tv_home21.setText(rv2Bean.getTitle());
        view.tv_home22.setText(rv2Bean.getKe());
        view.tv_home23.setText(rv2Bean.getPice());
        view.tv_home24.setText(rv2Bean.getXue());
        view.tv_home25.setText(rv2Bean.getGou());
        Glide.with(context).load(rv2Bean.getIamge2()).into(view.iv_home22);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView iv_home21;
        public TextView tv_home21;
        public TextView tv_home22;
        public TextView tv_home23;
        public ImageView iv_home22;
        public TextView tv_home24;
        public TextView tv_home25;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv_home21 = (ImageView) rootView.findViewById(R.id.iv_home21);
            this.tv_home21 = (TextView) rootView.findViewById(R.id.tv_home21);
            this.tv_home22 = (TextView) rootView.findViewById(R.id.tv_home22);
            this.tv_home23 = (TextView) rootView.findViewById(R.id.tv_home23);
            this.iv_home22 = (ImageView) rootView.findViewById(R.id.iv_home22);
            this.tv_home24 = (TextView) rootView.findViewById(R.id.tv_home24);
            this.tv_home25 = (TextView) rootView.findViewById(R.id.tv_home25);
        }

    }
}
