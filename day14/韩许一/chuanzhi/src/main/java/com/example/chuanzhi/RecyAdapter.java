package com.example.chuanzhi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

public class RecyAdapter extends RecyclerView.Adapter {

    private Context context;

    public RecyAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 1) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.layout_list_banner_one, parent, false);
            return new ViewHolder_banner_one(inflate);
        }
        if (viewType == 2) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.layout_list_two, parent, false);
            return new ViewHolder_list_two(inflate);
        }
        if (viewType == 3) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.layout_list_three, parent, false);
            return new ViewHolder_three(inflate);
        }
        if (viewType == 4) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.layout_list_four, parent, false);
            return new ViewHolder_list_four(inflate);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);
        if (type == 1) {
            ViewHolder_banner_one one = (ViewHolder_banner_one) holder;
            final ArrayList<Integer> images = new ArrayList<>();
            images.add(R.drawable.dayi);
            images.add(R.drawable.dayi);
            images.add(R.drawable.dayi);
            one.banner_list_one.setImages(images).setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {

                    Glide.with(context).load(path).into(imageView);
                }
            }).start();
        }
        if (type == 2) {
            ViewHolder_list_two two = (ViewHolder_list_two) holder;
        }
        if (type == 3) {
            ViewHolder_three three = (ViewHolder_three) holder;
        }
        if (type==4){
            ViewHolder_list_four four = (ViewHolder_list_four) holder;
            four.recy_nei.setLayoutManager(new LinearLayoutManager(context));
            four.recy_nei.setAdapter(new NeibuAdapter(context));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 1;
        }
        if (position == 1) {
            return 2;
        }
        if (position == 2) {
            return 3;
        }
        if (position==3){
            return 4;
        }
        return 0;
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public static
    class ViewHolder_banner_one extends RecyclerView.ViewHolder {
        public View rootView;
        public Banner banner_list_one;

        public ViewHolder_banner_one(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.banner_list_one = (Banner) rootView.findViewById(R.id.banner_list_one);
        }

    }


    public static
    class ViewHolder_list_two extends RecyclerView.ViewHolder {
        public View rootView;
        public Button but_kecheng;
        public Button but_zhibo;
        public Button but_fuli;
        public Button but_dayi;

        public ViewHolder_list_two(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.but_kecheng = (Button) rootView.findViewById(R.id.but_kecheng);
            this.but_zhibo = (Button) rootView.findViewById(R.id.but_zhibo);
            this.but_fuli = (Button) rootView.findViewById(R.id.but_fuli);
            this.but_dayi = (Button) rootView.findViewById(R.id.but_dayi);
        }

    }

    public static
    class ViewHolder_three extends RecyclerView.ViewHolder {
        public View rootView;
        public LinearLayout liner2;

        public ViewHolder_three(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.liner2 = (LinearLayout) rootView.findViewById(R.id.liner2);
        }

    }

    public static
    class ViewHolder_list_four extends RecyclerView.ViewHolder {
        public View rootView;
        public RecyclerView recy_nei;

        public ViewHolder_list_four(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.recy_nei = (RecyclerView) rootView.findViewById(R.id.recy_nei);
        }

    }
}
