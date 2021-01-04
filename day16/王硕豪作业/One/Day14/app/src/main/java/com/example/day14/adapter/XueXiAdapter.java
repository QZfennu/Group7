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
import com.example.day14.bean.XueXiBean;

import java.util.ArrayList;

public class XueXiAdapter extends RecyclerView.Adapter {
    private ArrayList<XueXiBean> list;
    private Context context;

    public XueXiAdapter(ArrayList<XueXiBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_xuexi_rv, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder view = (ViewHolder) holder;
        XueXiBean xueXiBean = list.get(position);
        Glide.with(context).load(xueXiBean.getImage()).into(view.iv_xuexi1);
        view.tv_xuexi.setText(xueXiBean.getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView iv_xuexi1;
        public TextView tv_xuexi;
        public ImageView iv_xuexi2;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv_xuexi1 = (ImageView) rootView.findViewById(R.id.iv_xuexi1);
            this.tv_xuexi = (TextView) rootView.findViewById(R.id.tv_xuexi);
            this.iv_xuexi2 = (ImageView) rootView.findViewById(R.id.iv_xuexi2);
        }

    }
}
