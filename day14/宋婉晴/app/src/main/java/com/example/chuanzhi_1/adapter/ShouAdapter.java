package com.example.chuanzhi_1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chuanzhi_1.R;

public class ShouAdapter extends RecyclerView.Adapter {
    private Context context;

    public ShouAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 1) {
            View one = LayoutInflater.from(context).inflate(R.layout.layout_one, parent, false);
            return new OneHolder(one);
        }
        if (viewType == 2) {
            View two = LayoutInflater.from(context).inflate(R.layout.layout_two, parent, false);
            return new TwoHolder(two);
        }
        if (viewType == 3) {
            View three = LayoutInflater.from(context).inflate(R.layout.layout_three, parent, false);
            return new ThreeHolder(three);
        }
            View four = LayoutInflater.from(context).inflate(R.layout.layout_four, parent, false);
            return new FourHolder(four);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 4;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0){
            return 1;
        }
        if (position == 1){
            return 2;
        }
        if (position == 2){
            return 3;
        }
        return 4;
    }

    public static
    class OneHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView one_img;

        public OneHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.one_img = (ImageView) rootView.findViewById(R.id.one_img);
        }
    }

    public static
    class TwoHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView two_1;
        public TextView two_2;
        public TextView two_3;
        public TextView two_4;

        public TwoHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.two_1 = (TextView) rootView.findViewById(R.id.two_1);
            this.two_2 = (TextView) rootView.findViewById(R.id.two_2);
            this.two_3 = (TextView) rootView.findViewById(R.id.two_3);
            this.two_4 = (TextView) rootView.findViewById(R.id.two_4);
        }

    }

    public static
    class ThreeHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView three_b;

        public ThreeHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.three_b = (TextView) rootView.findViewById(R.id.three_b);
        }

    }

    public static
    class FourHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView four_img1;
        public ImageView four_img2;
        public ImageView four_img3;

        public FourHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.four_img1 = (ImageView) rootView.findViewById(R.id.four_img1);
            this.four_img2 = (ImageView) rootView.findViewById(R.id.four_img2);
            this.four_img3 = (ImageView) rootView.findViewById(R.id.four_img3);
        }

    }
}
