package com.example.day_demo09.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.day_demo09.R;
import com.example.day_demo09.bean.HotBean;
import com.example.day_demo09.bean.TitleBean;
import com.example.day_demo09.fragment.ItemFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeAdapter extends RecyclerView.Adapter {

    private Context context;
    private ArrayList<HotBean.DataBean> list;
    private ArrayList<TitleBean.DataBean> titleList;
    private final FragmentManager supportFragmentManager;

    public HomeAdapter(Context context, ArrayList<HotBean.DataBean> list, ArrayList<TitleBean.DataBean> titleList, FragmentManager supportFragmentManager) {
        this.context = context;
        this.list = list;
        this.titleList = titleList;
        this.supportFragmentManager = supportFragmentManager;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else if (position == 1) {
            return 1;
        } else {
            return 2;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View view0 = LayoutInflater.from(context).inflate(R.layout.item_0, parent, false);
            return new ViewHolder0(view0);
        } else if (viewType == 1) {
            View view1 = LayoutInflater.from(context).inflate(R.layout.item_1, parent, false);
            return new ViewHolder1(view1);
        } else {
            View view2 = LayoutInflater.from(context).inflate(R.layout.item_2, parent, false);
            return new ViewHolder2(view2);
        }
    }

    private OnClick onClick;

    public void setOnClick(OnClick onClick) {
        this.onClick = onClick;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);
        if (type == 0) {
            ViewHolder0 viewHolder0 = (ViewHolder0) holder;
            Glide.with(context).load(R.drawable.a).apply(new RequestOptions().circleCrop()).into(viewHolder0.iv1);
            Glide.with(context).load(R.drawable.b).apply(new RequestOptions().circleCrop()).into(viewHolder0.iv2);
            Glide.with(context).load(R.drawable.c).apply(new RequestOptions().circleCrop()).into(viewHolder0.iv3);
            Glide.with(context).load(R.drawable.d).apply(new RequestOptions().circleCrop()).into(viewHolder0.iv4);
            Glide.with(context).load(R.drawable.e).apply(new RequestOptions().circleCrop()).into(viewHolder0.iv5);


            viewHolder0.line1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClick.OnClickListener(1);
                }
            });

            viewHolder0.line2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClick.OnClickListener(2);
                }
            });

            viewHolder0.line3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClick.OnClickListener(3);
                }
            });

            viewHolder0.line4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClick.OnClickListener(4);
                }
            });

            viewHolder0.line5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClick.OnClickListener(5);
                }
            });

        } else if (type == 1) {
            ViewHolder1 viewHolder1 = (ViewHolder1) holder;
            viewHolder1.recHot.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            HotAdapter adapter = new HotAdapter(context, list);
            viewHolder1.recHot.setAdapter(adapter);
        } else if (type == 2) {
            ViewHolder2 viewHolder2 = (ViewHolder2) holder;
            ArrayList<Fragment> list = new ArrayList<>();
            ArrayList<String> title = new ArrayList<>();

            ItemAdapter adapter = new ItemAdapter(supportFragmentManager, list, title);
            viewHolder2.vwvHome.setAdapter(adapter);
            viewHolder2.tabHome.setupWithViewPager(viewHolder2.vwvHome);

            for (int i = 0; i < titleList.size(); i++) {
                ItemFragment itemFragment = new ItemFragment();
                list.add(itemFragment);
                title.add(titleList.get(i).getName());

                Bundle bundle = new Bundle();
                bundle.putInt("id", titleList.get(i).getType());
                itemFragment.setArguments(bundle);
            }

            adapter.notifyDataSetChanged();
        }
    }

    public interface OnClick {
        void OnClickListener(int pos);
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    static
    class ViewHolder0 extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_1)
        ImageView iv1;
        @BindView(R.id.line1)
        LinearLayout line1;
        @BindView(R.id.iv_2)
        ImageView iv2;
        @BindView(R.id.line2)
        LinearLayout line2;
        @BindView(R.id.iv_3)
        ImageView iv3;
        @BindView(R.id.line3)
        LinearLayout line3;
        @BindView(R.id.iv_4)
        ImageView iv4;
        @BindView(R.id.line4)
        LinearLayout line4;
        @BindView(R.id.iv_5)
        ImageView iv5;
        @BindView(R.id.line5)
        LinearLayout line5;

        ViewHolder0(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    static
    class ViewHolder1 extends RecyclerView.ViewHolder {
        @BindView(R.id.rec_hot)
        RecyclerView recHot;

        ViewHolder1(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    static
    class ViewHolder2 extends RecyclerView.ViewHolder {
        @BindView(R.id.tab_home)
        TabLayout tabHome;
        @BindView(R.id.vwv_home)
        ViewPager vwvHome;

        ViewHolder2(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
