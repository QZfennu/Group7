package com.example.day14.ui.activity;

import android.view.WindowManager;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.day14.R;
import com.example.day14.base.BaseActivity;
import com.example.day14.base.BasePresenter;
import com.example.day14.ui.fragment.ChooseFragment;

import butterknife.BindView;

public class XuanKeActivity extends BaseActivity {

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_xuanke;
    }

    @Override
    protected void initView() {
        getSupportFragmentManager().beginTransaction().add(R.id.fl_xuanke,new ChooseFragment()).commit();
    }
}
