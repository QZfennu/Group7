package com.example.detext_tuisong;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<Bean> list;
    private ArrayList<Bean> beans;

    public HomeAdapter(Context context, ArrayList<Bean> list, ArrayList<Bean> beans) {
        this.context = context;
        this.list = list;
        this.beans = beans;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 1;
        } else if (position == 1) {
            return 2;
        } else if (position == 2) {
            return 3;
        } else if (position == 3) {
            return 4;
        } else if (position == 4) {
            return 5;
        } else {
            return 6;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 1) {
            View view = LayoutInflater.from(context).inflate(R.layout.itme1, parent, false);
            return new ViewHolder1(view);
        } else if (viewType == 2) {
            View view = LayoutInflater.from(context).inflate(R.layout.item2, parent, false);
            return new ViewHolder2(view);
        } else if (viewType == 3) {
            View view = LayoutInflater.from(context).inflate(R.layout.item3, parent, false);
            return new ViewHolder3(view);
        } else if (viewType == 4) {
            View view = LayoutInflater.from(context).inflate(R.layout.item4, parent, false);
            return new ViewHolder4(view);
        } else if (viewType == 5) {
            View view = LayoutInflater.from(context).inflate(R.layout.item5, parent, false);
            return new ViewHolder5(view);
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.item6, parent, false);
            return new ViewHolder6(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        switch (itemViewType) {
            case 1:
                ViewHolder1 holder1 = (ViewHolder1) holder;
                Glide.with(context).load(R.drawable.aa).into(holder1.img);
                break;
            case 2:
                ViewHolder2 holder2 = (ViewHolder2) holder;
                Glide.with(context).load(R.drawable.a).into(holder2.img1);
                Glide.with(context).load(R.drawable.b).into(holder2.img2);
                break;
            case 3:
                ViewHolder3 holder3 = (ViewHolder3) holder;
                holder3.rcy.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false));
                HomeAdapter1 homeAdapter1 = new HomeAdapter1(context, list);
                holder3.rcy.setAdapter(homeAdapter1);
                break;
            case 4:
                ViewHolder4 holder4 = (ViewHolder4) holder;
                holder4.rcy.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false));
                HomeAdapter2 homeAdapter2 = new HomeAdapter2(context, beans);
                holder4.rcy.setAdapter(homeAdapter2);
                break;
            case 5:
                ViewHolder5 holder5= (ViewHolder5) holder;
                Glide.with(context).load(R.drawable.cc).into(holder5.img);
                break;
            case 6:
                ViewHolder6 holder6= (ViewHolder6) holder;
                Glide.with(context).load(R.drawable.bb).into(holder6.img);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    public static
    class ViewHolder1 extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView img;

        public ViewHolder1(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.img = (ImageView) rootView.findViewById(R.id.img);
        }

    }

    public static
    class ViewHolder2 extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView img1;
        public ImageView img2;

        public ViewHolder2(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.img1 = (ImageView) rootView.findViewById(R.id.img1);
            this.img2 = (ImageView) rootView.findViewById(R.id.img2);
        }

    }

    public static
    class ViewHolder3 extends RecyclerView.ViewHolder {
        public View rootView;
        public RecyclerView rcy;

        public ViewHolder3(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.rcy = (RecyclerView) rootView.findViewById(R.id.rcy);
        }

    }

    public static
    class ViewHolder4 extends RecyclerView.ViewHolder {
        public View rootView;
        public RecyclerView rcy;

        public ViewHolder4(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.rcy = (RecyclerView) rootView.findViewById(R.id.rcy);
        }

    }

    public static
    class ViewHolder5 extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView img;

        public ViewHolder5(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.img = (ImageView) rootView.findViewById(R.id.img);
        }

    }

    public static
    class ViewHolder6 extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView img;

        public ViewHolder6(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.img = (ImageView) rootView.findViewById(R.id.img);
        }

    }
}
