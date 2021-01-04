package com.example.day15.ui.fragment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.day15.R;
import com.example.day15.base.BaseFragment;
import com.example.day15.base.BasePresenter;
import com.example.day15.mvp.adapter.HomeFragmentAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import butterknife.BindView;


public class HomeFragment extends BaseFragment {
    @BindView(R.id.tab_fragment_home)
    TabLayout tabFragmentHome;
    @BindView(R.id.vp_fragment_home)
    ViewPager vpFragmentHome;
    private FragmentManager supportFragmentManager;
    private HomeFragmentAdapter homeFragmentAdapter;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        supportFragmentManager = getActivity().getSupportFragmentManager();
        homeFragmentAdapter = new HomeFragmentAdapter(supportFragmentManager, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,getListFragment(),getListString());
        vpFragmentHome.setAdapter(homeFragmentAdapter);
        tabFragmentHome.setupWithViewPager(vpFragmentHome);
    }

    private ArrayList<Fragment> getListFragment() {
        ArrayList<Fragment> list = new ArrayList<>();
        list.add(new GuanFragment());
        list.add(new TuiFragment());
        list.add(new GuanFragment());
        list.add(new GuanFragment());
        list.add(new GuanFragment());
        list.add(new GuanFragment());
        return list;
    }

    private ArrayList<String > getListString() {
        ArrayList<String> list = new ArrayList<>();
        list.add("关注");
        list.add("推荐");
        list.add("广场");
        list.add("视频");
        list.add("摄影");
        list.add("知识文章");
        return list;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }
}
