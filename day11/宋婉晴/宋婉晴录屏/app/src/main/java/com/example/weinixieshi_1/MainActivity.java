package com.example.weinixieshi_1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weinixieshi_1.adapter.RlvAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private MessageReceiver mMessageReceiver;
    private RelativeLayout relll;
    private Toolbar toolbar;
    private RecyclerView recycler;
    private TabLayout tab;
    private RlvAdapter adapter;
    public static final String MESSAGE_RECEIVED_ACTION = "cn.jiguang.demo.jpush.MESSAGE_RECEIVED_ACTION";
    public static final String KEY_MESSAGE = "message";
    public static final String KEY_EXTRAS = "extras";
    public static boolean isForeground = false;
    public static int sequence = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        Set<String> tags = new HashSet<>();
        int action =1;
        boolean isAliasAction = false;
        tags.add("111");
        tags.add("作业");
        TagAliasOperatorHelper.TagAliasBean tagAliasBean = new TagAliasOperatorHelper.TagAliasBean();
        tagAliasBean.action = action;
        sequence++;
        tagAliasBean.tags = tags;
        tagAliasBean.isAliasAction = isAliasAction;
        TagAliasOperatorHelper.getInstance().handleAction(getApplicationContext(), sequence, tagAliasBean);
    }

    private void initView() {
        relll = (RelativeLayout) findViewById(R.id.relll);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        recycler = (RecyclerView) findViewById(R.id.recycler);
        tab = (TabLayout) findViewById(R.id.tab);

        tab.addTab(tab.newTab().setText("首页").setIcon(R.drawable.icon_home_pager_not_selected));
        tab.addTab(tab.newTab().setText("攻略").setIcon(R.drawable.icon_knowledge_hierarchy_not_selected));
        tab.addTab(tab.newTab().setText("我的").setIcon(R.drawable.icon_me_not_selected));
        ArrayList<Integer> list = new ArrayList<>();
        recycler.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RlvAdapter(this,list);
        list.add(R.drawable.d);
        list.add(R.drawable.h);
        list.add(R.drawable.g);
        list.add(R.drawable.i);
        list.add(R.drawable.f);
        recycler.setAdapter(adapter);

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

}
