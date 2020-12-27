package com.example.day_demo09.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.day_demo09.R;
import com.example.day_demo09.bean.ItemBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BeanAdapter extends RecyclerView.Adapter {

    private Context context;
    private ArrayList<ItemBean.DataBean.ListBean> list;

    public BeanAdapter(Context context, ArrayList<ItemBean.DataBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_bean, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        ItemBean.DataBean.ListBean listBean = list.get(position);
        viewHolder.tvTitle.setText(listBean.getTitle());

        List<ItemBean.DataBean.ListBean.FilePathListBean> filePathList = listBean.getFilePathList();
        ArrayList<String> img = new ArrayList<>();
        for (ItemBean.DataBean.ListBean.FilePathListBean filePathListBean : filePathList) {
            img.add(filePathListBean.getFilePath());
        }

//        Glide.with(context).load(img).into(viewHolder.ivImg);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static
    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_img)
        ImageView ivImg;
        @BindView(R.id.tv_title)
        TextView tvTitle;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
