package com.example.day05.adpter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.day05.R;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

public class Adpter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<Integer> list;
    private int IMAGE = 0;

    public Adpter(Context context, ArrayList<Integer> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == IMAGE) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_image, parent, false);
            return new Image(view);
        }
        if (viewType == 1) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_one, parent, false);
            return new One(view);
        }
        if (viewType == 2) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_two, parent, false);
            return new Two(view);
        }
        if (viewType == 3) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_three, parent, false);
            return new Three(view);
        }
        if (viewType == 4) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_four, parent, false);
            return new Four(view);
        }

        View view = LayoutInflater.from(context).inflate(R.layout.item_five, parent, false);
        return new Five(view);


    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        int itemViewType = getItemViewType(position);
        if (itemViewType == IMAGE) {
            Image image = (Image) holder;
           image.iv_image.setImages(list).setImageLoader(new ImageLoader() {
               @Override
               public void displayImage(Context context, Object path, ImageView imageView) {

                   Glide.with(context).load(path).into(imageView);
               }
           }).start();
        }
        if (itemViewType == 1) {
            One one = (One) holder;
            one.btn_left.setText("民宿");
            one.btn_right.setText("翻译");
        }
        if (itemViewType == 2) {
            Two two = (Two) holder;
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
            two.rv_main.setLayoutManager(linearLayoutManager);
            TwoAdpter adpter = new TwoAdpter(context, list);
            two.rv_main.setAdapter(adpter);
        }
        if (itemViewType == 3) {
            Three three = (Three) holder;
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
            three.rv_main.setLayoutManager(linearLayoutManager);
            ThreeAdpter adpter = new ThreeAdpter(context, list);
            three.rv_main.setAdapter(adpter);
        }
        if (itemViewType == 4) {
            Four four = (Four) holder;
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
            four.rv_main.setLayoutManager(linearLayoutManager);
            FourAdpter adpter = new FourAdpter(context, list);
            four.rv_main.setAdapter(adpter);
        }
        if (itemViewType == 5) {
            Five five = (Five) holder;
            five.rv_main.setImageResource(R.drawable.h2);
        }
    }

    @Override
    public int getItemCount() {
        return list.size()-2;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return IMAGE;
        } else if (position == 1) {
            return 1;
        } else if (position == 2) {
            return 2;
        } else if (position == 3) {
            return 3;
        } else if (position == 4) {
            return 4;
        }
        return 5;

    }

    public static
    class Image extends RecyclerView.ViewHolder {
        public View rootView;
        public Banner iv_image;

        public Image(View rootView) {
            super(rootView);
            this.rootView = rootView;
            iv_image= rootView.findViewById(R.id.banner_item1);
        }

    }

    public static
    class One extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView tv_text;
        public Button btn_left;
        public Button btn_right;

        public One(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.tv_text = (TextView) rootView.findViewById(R.id.tv_text);
            this.btn_left = (Button) rootView.findViewById(R.id.btn_left);
            this.btn_right = (Button) rootView.findViewById(R.id.btn_right);
        }

    }

    public static
    class Two extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView tv_text;
        public TextView tv_text1;
        public RecyclerView rv_main;

        public Two(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.tv_text = (TextView) rootView.findViewById(R.id.tv_text);
            this.tv_text1 = (TextView) rootView.findViewById(R.id.tv_text1);
            this.rv_main = (RecyclerView) rootView.findViewById(R.id.rv_main);
        }

    }

    public static
    class Three extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView tv_text;
        public TextView tv_text1;
        public RecyclerView rv_main;

        public Three(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.tv_text = (TextView) rootView.findViewById(R.id.tv_text);
            this.tv_text1 = (TextView) rootView.findViewById(R.id.tv_text1);
            this.rv_main = (RecyclerView) rootView.findViewById(R.id.rv_main);
        }

    }

    public static
    class Four extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView tv_text;
        public TextView tv_text1;
        public RecyclerView rv_main;

        public Four(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.tv_text = (TextView) rootView.findViewById(R.id.tv_text);
            this.tv_text1 = (TextView) rootView.findViewById(R.id.tv_text1);
            this.rv_main = (RecyclerView) rootView.findViewById(R.id.rv_main);
        }

    }

    public static
    class Five extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView tv_text;
        public ImageView rv_main;

        public Five(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.tv_text = (TextView) rootView.findViewById(R.id.tv_text);
            this.rv_main = (ImageView) rootView.findViewById(R.id.rv_main);
        }

    }
}
