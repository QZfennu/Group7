package com.example.day14.ui.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.day14.R;
import com.example.day14.adapter.ChooseRvAdapter;
import com.example.day14.base.App;
import com.example.day14.base.BaseFragment;
import com.example.day14.bean.Choose_courseBean;
import com.example.day14.ui.activity.HomeActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ChooseFragment extends BaseFragment {

    @BindView(R.id.choose_rv)
    RecyclerView mChooseRv;
    @BindView(R.id.btn_choose)
    Button mChooseBtn;

    @Override
    protected void initData() {

    }

    @Override
    protected void init() {
        mChooseRv.setLayoutManager(new LinearLayoutManager(App.getContext(), RecyclerView.VERTICAL,false));
        ChooseRvAdapter chooseRvAdapter = new ChooseRvAdapter(getRvData());
        mChooseRv.setAdapter(chooseRvAdapter);

        mChooseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeActivity.setText("基金从业");
                Intent intent = new Intent(App.getContext(), HomeActivity.class);
                startActivity(intent);
            }
        });
    }

    private List<Choose_courseBean> getRvData() {
        List<Choose_courseBean> rvList = new ArrayList<>();

        List<String> courseList1 = new ArrayList<>();
        courseList1.add("基金从业");
        courseList1.add("银行从业");
        courseList1.add("期贷从业");
        courseList1.add("证券从业");

        List<String> courseList3 = new ArrayList<>();
        courseList3.add("注册会记师");
        courseList3.add("会记职称");
        courseList3.add("经济师考试");
        courseList3.add("证券从业");

        List<String> courseList4 = new ArrayList<>();
        courseList4.add("CMA");

        List<String> courseList5 = new ArrayList<>();
        courseList5.add("教师资格");

        List<String> courseList6 = new ArrayList<>();
        courseList6.add("建造师");

        rvList.add(new Choose_courseBean("热门选课",courseList1));
        rvList.add(new Choose_courseBean("金融学院",courseList1));
        rvList.add(new Choose_courseBean("财会学院",courseList3));
        rvList.add(new Choose_courseBean("国际证书",courseList4));
        rvList.add(new Choose_courseBean("职业资格",courseList5));
        rvList.add(new Choose_courseBean("建筑工程",courseList6));

        return rvList;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_choose_course;
    }
}
