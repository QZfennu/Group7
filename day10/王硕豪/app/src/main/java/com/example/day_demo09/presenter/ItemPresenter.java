package com.example.day_demo09.presenter;


import com.example.day_demo09.base.BasePresenter;
import com.example.day_demo09.fragment.ItemFragment;
import com.example.day_demo09.model.MainModel;

public class ItemPresenter extends BasePresenter {
    private final ItemFragment itemFragment;
    private final MainModel mainModel;

    public ItemPresenter(ItemFragment itemFragment) {
        super();
        this.itemFragment = itemFragment;
        mainModel = new MainModel();
    }

    @Override
    public void start(Object o[]) {
        super.start();
        Integer id = (Integer) o[0];
        mainModel.getItem(id, new HomePre() {
            @Override
            public void getData(Object o) {
                itemFragment.getData(o);
            }
        });
    }
}
