package com.example.day_demo09.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.baidu.mapapi.search.sug.OnGetSuggestionResultListener;
import com.baidu.mapapi.search.sug.SuggestionResult;
import com.baidu.mapapi.search.sug.SuggestionSearch;
import com.baidu.mapapi.search.sug.SuggestionSearchOption;
import com.example.day_demo09.R;
import com.example.day_demo09.adapter.SugAdapter;

import java.util.ArrayList;

/**
 * 介绍地点检索输入提示
 */
public class PoiSugSearchDemo extends AppCompatActivity implements OnGetSuggestionResultListener {

    private SuggestionSearch mSuggestionSearch = null;

    // 搜索关键字输入窗口
    private EditText mEditCity = null;
    private AutoCompleteTextView mKeyWordsView = null;
    private RecyclerView mSugListView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poisugsearch);

        // 初始化建议搜索模块，注册建议搜索事件监听
        mSuggestionSearch = SuggestionSearch.newInstance();
        mSuggestionSearch.setOnGetSuggestionResultListener(this);

        // 初始化view
        mEditCity = (EditText) findViewById(R.id.city);
        mSugListView = (RecyclerView) findViewById(R.id.sug_list);
        mKeyWordsView = (AutoCompleteTextView) findViewById(R.id.searchkey);
        mKeyWordsView.setThreshold(1);


        mSugListView.setLayoutManager(new LinearLayoutManager(this));

        // 当输入关键字变化时，动态更新建议列表
        mKeyWordsView.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable arg0) {

            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {

            }

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                if (cs.length() <= 0) {
                    return;
                }

                // 使用建议搜索服务获取建议列表，结果在onSuggestionResult()中更新
                mSuggestionSearch.requestSuggestion((new SuggestionSearchOption())
                        .keyword(cs.toString()) // 关键字
                        .city(mEditCity.getText().toString())); // 城市
            }
        });
    }


    /**
     * 获取在线建议搜索结果，得到requestSuggestion返回的搜索结果
     *
     * @param suggestionResult Sug检索结果
     */
    @Override
    public void onGetSuggestionResult(SuggestionResult suggestionResult) {
        if (suggestionResult == null || suggestionResult.getAllSuggestions() == null) {
            return;
        }

        ArrayList<Double> longList = new ArrayList<>();
        ArrayList<Double> latList = new ArrayList<>();
        ArrayList<String> key = new ArrayList<>();
        ArrayList<String> city = new ArrayList<>();
        ArrayList<String> dis = new ArrayList<>();
        for (SuggestionResult.SuggestionInfo info : suggestionResult.getAllSuggestions()) {
            if (info.getKey() != null && info.getDistrict() != null && info.getCity() != null) {
                key.add(info.getKey());
                city.add(info.getCity());
                dis.add(info.getDistrict());
                if (info.pt != null) {
                    Log.e("TAG", "run:" + info.pt.latitude);
                    longList.add(info.pt.longitude);
                    latList.add(info.pt.latitude);
                }
            }
        }

        SugAdapter adapter = new SugAdapter(this,key,city,dis);
        mSugListView.setAdapter(adapter);

        adapter.notifyDataSetChanged();

        adapter.setOnClick(new SugAdapter.OnClick() {
            @Override
            public void OnClickListener(int pos) {
                Intent intent = new Intent(PoiSugSearchDemo.this, SouActivity.class);
                intent.putExtra("long", longList.get(pos));
                intent.putExtra("lat", latList.get(pos));
                startActivity(intent);
            }
        });

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSuggestionSearch.destroy();
    }

}
