package com.example.android_shixun_mvp_1.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.android_shixun_mvp_1.R;
import com.example.android_shixun_mvp_1.adapter.TabAdapter;
import com.example.android_shixun_mvp_1.bean.TabBean;
import com.example.android_shixun_mvp_1.presenter.MainPresenter;
import com.example.android_shixun_mvp_1.view.MainView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class TabFragment extends Fragment implements MainView {

    private TabLayout mTabT;
    private ViewPager mVpT;
    private MainPresenter presenter;
    private List<TabBean.DataBean> data;
    private ArrayList<ShouFragment> fragments;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_tab, null);
        presenter = new MainPresenter(this);
        initData();
        initView(view);
        return view;
    }

    private void initData() {
        presenter.getData();
    }

    private void initView(@NonNull final View itemView) {
        mTabT = (TabLayout) itemView.findViewById(R.id.t_tab);
        mVpT = (ViewPager) itemView.findViewById(R.id.t_vp);

    }

    @Override
    public void onSuccess(TabBean tabBean) {
        if (tabBean.getData()!=null){
            data = tabBean.getData();
            fragments = new ArrayList<>();
            for (int i = 0; i < data.size(); i++) {
                ShouFragment shouFragment = new ShouFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("id",data.get(i).getId());
                shouFragment.setArguments(bundle);
                fragments.add(shouFragment);
            }
            TabAdapter adapter = new TabAdapter(getChildFragmentManager(), data, fragments);
            mVpT.setAdapter(adapter);
            mTabT.setupWithViewPager(mVpT);
        }
    }

    @Override
    public void onFail(String file) {

    }
}
