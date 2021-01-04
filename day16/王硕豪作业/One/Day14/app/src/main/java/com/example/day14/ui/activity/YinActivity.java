package com.example.day14.ui.activity;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.day14.R;
import com.example.day14.base.App;
import com.example.day14.base.BaseActivity;
import com.example.day14.base.BasePresenter;
import com.example.day14.bean.ApiBean;
import com.example.day14.manager.GloadManager;
import com.example.day14.mvp.presenter.YinPresenter;
import com.example.day14.ui.WelComeActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class YinActivity extends BaseActivity {

    @BindView(R.id.iv_yin)
    ImageView ivYin;

    @Override
    protected BasePresenter createPresenter() {
        return new YinPresenter(this);
    }

    @Override
    public void onSuccess(Object o) {
        super.onSuccess(o);
        if (o instanceof ApiBean){
            ApiBean apiBean = (ApiBean) o;
            String data = apiBean.getData();
            Log.i("TAG", "请求数据成功: "+data);
            GloadManager.getmManager().save_str("data",data);
        }
    }

    @Override
    public void onFiled(String msg) {
        super.onFiled(msg);
        Log.i("TAG", "onFiled: "+msg);
        showToast(msg);
    }

    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_yin;
    }

    @Override
    protected void initData() {
        super.initData();
        getmPresenter().start();
    }

    @Override
    protected void initView() {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ObjectAnimator aFloat = ObjectAnimator.ofFloat(ivYin, View.ALPHA, 1, 0.3f);
        aFloat.setDuration(2000).start();
        aFloat.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                int isCount = GloadManager.getmManager().getInt("isCount");
                if (isCount == 0) {
                    GloadManager.getmManager().save_int("isCount",1);
                    startActivity(new Intent(App.getContext(), WelComeActivity.class));
                    finish();
                }else {
                    startActivity(new Intent(App.getContext(),HomeActivity.class));
                    finish();
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

}
