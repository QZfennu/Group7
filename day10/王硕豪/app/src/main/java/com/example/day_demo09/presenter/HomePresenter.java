package com.example.day_demo09.presenter;


import com.example.day_demo09.base.BasePresenter;
import com.example.day_demo09.fragment.HomeFragment;
import com.example.day_demo09.model.MainModel;

public class HomePresenter extends BasePresenter {
    private final HomeFragment homeFragment;
    private final MainModel mainModel;

    public HomePresenter(HomeFragment homeFragment) {

        this.homeFragment = homeFragment;
        mainModel = new MainModel();
    }

    @Override
    public void start(Object[] t) {
        super.start(t);
        mainModel.getData(new HomePre() {
            @Override
            public void getData(Object o) {
                homeFragment.getData(o);
            }
        });


    }
}
