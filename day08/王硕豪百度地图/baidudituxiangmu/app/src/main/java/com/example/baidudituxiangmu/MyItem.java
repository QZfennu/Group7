package com.example.baidudituxiangmu;

import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.model.LatLng;
import com.example.baidudituxiangmu.clusterutil.clustering.ClusterItem;

public class MyItem implements ClusterItem {
    LatLng mPosition;
    public MyItem(LatLng position) {
        mPosition = position;
    }
    @Override
    public LatLng getPosition() {
        return mPosition;
    }
    @Override
    public BitmapDescriptor getBitmapDescriptor() {
        return BitmapDescriptorFactory
                .fromResource(R.drawable.icon_gcoding);
    }
}