package com.example.android_shixun_mvp_1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.android_shixun_mvp_1.R;
import com.example.android_shixun_mvp_1.bean.BannerBean;
import com.example.android_shixun_mvp_1.bean.ItemBean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

public class RlvAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<ItemBean.DataBean.DatasBean> itemBeans;
    private ArrayList<BannerBean.DataBean> bannBean;
    private int ONE = 1;
    private int TWO = 2;

    public RlvAdapter(Context context, ArrayList<ItemBean.DataBean.DatasBean> itemBeans, ArrayList<BannerBean.DataBean> bannBean) {
        this.context = context;
        this.itemBeans = itemBeans;
        this.bannBean = bannBean;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == ONE) {
            View one = LayoutInflater.from(context).inflate(R.layout.layout_one, parent, false);
            return new OneHolder(one);
        }
        View two = LayoutInflater.from(context).inflate(R.layout.layout_two, parent, false);
        return new TwoHolder(two);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        if (viewType == ONE){
           OneHolder oneHolder = (OneHolder) holder;
            oneHolder.R_banner.setImages(bannBean).setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    BannerBean.DataBean dataBean = (BannerBean.DataBean) path;
                    Glide.with(context).load(dataBean.getImagePath()).into(imageView);
                }
            }).start();
        }
        if (viewType == TWO){
            TwoHolder twoHolder = (TwoHolder) holder;
            TwoAdapter adapter = new TwoAdapter(context, itemBeans);
            itemBeans.addAll(itemBeans);
            twoHolder.two_rlv.setLayoutManager(new LinearLayoutManager(context,RecyclerView.HORIZONTAL,false));
            twoHolder.two_rlv.setAdapter(adapter);
        }
    }

    @Override
    public int getItemCount() {
        return itemBeans.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0){
            return ONE;
        }
            return TWO;

    }

    public static
    class OneHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public Banner R_banner;

        public OneHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.R_banner = (Banner) rootView.findViewById(R.id.R_banner);
        }

    }

    public static
    class TwoHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public RelativeLayout two_rel;
        public RecyclerView two_rlv;

        public TwoHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.two_rel = (RelativeLayout) rootView.findViewById(R.id.two_rel);
            this.two_rlv = (RecyclerView) rootView.findViewById(R.id.two_rlv);
        }

    }
}
