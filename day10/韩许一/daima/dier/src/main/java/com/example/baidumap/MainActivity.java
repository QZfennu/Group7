package com.example.baidumap;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener;
import com.baidu.mapapi.search.poi.PoiAddrInfo;
import com.baidu.mapapi.search.poi.PoiCitySearchOption;
import com.baidu.mapapi.search.poi.PoiDetailResult;
import com.baidu.mapapi.search.poi.PoiDetailSearchResult;
import com.baidu.mapapi.search.poi.PoiIndoorResult;
import com.baidu.mapapi.search.poi.PoiResult;
import com.baidu.mapapi.search.poi.PoiSearch;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private MapView bmapView;
    private BaiduMap map;
    private Button but_qie;
    private Button but_re;
    private LocationClient locationClient;
    private LocationClientOption option;
    private Button but_ding;
    private PoiSearch poiSearch;
    private Button but_shur;
    private OnGetPoiSearchResultListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();

    }

    private void initData() {
        //创建 pos 检索实例
        poiSearch = PoiSearch.newInstance();
        //检索监听器

        listener = new OnGetPoiSearchResultListener() {
            @Override
            public void onGetPoiResult(PoiResult poiResult) {

                if (poiResult.error == SearchResult.ERRORNO.NO_ERROR) {
                    //创建PoiOverlay对象
                    map.clear();
                    PoiOverlay poiOverlay = new PoiOverlay(map);
                    //设置Poi检索数据
                    poiOverlay.setData(poiResult);
                    //将poiOverlay添加至地图并缩放至合适级别
                    poiOverlay.addToMap();
                    poiOverlay.zoomToSpan();
                }
                if (poiResult.getAllAddr() ==null){

                }else {
                    PoiAddrInfo poiAddrInfo = poiResult.getAllAddr().get(0);
                    Toast.makeText(MainActivity.this, "地址"+poiAddrInfo.address, Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this, "名字"+poiAddrInfo.name, Toast.LENGTH_SHORT).show();
                    Log.i("TAG", "地址: "+poiAddrInfo.address);
                    Log.i("TAG", "名字: "+poiAddrInfo.name);
                }

            }
            @Override
            public void onGetPoiDetailResult(PoiDetailResult poiDetailResult) {

            }

            @Override
            public void onGetPoiDetailResult(PoiDetailSearchResult poiDetailSearchResult) {

            }

            @Override
            public void onGetPoiIndoorResult(PoiIndoorResult poiIndoorResult) {

            }
        };


        //设置Poi检索数据
//通过第一条检索信息对应的uid发起详细信息检索


    }


    private void initView() {

        bmapView = (MapView) findViewById(R.id.bmapView);
        but_ding = (Button) findViewById(R.id.but_ding);
        but_re = (Button) findViewById(R.id.but_re);
        but_qie = (Button) findViewById(R.id.but_qie);
        but_ding.setOnClickListener(this);
        bmapView.setOnClickListener(this);
        but_qie.setOnClickListener(this);
        but_re.setOnClickListener(this);

        map = bmapView.getMap();

        //初始化定位


        but_shur = (Button) findViewById(R.id.but_shur);
        but_shur.setOnClickListener(this);
    }

    //构造地图的数据    //定位!!
    public class MyLocationListener extends BDAbstractLocationListener {

        @Override
        public void onReceiveLocation(BDLocation bdLocation) {
            if (bdLocation == null || bmapView == null) {
                return;
            }
            MyLocationData locData = new MyLocationData.Builder()
                    .accuracy(bdLocation.getRadius())
                    // 此处设置开发者获取到的方向信息，顺时针0-360
                    .direction(bdLocation.getDirection()).latitude(bdLocation.getLatitude())
                    .longitude(bdLocation.getLongitude()).build();
            map.setMyLocationData(locData);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        bmapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();

        bmapView.onPause();
    }

    //地图的生命周期和 activity的生命周期进行绑定
    @Override
    protected void onDestroy() {
        super.onDestroy();
        locationClient.stop();
        map.setMyLocationEnabled(false); // 关闭定位
        bmapView = null;
        bmapView.onDestroy();
        poiSearch.destroy();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.but_qie:

                if (but_qie.getText().equals("普通地图")) {
                    but_qie.setText("卫星地图");
                    map.setMapType(BaiduMap.MAP_TYPE_SATELLITE);
                    break;
                } else if (but_qie.getText().equals("卫星地图")) {
                    but_qie.setText("普通地图");
                    map.setMapType(BaiduMap.MAP_TYPE_NORMAL);
                    break;
                }
                break;
            case R.id.but_re:
                if (but_re.getText().equals("热力图(关)")) {
                    map.setBaiduHeatMapEnabled(true);
                    but_re.setText("热力图(开)");
                    break;
                }
                if (but_re.getText().equals("热力图(开)")) {
                    map.setBaiduHeatMapEnabled(false);
                    but_re.setText("热力图(关)");
                    break;
                }
                break;
            case R.id.but_ding:
                Ding();
                break;
            case R.id.but_shur:
                poiSearch.setOnGetPoiSearchResultListener(listener);
                poiSearch.searchInCity(new PoiCitySearchOption()
                        .city("北京") //必填
                        .keyword("美食") //必填
                        .pageNum(10));
                break;
        }
    }
    private void Ding() {

        map.setMyLocationEnabled(true); // 开启定位图层   可以进行定位
        locationClient = new LocationClient(this);
        option = new LocationClientOption();
        option.setOpenGps(true); ///打开 GPS
        option.setCoorType("bd09ll");
        option.setScanSpan(1000);
        locationClient.setLocOption(option);  //设置locationclient
        //创建监听器   使用
        MyLocationListener myLocationListener = new MyLocationListener();
        locationClient.registerLocationListener(myLocationListener);
        locationClient.start();
    }
}
