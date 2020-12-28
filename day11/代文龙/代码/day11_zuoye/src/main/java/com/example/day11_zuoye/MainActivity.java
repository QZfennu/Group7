package com.example.day11_zuoye;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

import cn.jpush.android.api.JPushInterface;

import static com.example.day11_zuoye.TagAliasOperatorHelper.ACTION_ADD;
import static com.xiaomi.mipush.sdk.PushMessageHelper.KEY_MESSAGE;

public class MainActivity extends AppCompatActivity {

    private MessageReceiver mMessageReceiver;
    public static final String MESSAGE_RECEIVED_ACTION = "cn.jiguang.demo.jpush.MESSAGE_RECEIVED_ACTION";
    public static final String KEY_MESSAGE = "message";
    public static final String KEY_EXTRAS = "extras";
    public static boolean isForeground = false;
    private Toolbar toolbar_main;
    private Banner banner_main;
    private RecyclerView rv_hai;
    private RecyclerView rv_guo;
    private TabLayout tab_main;
    private TextView tv_toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        JPushInterface.init(getApplicationContext());
        initView();
        initData();
        initListener();
        registerMessageReceiver();
    }

    private void registerMessageReceiver() {
        mMessageReceiver = new MessageReceiver();
        IntentFilter filter = new IntentFilter();
        filter.setPriority(IntentFilter.SYSTEM_HIGH_PRIORITY);
        filter.addAction(MESSAGE_RECEIVED_ACTION);
        LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReceiver, filter);
    }

    public class MessageReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            try {
                if (MESSAGE_RECEIVED_ACTION.equals(intent.getAction())) {
                    String messge = intent.getStringExtra(KEY_MESSAGE);
                    String extras = intent.getStringExtra(KEY_EXTRAS);
                    StringBuilder showMsg = new StringBuilder();
                    showMsg.append(KEY_MESSAGE + " : " + messge + "\n");
                    if (!DeviceUtil.isEmpty(extras)) {
                        showMsg.append(KEY_EXTRAS + " : " + extras + "\n");
                    }
                    Log.e("TAG", showMsg.toString());
                }
            } catch (Exception e) {
            }
        }
    }

    private void initListener() {
        tab_main.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tv_toolbar.setText(tab.getText());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    public static int sequence = 1;

    private void initData() {
        hai();
        guo();

        String tag = "男";
        String alias = null;
        Set<String> tags = null;
        int action = -1;
        boolean isAliasAction = false;
        if (TextUtils.isEmpty(tag)) {
            Toast.makeText(this, "tag不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        if (tags == null) {
            return;
        }
        action = ACTION_ADD;
        TagAliasOperatorHelper.TagAliasBean tagAliasBean = new TagAliasOperatorHelper.TagAliasBean();
        tagAliasBean.action = action;
        sequence++;
        if (isAliasAction) {
            tagAliasBean.alias = alias;
        } else {
            tagAliasBean.tags = tags;
        }
        tagAliasBean.isAliasAction = isAliasAction;
        TagAliasOperatorHelper.getInstance().handleAction(getApplicationContext(), sequence, tagAliasBean);
    }

    private void guo() {
        ArrayList<GuoBean> guolist = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            guolist.add(new GuoBean(R.drawable.guo, "大理 DALI"));
        }
        rv_guo.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        GuoAdapter guoAdapter = new GuoAdapter(guolist, this);
        rv_guo.setAdapter(guoAdapter);
    }

    private void hai() {
        ArrayList<HaiBean> haiBeans = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            haiBeans.add(new HaiBean(R.drawable.hai));
        }
        rv_hai.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        HaiAdapter haiAdapter = new HaiAdapter(haiBeans, this);
        rv_hai.setAdapter(haiAdapter);
    }

    private void initView() {
        toolbar_main = (Toolbar) findViewById(R.id.toolbar_main);
        banner_main = (Banner) findViewById(R.id.banner_main);
        rv_hai = (RecyclerView) findViewById(R.id.rv_hai);
        rv_guo = (RecyclerView) findViewById(R.id.rv_guo);
        tab_main = (TabLayout) findViewById(R.id.tab_main);
        tv_toolbar = (TextView) findViewById(R.id.tv_toolbar);
        toolbar_main.setTitle(" ");
        setSupportActionBar(toolbar_main);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(R.drawable.banner);
        }
        banner_main.setImages(list)
                .setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object path, ImageView imageView) {
                        Glide.with(context).load(path).into(imageView);
                    }
                }).start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.item_options, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onResume() {
        isForeground = true;
        super.onResume();
    }


    @Override
    protected void onPause() {
        isForeground = false;
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mMessageReceiver);
        super.onDestroy();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_options:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
