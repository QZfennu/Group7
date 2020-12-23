package com.example.mapbaidu;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, BaiduMap.OnMyLocationClickListener {


    private MapView bmapView;
    private BaiduMap map;
    private Button but_ding;
    private LocationClient locationClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        MapStatus build = new MapStatus.Builder().target(new LatLng(39.12344, 11412345)).zoom(8).build();
        map.setOnMyLocationClickListener(this);
        map.animateMapStatus(MapStatusUpdateFactory.newMapStatus(build));


        addMarkers();
    }

    private void addMarkers() {
        LatLng llA = new LatLng(39.963175, 116.400244);
        LatLng llB = new LatLng(39.942821, 116.369199);
        LatLng llC = new LatLng(39.939723, 116.425541);
        LatLng llD = new LatLng(39.906965, 116.401394);
        LatLng llE = new LatLng(39.956965, 116.331394);
        LatLng llF = new LatLng(39.886965, 116.441394);
        LatLng llG = new LatLng(39.996965, 116.411394);

        List<MyItem> items = new ArrayList<MyItem>();
        items.add(new MyItem(llA));
        items.add(new MyItem(llB));
        items.add(new MyItem(llC));
        items.add(new MyItem(llD));
        items.add(new MyItem(llE));
        items.add(new MyItem(llF));
        items.add(new MyItem(llG));
    }



    private void initView() {

        bmapView = (MapView) findViewById(R.id.bmapView);
        //获取地图层
        map = bmapView.getMap();
        map.setMyLocationEnabled(true);//开启定位


        bmapView.setOnClickListener(this);
        but_ding = (Button) findViewById(R.id.but_ding);
        but_ding.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.but_ding:
                locationClient = new LocationClient(this);
                LocationClientOption option = new LocationClientOption();option.setOpenGps(true);
                option.setCoorType("bd12ul");
                option.setScanSpan(1000);
                locationClient.setLocOption(option);
                MLocationListener mLocationListener = new MLocationListener();
                locationClient.registerLocationListener(mLocationListener);
                locationClient.start();
                break;
        }
    }

    @Override
    public boolean onMyLocationClick() {

        return false;
    }

    public class MLocationListener extends BDAbstractLocationListener {
        @Override
        public void onReceiveLocation(BDLocation bdLocation) {
            if (bdLocation == null || bmapView == null) {
                return;
            }
            MyLocationData build = new MyLocationData.Builder().
                    accuracy(bdLocation.getRadius())
                    .direction(bdLocation.getDirection()).latitude(bdLocation.getLatitude())
                    .longitude(bdLocation.getLongitude()).build();
            map.setMyLocationData(build);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        locationClient.stop();
        map.setMyLocationEnabled(false);
        bmapView.onDestroy();
        bmapView=null;
    }

    private class MyItem {
        
    }
}
