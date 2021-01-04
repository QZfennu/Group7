package com.example.android_shixun_mvp_1.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_shixun_mvp_1.ApiService;
import com.example.android_shixun_mvp_1.R;
import com.example.android_shixun_mvp_1.adapter.RlvAdapter;
import com.example.android_shixun_mvp_1.bean.BannerBean;
import com.example.android_shixun_mvp_1.bean.ItemBean;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ShouFragment extends Fragment {
    private RecyclerView mRel;
    private ArrayList<ItemBean.DataBean.DatasBean> itemBeans;
    private ArrayList<BannerBean.DataBean> bannBean;
    private RlvAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_shou, null);
        initView(view);
        initBann();
        initItem();
        return view;
    }

    private void initItem() {
        new Retrofit.Builder()
                .baseUrl(ApiService.sUlr)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class)
                .getItem()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ItemBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ItemBean itemBean) {
                        List<ItemBean.DataBean.DatasBean> datas = itemBean.getData().getDatas();
                        itemBeans.addAll(datas);
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void initBann() {
        new Retrofit.Builder()
                .baseUrl(ApiService.sUlr)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class)
                .getBann()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BannerBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BannerBean bannerBean) {
                        List<BannerBean.DataBean> data = bannerBean.getData();
                        bannBean.addAll(data);
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void initView(@NonNull final View itemView) {
        mRel = (RecyclerView) itemView.findViewById(R.id.rel);
        mRel.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRel.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        itemBeans = new ArrayList<>();
        bannBean = new ArrayList<>();
        adapter = new RlvAdapter(getActivity(), itemBeans, bannBean);
        mRel.setAdapter(adapter);
    }
}
