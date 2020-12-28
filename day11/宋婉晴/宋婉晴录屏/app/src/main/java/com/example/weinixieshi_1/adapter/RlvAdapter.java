package com.example.weinixieshi_1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weinixieshi_1.R;

import java.util.ArrayList;

public class RlvAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<Integer> list;
    private ThreeAdapter adapter;
    private FourAdapter adapter1;
    private FiveAdapter adapter2;

    public RlvAdapter(Context context, ArrayList<Integer> list) {
        this.context = context;
        this.list = list;
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
        if (viewType == 4) {
            View four = LayoutInflater.from(context).inflate(R.layout.layout_four, parent, false);
            return new FourHolder(four);
        }
        if (viewType == 5) {
            View five = LayoutInflater.from(context).inflate(R.layout.layout_five, parent, false);
            return new FiveHolder(five);
        }
        View six = LayoutInflater.from(context).inflate(R.layout.layout_six, parent, false);
        return new SixHolder(six);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);
        if (type == 1){
            OneHolder oneHolder = (OneHolder) holder;
            oneHolder.one_a.setImageResource(list.get(0));
        }
        if (type == 2){
            TwoHolder twoHolder = (TwoHolder) holder;

        }
        if (type == 3){
            ThreeHolder threeHolder = (ThreeHolder) holder;
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
            threeHolder.three_rel.setLayoutManager(linearLayoutManager);
            adapter = new ThreeAdapter(context, list);
            threeHolder.three_rel.setAdapter(adapter);
        }
        if (type == 4){
            FourHolder fourHolder = (FourHolder) holder;
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
            fourHolder.four_rel.setLayoutManager(linearLayoutManager);
            adapter1 = new FourAdapter(context, list);
            fourHolder.four_rel.setAdapter(adapter1);
        }
        if (type == 5){
            FiveHolder fiveHolder = (FiveHolder) holder;
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
            fiveHolder.five_rel.setLayoutManager(linearLayoutManager);
            adapter2 = new FiveAdapter(context, list);
            fiveHolder.five_rel.setAdapter(adapter2);
        }
        if (type == 6){
            SixHolder sixHolder = (SixHolder) holder;
            sixHolder.six_img.setImageResource(list.get(1));
        }
    }

    @Override
    public int getItemCount() {
        return list.size()+1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0){
            return 1;
        }else if (position == 2){
            return 2;
        }else if (position == 3){
            return 3;
        }else if (position == 4){
            return 4;
        }else if (position == 5){
            return 5;
        }
        return 6;
    }

    public static
    class OneHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView one_a;

        public OneHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.one_a = (ImageView) rootView.findViewById(R.id.one_a);
        }

    }

    public static
    class TwoHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView two_b;

        public TwoHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.two_b = (ImageView) rootView.findViewById(R.id.two_b);
        }

    }

    public static
    class ThreeHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public RecyclerView three_rel;

        public ThreeHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.three_rel = (RecyclerView) rootView.findViewById(R.id.three_rel);
        }

    }

    public static
    class FourHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public RecyclerView four_rel;

        public FourHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.four_rel = (RecyclerView) rootView.findViewById(R.id.four_rel);
        }

    }

    public static
    class FiveHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public RecyclerView five_rel;

        public FiveHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.five_rel = (RecyclerView) rootView.findViewById(R.id.five_rel);
        }

    }

    public static
    class SixHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView six_img;

        public SixHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.six_img = (ImageView) rootView.findViewById(R.id.six_img);
        }

    }
}
