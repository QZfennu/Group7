package com.example.day_demo09.activity;

import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.example.day_demo09.R;
import com.example.day_demo09.base.BaseActivity;
import com.example.day_demo09.base.BasePresenter;

import butterknife.BindView;

public class SouActivity extends BaseActivity {

    @BindView(R.id.map)
    MapView mMapView;
    private BaiduMap mBaiduMap;
    private Marker overlay;

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        double mLong = intent.getDoubleExtra("long", 1.0);
        double mLat = intent.getDoubleExtra("lat", 1.0);

        Log.e("TAG", "run:" + mLat + "==================" + mLong);


        mBaiduMap = mMapView.getMap();

        //定义Maker坐标点
        LatLng point = new LatLng(mLat, mLong);

        //构建Marker图标
        BitmapDescriptor bitmap = BitmapDescriptorFactory
                .fromResource(R.drawable.water_drop);
        //构建MarkerOption，用于在地图上添加Marker
        OverlayOptions option = new MarkerOptions()
                .position(point)
                .icon(bitmap)
                .clickable(true);
        //在地图上添加Marker，并显示
        mBaiduMap.addOverlay(option);


        BitmapDescriptor mBitmap = BitmapDescriptorFactory.fromResource(R.drawable.water_drop);
        MarkerOptions markerOptions = new MarkerOptions().position(point).icon(mBitmap);
        overlay = (Marker) mBaiduMap.addOverlay(markerOptions);

        overlay.setPosition(point);


        mBaiduMap.setOnMarkerClickListener(new BaiduMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                Toast.makeText(SouActivity.this, "111111", Toast.LENGTH_SHORT).show();
                return false;
            }
        });


    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_sou;
    }

    @Override
    public void getData(Object o) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mMapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mMapView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mMapView.onDestroy();
    }
}