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
import com.example.myapplication.Bean.RDBean;
import com.example.myapplication.R;

import java.util.List;

public class RDAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<RDBean.DataBean.ListBean> list;



    public RDAdapter(Context context, List<RDBean.DataBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    private static final int IMTE_A = 0;
    private static final int IMTE_B = 1;
    private static final int IMTE_C = 2;

    @Override
    public int getItemViewType(int position) {
        return position % 3;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == IMTE_A) {
            View view1 = LayoutInflater.from(context).inflate(R.layout.item_rv1, parent, false);
            return new ViewHolder1(view1);
        } else if (viewType == IMTE_B) {
            View view2 = LayoutInflater.from(context).inflate(R.layout.item_rv2, parent, false);
            return new ViewHolder2(view2);
        } else {
            View view3 = LayoutInflater.from(context).inflate(R.layout.item_rv3, parent, false);
            return new ViewHolder3(view3);
        }
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        RDBean.DataBean.ListBean listBean = list.get(position);
        int itemViewType = getItemViewType(position);
        switch (itemViewType){
            case IMTE_A:
                ViewHolder1 viewHolder1= (ViewHolder1) holder;
                viewHolder1.mTv.setText(listBean.getTitle());
                Glide.with(context).load(listBean.getFilePathList().get(0)).into(viewHolder1.mIv1);
                Glide.with(context).load(listBean.getFilePathList().get(1)).into(viewHolder1.mIv2);
                Glide.with(context).load(listBean.getFilePathList().get(2)).into(viewHolder1.mIv3);
                break;
            case IMTE_B:
                ViewHolder2 viewHolder2= (ViewHolder2) holder;
                viewHolder2.mTv.setText(listBean.getTitle());
                Glide.with(context).load(listBean.getFilePathList().get(0)).into(viewHolder2.mIv);
                break;
            case IMTE_C:
                ViewHolder3 viewHolder3= (ViewHolder3) holder;
                viewHolder3.mTv.setText(listBean.getTitle());
                break;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class ViewHolder1 extends RecyclerView.ViewHolder {
        TextView mTv;
        ImageView mIv1;
        ImageView mIv2;
        ImageView mIv3;

        public ViewHolder1(View view1) {
            super(view1);
            mTv = (TextView) itemView.findViewById(R.id.tv);
            mIv1 = (ImageView) itemView.findViewById(R.id.iv1);
            mIv2 = (ImageView) itemView.findViewById(R.id.iv2);
            mIv3 = (ImageView) itemView.findViewById(R.id.iv3);
        }
    }

    private class ViewHolder2 extends RecyclerView.ViewHolder {
        TextView mTv;
        ImageView mIv;

        public ViewHolder2(View view2) {
            super(view2);
            mTv = (TextView) itemView.findViewById(R.id.tv);
            mIv = (ImageView) itemView.findViewById(R.id.iv);
        }
    }

    private class ViewHolder3 extends RecyclerView.ViewHolder {
         TextView mTv;
        public ViewHolder3(View view3) {
            super(view3);
            mTv = (TextView) itemView.findViewById(R.id.tv);
        }
    }
}
