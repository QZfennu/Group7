package com.example.mapbaidu;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.search.sug.OnGetSuggestionResultListener;
import com.baidu.mapapi.search.sug.SuggestionResult;
import com.baidu.mapapi.search.sug.SuggestionSearch;
import com.baidu.mapapi.search.sug.SuggestionSearchOption;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MapView bmapView;
    private Button but_ding;
    private EditText edit_shur;

    private SuggestionSearch search;
    private OnGetSuggestionResultListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        bmapView = (MapView) findViewById(R.id.bmapView);
        but_ding = (Button) findViewById(R.id.but_ding);
        edit_shur = (EditText) findViewById(R.id.edit_shur);
        pisSearch();
        search.setOnGetSuggestionResultListener(listener);

        but_ding.setOnClickListener(this);

        edit_shur.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                search.requestSuggestion(new SuggestionSearchOption().city("北京")
                        .keyword(s.toString()));

            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.but_ding:

                break;
        }
    }

    private void pisSearch() {

        search = SuggestionSearch.newInstance();
        listener = new OnGetSuggestionResultListener() {

            @Override
            public void onGetSuggestionResult(SuggestionResult suggestionResult) {
                //处理sug 索检结果
            }
        };


    }

    private void submit() {
        // validate
        String shur = edit_shur.getText().toString().trim();
        if (TextUtils.isEmpty(shur)) {
            Toast.makeText(this, "shur不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        search.destroy();

    }
}