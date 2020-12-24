package com.example.myapplication.Fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.Bean.HDBean;
import com.example.myapplication.R;

import java.util.List;

public class HDAdapter extends RecyclerView.Adapter<HDAdapter.ViewHolder> {
    private Context context;
    private List<HDBean.DataBean> list;


    public HDAdapter(Context context, List<HDBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_type, parent, false);
        return new ViewHolder(inflate);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HDBean.DataBean dataBean = list.get(position);
        Glide.with(context).load(dataBean.getCover()).into(holder.mIv);
        holder.mTv.setText(dataBean.getTitle());
        holder.mDzTv.setText(dataBean.getLocation());
        holder.mRqTv.setText(dataBean.getApplyCutOffTime());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
         ImageView mIv;
         TextView mTv;
         TextView mDzTv;
         TextView mRqTv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mIv = (ImageView) itemView.findViewById(R.id.iv);
            mTv = (TextView) itemView.findViewById(R.id.tv);
            mDzTv = (TextView) itemView.findViewById(R.id.tv_dz);
            mRqTv = (TextView) itemView.findViewById(R.id.tv_rq);
        }
    }
}
