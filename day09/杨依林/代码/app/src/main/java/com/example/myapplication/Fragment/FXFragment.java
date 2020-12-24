package com.example.myapplication.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication.Api.ApiService;
import com.example.myapplication.Bean.HDBean;
import com.example.myapplication.R;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FXFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FXFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ImageView mPzIv;
    private ImageView mStIv;
    private ImageView mPhbIv;
    private TabLayout mTab;
    private ViewPager mVp;
    private RecyclerView mRecycler;
    private HDAdapter hdAdapter;
    private List<HDBean.DataBean> list;

    public FXFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FXFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FXFragment newInstance(String param1, String param2) {
        FXFragment fragment = new FXFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_f_x, container, false);
        initView(inflate);
        initFragment();
        initData();
        return inflate;
    }

    private void initData() {
        new Retrofit.Builder()
                .baseUrl(ApiService.Url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService.class)
                .getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HDBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HDBean hdBean) {
                        List<HDBean.DataBean> data = hdBean.getData();
                        list.addAll(data);
                        hdAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void initFragment() {
        final List<Fragment> list = new ArrayList<>();
        list.add(new RDFragment());
        list.add(new RDFragment());
        list.add(new RDFragment());

        mVp.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
        mTab.setupWithViewPager(mVp);
        mTab.getTabAt(0).setText("热点");
        mTab.getTabAt(1).setText("妆造");
        mTab.getTabAt(2).setText("图赏");

    }

    private void initView(@NonNull final View itemView) {
        mPzIv = (ImageView) itemView.findViewById(R.id.iv_pz);
        mStIv = (ImageView) itemView.findViewById(R.id.iv_st);
        mPhbIv = (ImageView) itemView.findViewById(R.id.iv_phb);
        mTab = (TabLayout) itemView.findViewById(R.id.tab);
        mVp = (ViewPager) itemView.findViewById(R.id.vp);
        mRecycler = (RecyclerView) itemView.findViewById(R.id.recycler);
        mRecycler.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        list = new ArrayList<>();
        hdAdapter = new HDAdapter(getActivity(),list);
        mRecycler.setAdapter(hdAdapter);
    }
}