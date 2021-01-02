package com.example.day14.ui;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.viewpager.widget.ViewPager;

import com.example.day14.R;
import com.example.day14.adapter.WelComeAdapter;
import com.example.day14.base.BaseActivity;
import com.example.day14.manager.GloadManager;
import com.example.day14.ui.activity.HomeActivity;
import com.example.day14.ui.fragment.HomeFragment;

import java.util.ArrayList;

import butterknife.BindView;

public class WelComeActivity extends BaseActivity {

    @BindView(R.id.vp_welcome)
    ViewPager vpWelcome;
    @BindView(R.id.tv_welcome)
    TextView tvWelcome;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void initView() {
        WelComeAdapter welComeAdapter = new WelComeAdapter(getList(),this);
        vpWelcome.setAdapter(welComeAdapter);
        vpWelcome.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == welComeAdapter.list.size() - 1){
                    tvWelcome.setVisibility(View.VISIBLE);
                }else {
                    tvWelcome.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected void initData() {
        tvWelcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WelComeActivity.this, HomeActivity.class));
                finish();
            }
        });
    }

    private ArrayList<Integer> getList() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(R.drawable.guide_page_one);
        list.add(R.drawable.guide_page_two);
        list.add(R.drawable.guide_page_three);
        return list;
    }
}
