package com.example.day05.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day05.R;
import com.example.day05.adpter.Adpter;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private RecyclerView rv_main;
    private Adpter adpter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        rv_main=view.findViewById(R.id.rv_main);
        rv_main.setLayoutManager(new LinearLayoutManager(getContext()));
        ArrayList<Integer> list = new ArrayList<>();
        list.add(R.drawable.a1);
        list.add(R.drawable.a2);
        list.add(R.drawable.a3);
        list.add(R.drawable.c1);
        list.add(R.drawable.h2);
        list.add(R.drawable.g1);
        list.add(R.drawable.d1);
        list.add(R.drawable.f1);
        adpter = new Adpter(getContext(), list);
        rv_main.setAdapter(adpter);
    }
}